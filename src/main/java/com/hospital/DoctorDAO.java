package com.hospital;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DoctorDAO {
	public void insertDoctor(Doctor doctor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(doctor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Doctor> fetchAllDoctors() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Doctor", Doctor.class).list();
        }
    }
    public List<Doctor> fetchAllDoctorsWithDepartment(String dept) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        	String hql = "FROM Doctor d JOIN FETCH d.department WHERE d.department.departmentName = :departmentName";
            return session.createQuery(hql, Doctor.class).setParameter("departmentName", dept).list();
        }catch(Exception e) {
        	e.printStackTrace();
        	return null;
        }
    }

    public Doctor getDoctorByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Doctor.class, name);
        }
    }
    public void updateDoctorDetails(String doctorId, Map<String,Object> updatesDoctor) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, doctorId);
            if (doctor != null) {
                 updatesDoctor.forEach((field,value)->{
                	 switch(field) {
                	 case "name":
                		 doctor.setName((String) value);
                		 break;
                	 case "specialization":
                		 doctor.setSpecialization((String) value);
                		 break;
                	 case "phoneno":
                		 doctor.setPhoneno((String) value);
                		 break;
          
                	 }
                	 
                 });
                session.update(doctor);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void deleteDoctor(String doctorId) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Doctor doctor = session.get(Doctor.class, doctorId);
            if (doctor != null) session.delete(doctor);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    
}
