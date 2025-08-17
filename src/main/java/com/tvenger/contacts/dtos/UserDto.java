package com.tvenger.contacts.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
    Long id;
    String name;
    String email;
}
