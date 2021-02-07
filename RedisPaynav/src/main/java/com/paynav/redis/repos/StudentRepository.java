package com.paynav.redis.repos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.paynav.redis.entity.Student;

@Repository
public class StudentRepository {

	@Autowired
	private RedisTemplate redisTemplate;

	private static final String KEY = "Student";

	public boolean saveStudent(Student student) {

		try {
			redisTemplate.opsForHash().put(KEY, student.getStudentId().toString(), student);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<Student> fetchAllStudent() {

		List<Student> students = redisTemplate.opsForHash().values(KEY);
		return students;
	}

	public Student fetchStudentById(Long id) {
		try {
		Student stu;
		stu =(Student) redisTemplate.opsForHash().get(KEY, id.toString());
		System.out.println(stu.toString());
		return stu;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Student> deleteStudentById(Long id) {
		redisTemplate.opsForHash().delete(KEY, id);
		List<Student> students = redisTemplate.opsForHash().values(KEY);
		return students;
	}
	
	

}
