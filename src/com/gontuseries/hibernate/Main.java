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
		
		student = (Student) session.get(Student.class, 1);
		System.out.println("Student name:" + student.getStudent_name());
		
//		student.setStudent_name("Gontu1 modified");
//		session.update(student);
		session.delete(student);
		
//		session.save(student);		
		
		session.getTransaction().commit();
		session.close();
//		sessionFactory.close();
	}

}
