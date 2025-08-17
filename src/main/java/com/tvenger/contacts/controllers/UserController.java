package com.tvenger.contacts.controllers;

import com.tvenger.contacts.dtos.UserDto;
import com.tvenger.contacts.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;

    @GetMapping("/users")
    public Iterable<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserDto(user.getId(), user.getName(), user.getEmail()))
                .toList();
    }
}
