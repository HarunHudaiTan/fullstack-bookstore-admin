package com.project.bookstore.exception;

public class AccountNotFoundException  extends RuntimeException{
    public AccountNotFoundException(String message) {
        super(message);
    }
}
