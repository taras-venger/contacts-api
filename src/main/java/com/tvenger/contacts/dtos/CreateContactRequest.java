package com.tvenger.contacts.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateContactRequest {
    @Size(max = 255, message = "Name must be less than 255  characters")
    private String firstName;

    @Size(max = 255, message = "Last name must be less than 255  characters")
    private String lastName;

    @Size(max = 255, message = "Phone must be less than 255  characters")
    private String phone;

    @Email(message = "Email must be valid")
    private String email;

    @Size(max = 255, message = "Address must be less than 255  characters")
    private String address;

    private Short groupId;
}
