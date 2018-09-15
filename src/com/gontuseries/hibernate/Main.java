package com.gontuseries.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class Main {

	public static void main(String[] args) {
		Student student = new Student();
		student.setStudent_name("Gontu1");
		
		StudentDetail studentDetail = new StudentDetail();
		studentDetail.setStudent_mobile_number("99XXX60XXX");
		
		studentDetail.setStudent(student);			
		
		SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(studentDetail);		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
