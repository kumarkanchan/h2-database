package com.h2database.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    Logger log = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/")
    public String userInfo() {

        return null;
    }
}
