package com.hospital;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class DepartmentDAO {
	public void insertDepartment(Department department) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(department);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public Department getDepartmentByName(String departmentName) {
    	Transaction transaction = null;
    	Department entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             transaction = session.beginTransaction();
             String hql = "FROM Department WHERE departmentName = :departmentName";
             Query<Department> query = session.createQuery(hql, Department.class);
             query.setParameter("departmentName", departmentName);
             entity = query.uniqueResult();
             transaction.commit();
        }catch(Exception e) {
        	if(transaction!=null) {
        		transaction.rollback();
        	}
        	e.printStackTrace();
        }
        return entity;
    }
    public Department getDepartmentById(String departmentId) {
    	Transaction transaction = null;
    	Department entity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
             transaction = session.beginTransaction();
             String hql = "FROM Department WHERE departmentId = :departmentId";
             Query<Department> query = session.createQuery(hql, Department.class);
             query.setParameter("departmentId", departmentId);
             entity = query.uniqueResult();
             transaction.commit();
        }catch(Exception e) {
        	if(transaction!=null) {
        		transaction.rollback();
        	}
        	e.printStackTrace();
        }
        return entity;
    }
    public List<Department> fetchAllDepartments() {
    	try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Department", Department.class).list();
        }
    }
}
