package com.hospital;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc= new Scanner(System.in);
    	PatientDAO patientDAO= new PatientDAO();
    	DoctorDAO doctorDAO = new DoctorDAO();
    	AppointmentDAO appointmentDAO = new AppointmentDAO();
    	while(true) {
    		System.out.println("1. Register Patient\n2. View Patients\n3. Register doctor\n4. View doctors\n5.make Appointment\n6. View appointment\n7.Update patient details\n8. Delete patient\n9. Update doctor details\n10. delete doctor\n11. Update appointment details\n12. Delete appointment\n13. Exit");
    		int choice = sc.nextInt();
    		
    		switch(choice) {
    		case 1:
    			System.out.print( "Enter Patient ID");
    			String patientId =sc.next();
    			System.out.print( "Enter First Name");
    			String firstname=sc.next();
    			System.out.print( "Enter lastt Name");
    			String lastname=sc.next();
    			System.out.print( "Enter DOB");
    			Date dob=Date.valueOf(sc.next());
    			System.out.print( "Enter Gender");
    			String gender=sc.next();
    			System.out.print( "Enter Phone");
    			String phone=sc.next();
    			patientDAO.insertPatient(new Patient(patientId,firstname,lastname,dob,gender,phone));
    			break;
    		case 2:
    			List<Patient> patients = null;
				try {
					patients = patientDAO.fetchAllPatients();
				} catch (Exception e) {
					e.printStackTrace();
				}
				for (Patient patient : patients) {
					System.out.println(patient);
				}
				break;
				
    		case 3:
    			System.out.print( "Enter Doctor ID");
    			String doctorId =sc.next();
    			System.out.print( "Enter Name");
    			String name=sc.next();
    			System.out.print( "Enter specialization");
    			String specialization=sc.next();
    			System.out.print( "Enter Phone");
    			String phoneno=sc.next();
    			doctorDAO.insertDoctor(new Doctor(doctorId,name,specialization,phoneno));
    			break;
    		case 4:
    			List<Doctor> doctors = null;
				try {
					doctors = doctorDAO.fetchAllDoctors();
				} catch (Exception e) {
					e.printStackTrace();
				}
				for (Doctor doctor : doctors) {
					System.out.println(doctor);
				}
				break;
    		case 5:
    			System.out.print("Enter Appointment ID: ");
                String appointmentId = sc.next();
                System.out.print("Enter Patient ID: ");
                Patient patient = patientDAO.getPatientById(sc.next());
                System.out.print("Enter Doctor ID: ");
                Doctor doctor = doctorDAO.getDoctorById(sc.next());
                System.out.print("Enter Date (yyyy-mm-dd): ");
                Date appointmentDate = Date.valueOf(sc.next());
                System.out.print("Enter Status: ");
                String status = sc.next();
                appointmentDAO.insertAppointment(new Appointment(appointmentId, patient, doctor, appointmentDate, status));
                break;
    		case 6:
    			List<Appointment> appointments = null;
				try {
					appointments = appointmentDAO.fetchAllAppointments();
				} catch (Exception e) {
					e.printStackTrace();
				}
				for (Appointment appointment : appointments) {
					System.out.println(appointment);
				}
				break;
    		case 7:
    			System.out.println("Enter Patient Id to update:");
    			String updatePatientId = sc.next();
    			 Map<String, Object> updatesPatient = new HashMap<>();
    			    while (true) {
    			        System.out.println("Enter field name to update (or type 'done' to finish): ");
    			        String field = sc.next();
    			        if ("done".equalsIgnoreCase(field)) break;

    			        System.out.println("Enter new value for " + field + ": ");
    			        Object value;
    			        
    			        switch (field) {
    			            case "firstName":
    			            	value=sc.next();
    			            	break;
    			            case "lastName":
    			            	value=sc.next();
    			            	break;
    			            case "gender":
    			            	value=sc.next();
    			            	break;
    			            case "phone":
    			                value = sc.next();
    			                break;
    			            case "dob":
    			                System.out.println("Enter Date (yyyy-mm-dd): ");
    			                value = Date.valueOf(sc.next());
    			                break;
    			            default:
    			                System.out.println("Invalid field name.");
    			                continue;
    			        }
    			        updatesPatient.put(field, value);
    			    }
    			patientDAO.updatePatientDetails(updatePatientId, updatesPatient);
    			break;
    		case 8:
    			System.out.println("Enter Patient Id to Delete:");
    			String deletedId = sc.next();
    			patientDAO.deletePatient(deletedId);
    			break;
    		case 9:
    			System.out.println("Enter Doctor Id to update:");
    			String updateDoctorId = sc.next();
    			 Map<String, Object> updatesDoctor = new HashMap<>();
    			    while (true) {
    			        System.out.println("Enter field name to update (or type 'done' to finish): ");
    			        String field = sc.next();
    			        if ("done".equalsIgnoreCase(field)) break;

    			        System.out.println("Enter new value for " + field + ": ");
    			        Object value;
    			        
    			        switch (field) {
    			            case "Name":
    			            	value=sc.next();
    			            	break;
    			            case "specialization":
    			            	value=sc.next();
    			            	break;
    			            case "phone":
    			                value = sc.next();
    			                break;
  
    			            default:
    			                System.out.println("Invalid field name.");
    			                continue;
    			        }
    			        updatesDoctor.put(field, value);
    			    }
    			    doctorDAO.updateDoctorDetails(updateDoctorId,updatesDoctor);
    		case 10:
    			System.out.println("Enter Patient Id to Delete:");
    			String deletedDoctorId = sc.next();
    			patientDAO.deletePatient(deletedDoctorId);
    			break;
    		case 11:
    			System.out.println("Enter Appointment Id to update:");
    			String updateAppointmentId = sc.next();
    			 Map<String, Object> updatesAppointment = new HashMap<>();
    			    while (true) {
    			        System.out.println("Enter field name to update (or type 'done' to finish): ");
    			        String field = sc.next();
    			        if ("done".equalsIgnoreCase(field)) break;

    			        System.out.println("Enter new value for " + field + ": ");
    			        Object value;
    			        
    			        switch (field) {
    			            case "status":
    			            	value=sc.next();
    			            	break;
    			            case "appointmentdate":
    			                value = sc.next();
    			                break;
  
    			            default:
    			                System.out.println("Invalid field name.");
    			                continue;
    			        }
    			        updatesAppointment.put(field, value);
    			    }
    			    appointmentDAO.updateAppointmentDetails(updateAppointmentId,updatesAppointment);
    		case 12:
    			System.out.println("Enter Appointment Id to Delete:");
    			String deletedAppointmentId = sc.next();
    			appointmentDAO.deleteAppointment(deletedAppointmentId);
    			break;
    		case 13:
    			System.out.println("Exiting....");
    			sc.close();
    			System.exit(0);
				
    		}
    		
    	}
    }
}
