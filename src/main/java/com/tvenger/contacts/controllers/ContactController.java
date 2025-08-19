package com.tvenger.contacts.controllers;

import com.tvenger.contacts.dtos.ContactDto;
import com.tvenger.contacts.dtos.CreateContactRequest;
import com.tvenger.contacts.services.ContactService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<ContactDto> getContact(@PathVariable Long id) {
        var contact = contactService.getContact(id);
        if (contact == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ContactDto> deleteContact(@PathVariable Long id) {
        var contact = contactService.getContact(id);
        if (contact == null) {
            return ResponseEntity.notFound().build();
        }
        contactService.deleteContact(id);
        return ResponseEntity.ok(contact);
    }

    @PostMapping
    public ResponseEntity<ContactDto> createContact(
            @RequestBody CreateContactRequest request
            ) {
        Long userId = 111L; // TODO: get userId from request

        var newContact = contactService.createContact(request, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(newContact);
    }
}
