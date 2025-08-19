package com.tvenger.contacts.exceptions;

public class GroupNotFoundException extends RuntimeException {
    public GroupNotFoundException(Short groupId) {
        super("Contact group not found with id: " + groupId);
    }
}
