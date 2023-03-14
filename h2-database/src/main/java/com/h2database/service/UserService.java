package com.h2database.service;

import com.h2database.dao.UserRepository;
import com.h2database.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void deleteUserById(int userId) {
        System.out.println("Deleting the User where id is : " + userId);
        userRepository.deleteById(userId);
    }

    public void updateUserAgeById(int userId, int newAge) {
        System.out.println("Finding Entities By ID " + userId);
        Optional<User> findById = userRepository.findById(userId);
        User user = findById.get();
        user.setAge(newAge);
        userRepository.save(user);
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Integer userId) throws UserDataAccessException {
        if (userId == null) {
            throw new UserDataAccessException("User Id can not be null");
        }
        System.out.println("Finding entity by id " + userId);
        Optional<User> findById = userRepository.findById(userId);

        if (findById.isPresent())
            return findById.get();
        throw new UserDataAccessException("This User Id not found in DB - " + userId);
    }

    public void createUsers(User user) {
        User dbUser = userRepository.save(user);
        System.out.println("Following user save into database");
        System.out.println(dbUser);
    }
}
