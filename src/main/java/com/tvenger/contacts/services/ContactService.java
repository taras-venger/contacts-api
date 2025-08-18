package com.tvenger.contacts.services;

import com.tvenger.contacts.dtos.ContactDto;
import com.tvenger.contacts.entities.Contact;
import com.tvenger.contacts.mappers.ContactMapper;
import com.tvenger.contacts.repositories.ContactRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;

    public List<ContactDto> getContacts(Long userId, Short groupId) {
        Specification<Contact> spec = (root, query, cb) -> cb.conjunction();

        if (userId != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("user").get("id"), userId));
        }

        if (groupId != null) {
            spec = spec.and((root, query, cb) ->
                    cb.equal(root.get("contactGroup").get("id"), groupId));
        }

        return contactRepository.findAll(spec)
                .stream()
                .map(contactMapper::toDto)
                .toList();
    }
}
