package com.paynav.redis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paynav.redis.entity.Student;
import com.paynav.redis.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public ResponseEntity<String> saveStudent(@RequestBody Student student){
		
		boolean result = studentService.saveStudent(student); 
		if(result) {
			return ResponseEntity.ok("Student Created Successfully");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/student")
	public ResponseEntity<List<Student>> fetchAllStudent(){
		List<Student> students = studentService.fetchAllStudent();
		return ResponseEntity.ok(students);
	}
	
	@GetMapping("/student/{studentId}")
	public ResponseEntity<Student> fetchStudentById(@PathVariable("studentId") Long id){
		Student student = studentService.fetchStudentById(id);
		return ResponseEntity.ok(student);
	}
	
	@DeleteMapping("/student/{studentId}")
	public ResponseEntity<List<Student>> deleteStudent(@PathVariable("id") Long id){
		List<Student> students = studentService.deleteStudentById(id);
		return ResponseEntity.ok(students);
	}
	
	@PatchMapping("/student")
	public ResponseEntity<String> updateStudent(@RequestBody Student student){
		Student stud = studentService.fetchStudentById(student.getStudentId());
		stud.setStudentId(student.getStudentId());
		stud.setStudentName(student.getStudentName());
		boolean result = studentService.saveStudent(stud); 
		if(result) {
			return ResponseEntity.ok("Student Updated");
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	
}
