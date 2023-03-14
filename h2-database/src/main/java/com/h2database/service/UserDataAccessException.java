package com.h2database.service;

public class UserDataAccessException extends Throwable {
    public UserDataAccessException(String errorMessage) {
        super(errorMessage);
    }
}
