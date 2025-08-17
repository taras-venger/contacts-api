package com.tvenger.contacts.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "contact_groups")
public class ContactGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Short id;

    @Column(name = "group_name")
    private String groupName;

    @OneToMany(mappedBy = "contactGroup")
    private List<Contact> contacts = new ArrayList<>();
}