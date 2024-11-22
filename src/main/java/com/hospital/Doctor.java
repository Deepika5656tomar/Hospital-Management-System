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
	@ManyToOne
	@JoinColumn(name="departmentId")
	private Department department;
	public Doctor() {
		super();
	}
	public Doctor(String doctorId, String name, String specialization, String phone,Department department) {
		super();
		this.doctorId = doctorId;
		this.name = name;
		this.specialization = specialization;
		this.phoneno = phone;
		this.department = department;
	}
	public String getDoctorId() {
		return doctorId;
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
	
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", name=" + name + ", specialization=" + specialization + ", phoneno="
				+ phoneno + ", department=" + department + "]";
	}
	
	
}
