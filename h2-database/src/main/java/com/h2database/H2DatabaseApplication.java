package com.h2database;

import com.h2database.dao.UserRepository;
import com.h2database.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
@SpringBootApplication
public class H2DatabaseApplication {
    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(H2DatabaseApplication.class, args);
        UserRepository userRepository = context.getBean(UserRepository.class);

        createUser(userRepository);
        createUsers(userRepository);
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
    private static void createUser(UserRepository userRepository) {
        User user = new User();
        user.setName("KANCHAN");
        user.setAge(30);
        user.setDob(LocalDate.of(1990, Month.DECEMBER, 16));
        User dbUser = userRepository.save(user);
        System.out.println("Following User Save into DB");
        System.out.println(dbUser);
    }
}
