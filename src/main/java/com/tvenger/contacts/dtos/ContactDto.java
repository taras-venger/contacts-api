package com.tvenger.contacts.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ContactDto {
    Long id;
    String firstName;
    String lastName;
    String email;
    String phone;
    String address;
    Long userId;
    Short groupId;
}
