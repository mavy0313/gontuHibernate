package com.gontuseries.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
//		Transient
		Student student = null;
//		student.setStudent_name("Gontu1");			
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session1 = sessionFactory.openSession();
		session1.beginTransaction();				
		
//		student.setStudent_name("Before Save");
//		Persistent
		student = (Student) session1.get(Student.class, 2);
		System.out.println("Student name: " + student.getStudent_name());		
		
		session1.getTransaction().commit();
		session1.close();
//		Detached
//		sessionFactory.close();
		
		student.setStudent_name("Modified in detached state");
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();				
		
//		student.setStudent_name("Before Save");
//		Persistent
		session2.update(student);		
		
		session2.getTransaction().commit();
		session2.close();
	}

}
