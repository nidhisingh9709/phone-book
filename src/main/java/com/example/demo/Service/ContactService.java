package com.example.demo.Service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.ContactInfo;
import com.example.demo.repository.ContactRepository;

@Service
public class ContactService {
	@Autowired
	ContactRepository contactRepository;

	public Iterable<ContactInfo> getContactDetails() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

	public Optional<ContactInfo> getContactDetail(Integer contactId) {
		// TODO Auto-generated method stub
		return contactRepository.findById(contactId);
	}

	@Transactional
	public void saveContact(@Valid ContactInfo c) {
		// TODO Auto-generated method stub
		contactRepository.save(c);
	}
    @Transactional
	public void deleteContact(Integer id) {
		// TODO Auto-generated method stub
		contactRepository.deleteById(id);
	}

    @Transactional
	public ContactInfo updateContact(ContactInfo c) {
		// TODO Auto-generated method stub
		return contactRepository.save(c);
		}
	}


