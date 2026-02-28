package com.lpu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;
import com.lpu.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;
	@PostMapping("/student")
	public Student save(@RequestBody Student s) {
		return studentService.saveStudent(s);
	}
	@DeleteMapping("/student")
	public String deleteStudent(@RequestParam int id) {
		studentService.deleteStudentById(id);
		return "student deleted";
	}
	@GetMapping("/student/{id}")
	public Student findStudent(@PathVariable int id) {
		return studentService.getStudentById(id);	
	}
	@GetMapping("/student/all")
	public List<Student> allStudents(){
		return studentService.getAllStudents();
	}
	@PostMapping("/student/all")
	public List<Student> saveAllStudnet(@RequestBody List<Student>students){
		return studentService.saveAllStudents(students);
	}
	@DeleteMapping("/student/del")
	public String deleteStudent(@RequestBody Student s) {
		return studentService.deleteStudent(s);
	}
	@GetMapping("/student/{name}")
	public List<Student> getStudentByName(@PathVariable String name) {
		return studentService.getStudentByName(name);
	}
}
