package com.tvenger.contacts;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactsApplication.class, args);
	}
}
