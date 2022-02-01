package com.example.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.sun.istack.NotNull;

@Entity
public class ContactInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "contact_id")
	private Integer contactId;

	@NotBlank
	@Column(name = "first_name")
	@Size(min = 4, max = 15, message = "Name should have atleast 4 letters")
	private String name;

	@NotBlank
	@Column(name = "last_name")
	@Size(min = 4, max = 15)
	private String surname;

	@Email
	private String email;

	@NotBlank
	@Size(max=50)
	private String address;

	@NotBlank
	@NotNull
	@Size(max = 25)
	@Pattern(regexp = "^[a-zA-Z ]+$")
	private String city;

	@Pattern(regexp = "^[0-9]+$")
	@Size(min = 6)
	private String pin;
	
	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinColumn(name = "fk_mobile_id", referencedColumnName = "id")
    MobileNumber mobileNumber;

	public ContactInfo(Integer contactId,
			@NotBlank @Size(min = 4, max = 15, message = "Name should have atleast 4 letters") String name,
			@NotBlank @Size(min = 4, max = 15) String surname, @Email String email,
			@NotBlank @Pattern(regexp = "^[A-Za-z0-9 ]* $") String address,
			@Pattern(regexp = "^[A-Za-z0-9 ]* $") String city,
			@Pattern(regexp = "^[0-9]+$") @Size(min = 8) String pin) {
		super();
		this.contactId = contactId;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.address = address;
		this.city = city;
		this.pin = pin;
	}

	
	public MobileNumber getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(MobileNumber mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

}
