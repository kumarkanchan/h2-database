package com.h2database;

import com.h2database.dao.UserRepository;
import com.h2database.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@ComponentScan({"com.h2database.dao", "com.h2database.entities"})
public class H2DatabaseApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(H2DatabaseApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        //CRUD - Create, Read, Update and Delete
        createUsers(userRepository);
        findUserById(userRepository);
        findAllUsers(userRepository);
        updateUserAgeById(userRepository);
        deleteUserById(userRepository);
    }

    private static void deleteUserById(UserRepository userRepository) {
        int userId = 2;
        System.out.println("Deleting the User where id is : " + userId);
        userRepository.deleteById(userId);
    }

    private static void updateUserAgeById(UserRepository userRepository) {
        int userId = 1;
        int newAge = 35;
        System.out.println("Finding Entities By ID " + userId);
        Optional<User> findById = userRepository.findById(userId);
        User user = findById.get();
        user.setAge(newAge);
        userRepository.save(user);
    }

    private static void findAllUsers(UserRepository userRepository) {
        userRepository.findAll().forEach(System.out::println);
    }

    private static void findUserById(UserRepository userRepository) {
        int userId = 2;
        Optional<User> findById = userRepository.findById(userId);
        User user = findById.get();
        System.out.println(user);
    }

    private static void createUsers(UserRepository userRepository) {
        User kk = new User();
        kk.setName("KANCHAN KUMAR");
        kk.setAge(30);
        kk.setDob(LocalDate.of(1990, Month.DECEMBER, 16));

        User ram = new User();
        ram.setName("RAM KUMAR");
        ram.setAge(35);
        ram.setDob(LocalDate.of(1985, Month.APRIL, 24));

        List<User> userList = new ArrayList<>();
        userList.add(kk);
        userList.add(ram);
        Iterable<User> dbSaveUser = userRepository.saveAll(userList);
        System.out.println("Following User Save into DB");
        dbSaveUser.forEach(System.out::println);
    }
}
