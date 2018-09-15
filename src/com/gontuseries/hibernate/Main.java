package com.gontuseries.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {				
		Student student = new Student();
		student.setStudent_name("Gontu1");			
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();				
		
		student.setStudent_name("Before Save");
		
		session.save(student);
		
		student.setStudent_name("After Save");
		
		session.getTransaction().commit();
		session.close();
//		sessionFactory.close();
	}

}
