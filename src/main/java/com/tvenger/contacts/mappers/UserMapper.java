package com.tvenger.contacts.mappers;

import com.tvenger.contacts.dtos.UserDto;
import com.tvenger.contacts.entities.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);
}
