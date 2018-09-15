package com.gontuseries.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		StudentCertification studentCertification1 = new StudentCertification();
		studentCertification1.setCertification_name("Core Java");
		
		StudentCertification studentCertification2 = new StudentCertification();
		studentCertification2.setCertification_name("Oracle DB");
		
		Student student1 = new Student();
		student1.setStudent_name("Gontu1");
		(student1.getStudentCerification()).add(studentCertification1);
		
		Student student2 = new Student();
		student2.setStudent_name("Gontu2");
		(student2.getStudentCerification()).add(studentCertification2);			
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(student1);
		session.save(student2);		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
