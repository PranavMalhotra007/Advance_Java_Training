package com.lpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	public void saveStudent(Student s) {
		studentDao.saveStudent(s);
	}
	public Student findStudent(int id) {
		return studentDao.findStudent(id);
	}
}
