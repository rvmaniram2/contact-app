package com.contact.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.contact.module.Contact;
import com.contact.repository.ContactRepository;
import com.contact.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repo;

	@Override
	public boolean saveContact(Contact contact) {
		Contact c = repo.save(contact);

		if (c != null)
			return true;

		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		return repo.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> con = repo.findById(contactId);
		if (con.isPresent())
			return con.get();

		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		Optional<Contact> con = repo.findById(contactId);
		if (con.isEmpty())
			return false;

		Contact c = con.get();
		c.setStatus("N");
		return true;
	}

}
