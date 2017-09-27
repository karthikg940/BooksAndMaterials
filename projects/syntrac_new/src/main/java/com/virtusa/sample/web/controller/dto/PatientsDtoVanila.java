package com.virtusa.sample.web.controller.dto;

import javax.validation.constraints.NotNull;

import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@Component
public class PatientsDtoVanila {

	@NotNull
	private String firstName;
	
	@NotNull
	private String lastName;
	
	private DateTime dob;
	
	private Double weight;
	
	private Long mrn;
	
	private String gender;
	
	private String phone1;
	
	private String phone2;
	
	private String line1;
	
	private String line2;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private String email;
	
	private String maritalStatus;
	
	public PatientsDtoVanila() {
		
	}
	
	public PatientsDtoVanila(String firstName, String lastName, DateTime dob,
			Double weight, Long mrn, String gender, String phone1, String phone2,
			String line1, String line2, String city, String state, String zip,
			String email, String maritalStatus) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.weight = weight;
		this.mrn = mrn;
		this.gender = gender;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.line1 = line1;
		this.line2 = line2;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.email = email;
		this.maritalStatus = maritalStatus;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the dob
	 */
	public DateTime getDob() {
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(DateTime dob) {
		this.dob = dob;
	}
	/**
	 * @return the weight
	 */
	public Double getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	/**
	 * @return the mrn
	 */
	public Long getMrn() {
		return mrn;
	}
	/**
	 * @param mrn the mrn to set
	 */
	public void setMrn(Long mrn) {
		this.mrn = mrn;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the phone1
	 */
	public String getPhone1() {
		return phone1;
	}
	/**
	 * @param phone1 the phone1 to set
	 */
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	/**
	 * @return the phone2
	 */
	public String getPhone2() {
		return phone2;
	}
	/**
	 * @param phone2 the phone2 to set
	 */
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	/**
	 * @return the line1
	 */
	public String getLine1() {
		return line1;
	}
	/**
	 * @param line1 the line1 to set
	 */
	public void setLine1(String line1) {
		this.line1 = line1;
	}
	/**
	 * @return the line2
	 */
	public String getLine2() {
		return line2;
	}
	/**
	 * @param line2 the line2 to set
	 */
	public void setLine2(String line2) {
		this.line2 = line2;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * @param zip the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the maritalStatus
	 */
	public String getMaritalStatus() {
		return maritalStatus;
	}
	/**
	 * @param maritalStatus the maritalStatus to set
	 */
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
}
