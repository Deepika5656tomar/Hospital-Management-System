package com.hospital;
import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class PatientDAO {
	public void insertPatient(Patient patient) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Patient> fetchAllPatients() {
    	
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Patient", Patient.class).list();
        }
    }
    public Patient getPatientById(String patientId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Patient.class, patientId);
        }
    }
    public void updatePatientDetails(String patientId, Map<String, Object> updates) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, patientId);
            if (patient != null) {
                updates.forEach((field,value)->{
                	switch(field) {
                	   case "firstname":
                		   patient.setFirstname((String) value); 
                		   break;
                	   case "lastname":
                           patient.setLastname((String) value);
                           break;
                       case "dob":
                           patient.setDob((Date) value);
                           break;
                       case "gender":
                           patient.setGender((String) value);
                           break;
                       case "phone":
                           patient.setPhone((String) value);
                           break;
                       default:
                           System.out.println("Unknown field: " + field);
                	}
                });
                session.update(patient);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deletePatient(String patientId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Patient patient = session.get(Patient.class, patientId);
            if (patient != null) session.delete(patient);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
    
}
