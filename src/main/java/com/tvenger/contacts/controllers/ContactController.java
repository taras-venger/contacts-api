package com.tvenger.contacts.controllers;

import com.tvenger.contacts.dtos.ContactDto;
import com.tvenger.contacts.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    @GetMapping
    public List<ContactDto> getContacts(
            @RequestParam(name = "userId", required = false) Long userId,
            @RequestParam(name = "groupId", required = false) Short groupId
    ) {
        return contactService.getContacts(userId, groupId);
    }
}
