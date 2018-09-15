package com.gontuseries.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {

	@Id @GeneratedValue
	private int student_id;
	
	private String student_name;	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<StudentCertification> studentCerification = new HashSet<>(0);

	public Set<StudentCertification> getStudentCerification() {
		return studentCerification;
	}

	public void setStudentCerification(Set<StudentCertification> studentCerification) {
		this.studentCerification = studentCerification;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_name() {
		return student_name;
	}

	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
		

}
