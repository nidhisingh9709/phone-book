package com.example.demo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.ContactService;
import com.example.demo.entity.ContactInfo;



@RestController
public class ContactController {

	@Autowired
	ContactService contactService;

	//Fetch contact details
	@GetMapping("/Contact-info")
	public Iterable <ContactInfo> getDetails(){
		return contactService.getContactDetails();
	}
	

	@GetMapping("/{contactId}/Contact-info")
	public Optional<ContactInfo> getDetails(@PathVariable("contactId") Integer contactId){
		return contactService.getContactDetail(contactId);
	}
	
	//create new contact
	@PostMapping("/Contact-info") 
	@ResponseStatus(code=HttpStatus.CREATED)
	public void createContact(@RequestBody @Valid ContactInfo c) {
		contactService.saveContact(c);
	}
    //Delete Records
	@DeleteMapping("/{contactId}/Contact-info")
	public void deleteContact(@PathVariable("contactId") Integer contactId) {
		// TODO Auto-generated method stub
        contactService.deleteContact(contactId);
	}
	
	//update
	@PutMapping("/Contact-info")
	public ContactInfo updateContact(@RequestBody ContactInfo c) {
		return contactService.updateContact(c);
	
	}
}
