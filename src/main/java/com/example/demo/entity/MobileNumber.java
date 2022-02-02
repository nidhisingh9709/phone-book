package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
public class MobileNumber {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	@NotBlank
	@Column(name="personal_mobile_no")
	@Pattern(regexp="(^[0-9]{10}$)")
	private String personalNumber;
	
	
	@Pattern(regexp="(^$|[0-9]{10})")
	@Column(name= "Home_mobile_No")
	private String homePhoneNumber;
	
	@Pattern(regexp="(^$|[0-9]{10})")
	@Column(name="Office_phone_No")
	private String workPhoneNumber;
	
	@OneToOne(mappedBy="mobileNumber")
	private ContactInfo contactInfo;

	public MobileNumber() {
		
	}
	
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public MobileNumber(Integer id, @Pattern(regexp = "[+]91[0-9]{9}") String personalNumber,
			@Pattern(regexp = "[+]91[0-9]{9}") String homePhoneNumber,
			@Pattern(regexp = "[+]91[0-9]{9}") String workPhoneNumber) {
		super();
		this.id = id;
		this.personalNumber = personalNumber;
		this.homePhoneNumber = homePhoneNumber;
		this.workPhoneNumber = workPhoneNumber;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(String personalNumber) {
		this.personalNumber = personalNumber;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}
	


	
}
