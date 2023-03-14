package com.h2database;

import com.h2database.entities.User;
import com.h2database.service.UserDataAccessException;
import com.h2database.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan({"com.h2database.dao", "com.h2database.entities", "com.h2database.service"})
public class H2DatabaseApplication {
    public static void main(String[] args) throws UserDataAccessException {

        ConfigurableApplicationContext context = SpringApplication.run(H2DatabaseApplication.class, args);
        UserService userService = context.getBean(UserService.class);

        //CRUD - Create, Read, Update and Delete
        userService.createUsers(getUser());

        User user = userService.findUserById(1);
        System.out.println(user);

        userService.findAllUsers().forEach(System.out::println);
        userService.updateUserAgeById(1, 35);
        userService.deleteUserById(2);
    }

    private static List<User> getUserList() {
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
        return userList;
    }

    private static User getUser() {
        User ss = new User();
        ss.setName("SS Master");
        ss.setAge(30);
        ss.setDob(LocalDate.of(1998, Month.DECEMBER, 20));
        return ss;
    }
}
