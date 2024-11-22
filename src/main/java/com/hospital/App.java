package com.hospital;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;



public class App 
{
	private static PatientDAO patientDAO= new PatientDAO();
	private static DoctorDAO doctorDAO = new DoctorDAO();
	private static AppointmentDAO appointmentDAO = new AppointmentDAO();
	private static DepartmentDAO departmentDAO = new DepartmentDAO();
	private static Scanner sc= new Scanner(System.in);
    public static void main( String[] args )
    {
    	while(true) {
    		displayMainMenu();
    		System.out.println("Enter your choice:");
    		int choice = sc.nextInt();
    		switch (choice) {
            case 1:
                handlePatientOperations();
                break;
            case 2:
                handleDoctorOperations();
                break;
            case 3:
                handleAppointmentOperations();
                break;
            case 4:
                handleDepartmentOperations();
                break;
            case 5:
                System.out.println("Exiting...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
            } 
    	}
    }
    private static void displayMainMenu() {
        System.out.println("\n--- Hospital Management System ---");
        System.out.println("1. Patient Menu");
        System.out.println("2. Doctor Menu");
        System.out.println("3. Appointment Menu");
        System.out.println("4. Department Menu");
        System.out.println("5. Exit");
    }
    private static void handlePatientOperations() {
        while (true) {
            System.out.println("\n--- Patient Management ---");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Patient");
            System.out.println("4. Delete Patient");
            System.out.println("5. Back to Main Menu");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();           
            switch (choice) {
                case 1:
                	System.out.print( "Enter Patient ID");
        			String patientId =sc.next();
        			System.out.print( "Enter First Name");
        			String firstname=sc.next();
        			System.out.print( "Enter last Name");
        			String lastname=sc.next();
        			System.out.print( "Enter DOB");
        			Date dob=Date.valueOf(sc.next());
        			System.out.print( "Enter Gender");
        			String gender=sc.next();
        			System.out.print( "Enter Phone");
        			String phone=sc.next();
        			patientDAO.insertPatient(new Patient(patientId,firstname,lastname,dob,gender,phone));
        			System.out.println("Patient details inserted successfully.");
                    break;
                case 2:
                	List<Patient> patients = null;
    				try {
    					patients = patientDAO.fetchAllPatients();
    				} catch (Exception e) {
    					e.printStackTrace();
    					System.out.println("No Patient found with this ID.");
    				}
    				for (Patient patient : patients) {
    					System.out.println(patient);
    				}
                    break;
                case 3:
                	System.out.println("Enter Patient Id to update:");
        			String updatePatientId = sc.next();
        			 Map<String, Object> updatesPatient = new HashMap<>();
        			    while (true) {
        			    	System.out.println("(firstName,lastName,gender,phone,dob)");
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
        			System.out.println("Patient details updated successfully.");
        			break;
                case 4:
                	System.out.println("Enter Patient Id to Delete:");
        			String deletedId = sc.next();
        			patientDAO.deletePatient(deletedId);
        			System.out.println("Patient details deleted successfully.");
        			break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void handleDoctorOperations() {
        while (true) {
            System.out.println("\n--- Doctor Management ---");
            System.out.println("1. Add Doctor");
            System.out.println("2. View All Doctors");
            System.out.println("3. Update Doctor");
            System.out.println("4. Delete Doctor");
            System.out.println("5. View Doctors by Department");
            System.out.println("6. Back to Main Menu");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                	System.out.print( "Enter Doctor ID");
        			String doctorId =sc.next();
        			System.out.print( "Enter Name");
        			String name=sc.next();
        			System.out.print( "Enter specialization");
        			String specialization=sc.next();
        			System.out.print( "Enter Phone");
        			String phoneno=sc.next();
        			System.out.print( "Enter Department Name");
        			String departmentName=sc.next();
        			Department department = departmentDAO.getDepartmentByName(departmentName);
        			doctorDAO.insertDoctor(new Doctor(doctorId,name,specialization,phoneno,department));
        			System.out.println("Doctor details inserted successfully.");
        			break;
                case 2:
                	List<Doctor> doctors = null;
    				try {
    					doctors = doctorDAO.fetchAllDoctors();
    				} catch (Exception e) {
    					e.printStackTrace();
    					System.out.println("No Doctor found.");
    				}
    				for (Doctor doctor : doctors) {
    					System.out.println(doctor);
    				}
    				break;
                case 3:
                	System.out.println("Enter Doctor Id to update:");
        			String updateDoctorId = sc.next();
        			 Map<String, Object> updatesDoctor = new HashMap<>();
        			    while (true) {
        			    	System.out.println("(name,specialization,phoneno)");
        			        System.out.println("Enter field name to update (or type 'done' to finish): ");
        			        String field = sc.next();
        			        if ("done".equalsIgnoreCase(field)) break;

        			        System.out.println("Enter new value for " + field + ": ");
        			        Object value;
        			        
        			        switch (field) {
        			            case "name":
        			            	value=sc.next();
        			            	break;
        			            case "specialization":
        			            	value=sc.next();
        			            	break;
        			            case "phoneno":
        			                value = sc.next();
        			                break;
        			            default:
        			                System.out.println("Invalid field name.");
        			                continue;
        			        }
        			        updatesDoctor.put(field, value);
        			    }
        			    doctorDAO.updateDoctorDetails(updateDoctorId,updatesDoctor);
        			    System.out.println("Doctor details updated successfully.");
        			    break;
                case 4:
                	System.out.println("Enter Doctor Id to Delete:");
        			String deletedDoctorId = sc.next();
        			doctorDAO.deleteDoctor(deletedDoctorId);
        			System.out.println("Doctor details deleted successfully.");
        			break;
                case 5:
                	System.out.println("Enter Department to see Doctors: ");
                	String deptName= sc.next();
                	List<Doctor> doctorsByDept=doctorDAO.fetchAllDoctorsWithDepartment(deptName);
                	if (doctorsByDept != null && !doctorsByDept.isEmpty()) {
                        System.out.println("Doctors in Department Name " + deptName + ":");
                        for (Doctor doc : doctorsByDept) {
                            System.out.println(doc);
                        }
                    } else {
                        System.out.println("No doctors found in this department.");
                    }
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void handleAppointmentOperations() {
        while (true) {
            System.out.println("\n--- Appointment Management ---");
            System.out.println("1. Add Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Update Appointment");
            System.out.println("4. Delete Appointment");
            System.out.println("5. Back to Main Menu");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                	System.out.print("Enter Appointment ID: ");
                    String appointmentId = sc.next();
                    System.out.print("Enter Patient ID: ");
                    Patient patient = patientDAO.getPatientById(sc.next());
                    System.out.print("Enter Doctor Id: ");
                    Doctor doctor = doctorDAO.getDoctorByName(sc.next());
                    System.out.print("Enter Date (yyyy-mm-dd): ");
                    Date appointmentDate = Date.valueOf(sc.next());
                    System.out.print("Enter Status: ");
                    String status = sc.next();
                    appointmentDAO.insertAppointment(new Appointment(appointmentId, patient, doctor, appointmentDate, status));
                    System.out.println("Appointment scheduled.");
                    break;
                case 2:
                	List<Appointment> appointments = null;
    				try {
    					appointments = appointmentDAO.fetchAllAppointments();
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    				if(appointments!=null && !appointments.isEmpty()) {
    					for (Appointment appointment : appointments) {
        					System.out.println(appointment);
        				}
    				}else {
    					System.out.println("No appointment scheduled.");
    				}
    				
    				break;
                case 3:
                	System.out.println("Enter Appointment Id to update:");
        			String updateAppointmentId = sc.next();
        			 Map<String, Object> updatesAppointment = new HashMap<>();
        			    while (true) {
        			    	System.out.println("(status,appointmentdate)");
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
        			    System.out.println("Appointment details updated.");
                        break;
                case 4:
                	System.out.println("Enter Appointment Id to Delete:");
        			String deletedAppointmentId = sc.next();
        			appointmentDAO.deleteAppointment(deletedAppointmentId);
        			System.out.println("Appointment deleted successfully.");
        			break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    private static void handleDepartmentOperations() {
        while (true) {
            System.out.println("\n--- Department Management ---");
            System.out.println("1. Add Department");
            System.out.println("2. View All Departments");
            System.out.println("3. View department by Id");
            System.out.println("4. Back to Main Menu");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                	System.out.println("Enter Department Id: ");
                	String departmentId = sc.next();	
                	System.out.println("Enter Department Name: ");
                	String departmentName = sc.next();
                	Department department = new Department(departmentId, departmentName);
                	departmentDAO.insertDepartment(department);
                	System.out.println("Department added successfully.");
                	break;
                case 2:
                	List<Department> departments = null;
    				try {
    					departments = departmentDAO.fetchAllDepartments();
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    				for (Department dept : departments) {
    					System.out.println(dept);
    				}
    				break;
                case 3:
                	System.out.println("Enter id to see deaprtment: ");
                	String deptId= sc.next();
                	Department dept=departmentDAO.getDepartmentById(deptId);
                	System.out.println(dept);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
