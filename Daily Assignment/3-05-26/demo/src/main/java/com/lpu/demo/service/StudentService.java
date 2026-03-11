package com.lpu.demo.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	public StudentService() {
		
	}
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	public List<Student> getAllStudents() {
		return studentRepository.getStudentQuery();
	}
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
	}
	public Student getStudentById(int id) {
		/*Optional<Student> optional = studentRepository.findById(id);
		return optional.get();*/
		return studentRepository.findById(id).orElse(null);
	}
	public String deleteStudent(Student s) {
		studentRepository.delete(s);
		return "Studnet deleted";
	}
	public List<Student> saveAllStudents(List<Student> students){
		return studentRepository.saveAll(students);
	}
	public List<Student> getStudentByName(String name){
		return studentRepository.getStudentByName(name);
	}
}
