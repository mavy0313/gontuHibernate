package com.gontuseries.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		Student_Info student = new Student_Info();
		student.setName("Gontu");
		student.setRollNo(1);
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
