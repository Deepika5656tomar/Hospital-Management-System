package com.hospital;
import javax.persistence.*;

@Entity
@Table (name="Doctor")
public class Doctor {
	@Id
	private String doctorId;
	private String name;
	private String specialization;
	private String phoneno;
	
	public String getDoctorId() {
		return doctorId;
	}
	
	
	
	public Doctor() {
		super();
	}



	public Doctor(String doctorId, String name, String specialization, String phone) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.specialization = specialization;
		this.phoneno = phone;
	}


	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	public String getPhone() {
		return phoneno;
	}
	public void setPhone(String phone) {
		this.phoneno = phone;
	}
	
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialization=" + specialization + ", phone="
				+ phoneno + "]";
	}
	
	
}
