package com.paynav.redis.entity;


import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Student implements Serializable {

	@Id
	private Long studentId;
	private String studentName;

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	


	public Student(Long studentId, String studentName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
	}

	
}
