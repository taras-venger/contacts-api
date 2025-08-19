package com.tvenger.contacts.services;

import com.tvenger.contacts.dtos.ContactDto;
import com.tvenger.contacts.dtos.CreateContactRequest;
import com.tvenger.contacts.entities.Contact;
import com.tvenger.contacts.entities.ContactGroup;
import com.tvenger.contacts.entities.User;
import com.tvenger.contacts.exceptions.GroupNotFoundException;
import com.tvenger.contacts.exceptions.UserNotFoundException;
import com.tvenger.contacts.mappers.ContactMapper;
import com.tvenger.contacts.repositories.ContactGroupRepository;
import com.tvenger.contacts.repositories.ContactRepository;
import com.tvenger.contacts.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ContactService {
    private final ContactRepository contactRepository;
    private final ContactMapper contactMapper;
    private final UserRepository userRepository;
    private final ContactGroupRepository contactGroupRepository;

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

    public ContactDto getContact(Long id) {
        return contactRepository.findById(id)
                .map(contactMapper::toDto)
                .orElse(null);
    }

    public void deleteContact(Long id) {
         contactRepository.deleteById(id);
    }

    public ContactDto createContact(CreateContactRequest request, Long userId) {
        var user = userRepository
                .findById(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));

        var contact = contactMapper.toEntity(request);

        contact.setUser(user);

        if (request.getGroupId() != null) {
            var group = contactGroupRepository
                    .findById(request.getGroupId())
                    .orElseThrow(() -> new GroupNotFoundException(request.getGroupId()));

            contact.setContactGroup(group);
        }

        var savedContact = contactRepository.save(contact);
        return contactMapper.toDto(savedContact);
    }
}
