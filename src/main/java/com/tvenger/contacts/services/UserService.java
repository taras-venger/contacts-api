package com.tvenger.contacts.services;

import com.tvenger.contacts.dtos.RegisterUserRequest;
import com.tvenger.contacts.dtos.UserDto;
import com.tvenger.contacts.mappers.UserMapper;
import com.tvenger.contacts.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> getUsers() {
        return userRepository
                .findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    public UserDto getUserById(Long id) {
        return userRepository
                .findById(id)
                .map(userMapper::toDto)
                .orElse(null); // service returns null if not found
    }

    public UserDto registerUser(RegisterUserRequest request) {
        var user = userMapper.toEntity(request);
        userRepository.save(user);
        return userMapper.toDto(user);
    }

    public boolean isUserRegistered(String email) {
        return userRepository.existsByEmail(email);
    }
}
