package com.tvenger.contacts.exceptions;

public class EmailTakenException extends RuntimeException {
    public EmailTakenException(String email) {
        super("Email is already registered: " + email);
    }
}

