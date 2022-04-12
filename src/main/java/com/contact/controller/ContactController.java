package com.contact.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contact.module.Contact;
import com.contact.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService service;

	@PostMapping("/contact")
	public String addContact(Contact contact) {
		return (service.saveContact(contact) ? "Contact Saved" : "Failed to add Contact");
	}

	@GetMapping("/contacts")
	public List<Contact> getContacts() {
		return service.getAllContacts();
	}

	@GetMapping("/contact{id}")
	public Contact getContact(@PathVariable("id") Integer id) {
		return service.getContactById(id);
	}

	@DeleteMapping("/contact{id}")
	public String deleteContact(@PathVariable("id") Integer id) {
		return (service.deleteContactById(id) ? "Contact Deleted" : "Failed to delete");
	}

}
