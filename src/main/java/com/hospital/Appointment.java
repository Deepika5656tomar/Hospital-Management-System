package com.hospital;
import javax.persistence.*;
import java.sql.Date;
@Entity
@Table (name="Appointment")
public class Appointment {
	@Id
	private String appointmentId;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	private Date appointmentDate;
	private String status;
	public String getAppointmentId() {
		return appointmentId;
	}
	
	public Appointment() {
		super();
	}

	public Appointment(String appointmentId, Patient patient, Doctor doctor, Date appointmentDate, String status) {
		super();
		this.appointmentId = appointmentId;
		this.patient = patient;
		this.doctor = doctor;
		this.appointmentDate = appointmentDate;
		this.status = status;
	}
	
	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Doctor getDoctor() {
		return doctor;
	}
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Appointment [appointmentId=" + appointmentId + ", patient=" + patient + ", doctor=" + doctor
				+ ", appointmentDate=" + appointmentDate + ", status=" + status + "]";
	}
	
	
}
