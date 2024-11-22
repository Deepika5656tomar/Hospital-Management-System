package com.hospital;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table (name="Patient")
public class Patient {
	@Id
	private String patientId;
	private String firstname;
	private String lastname;
	private Date dob;
	private String gender;
	private String phone;
	
	public Patient() {
		super();
	}
	public Patient(String patientId, String firstname, String lastname, Date dob, String gender, String phone) {
		super();
		this.patientId = patientId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
	}
	public String getPatientId() {
		return patientId;
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstname=" + firstname + ", lastname=" + lastname + ", dob="
				+ dob + ", gender=" + gender + ", phone=" + phone + "]";
	}
	
	
}
