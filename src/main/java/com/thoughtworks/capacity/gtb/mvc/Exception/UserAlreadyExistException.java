package com.thoughtworks.capacity.gtb.mvc.Exception;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message) {
        super(message);
    }
}
