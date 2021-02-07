package com.paynav.redis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paynav.redis.entity.Student;
import com.paynav.redis.repos.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public boolean saveStudent(Student student) {
		return studentRepository.saveStudent(student);
	}

	@Override
	public List<Student> fetchAllStudent() {
		return studentRepository.fetchAllStudent();
	}

	@Override
	public Student fetchStudentById(Long id) {
		return studentRepository.fetchStudentById(id);
	}

	@Override
	public List<Student> deleteStudentById(Long id) {
		// TODO Auto-generated method stub
		return studentRepository.deleteStudentById(id);
		
	}

}
