package com.tvenger.contacts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ContactsController {
    @RequestMapping("/contacts")
    public String index(){
        return "contacts.html";
    }
}
