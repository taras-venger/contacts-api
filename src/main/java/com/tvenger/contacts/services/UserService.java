package com.tvenger.contacts.services;

import com.tvenger.contacts.dtos.RegisterUserRequest;
import com.tvenger.contacts.dtos.UserDto;
import com.tvenger.contacts.exceptions.EmailTakenException;
import com.tvenger.contacts.mappers.UserMapper;
import com.tvenger.contacts.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;


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
        var email = request.getEmail();
        if (userRepository.existsByEmail(email)) {
            throw new EmailTakenException(email);
        }
        var user = userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return userMapper.toDto(user);
    }
}
