package com.tvenger.contacts.mappers;

import com.tvenger.contacts.dtos.ContactDto;
import com.tvenger.contacts.entities.Contact;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "groupId", source = "contactGroup.id")
    ContactDto toDto(Contact contact);
}
