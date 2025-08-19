package com.tvenger.contacts.repositories;

import com.tvenger.contacts.entities.ContactGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContactGroupRepository extends JpaRepository<ContactGroup, Short>, JpaSpecificationExecutor<ContactGroup> {
}
