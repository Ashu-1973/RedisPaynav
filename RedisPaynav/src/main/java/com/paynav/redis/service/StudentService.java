package com.paynav.redis.service;

import java.util.List;

import com.paynav.redis.entity.Student;

public interface StudentService {

	boolean saveStudent(Student student);

	List<Student> fetchAllStudent();

	Student fetchStudentById(Long id);

	List<Student> deleteStudentById(Long id);
	
	

}
