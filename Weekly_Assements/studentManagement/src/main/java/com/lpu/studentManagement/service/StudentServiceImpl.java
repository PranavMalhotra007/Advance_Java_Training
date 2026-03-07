package com.lpu.studentManagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lpu.studentManagement.entity.FileData;
import com.lpu.studentManagement.entity.Student;
import com.lpu.studentManagement.exception.StudentNotFoundException;
import com.lpu.studentManagement.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{
	private final StudentRepository studentRepository;
	private final PasswordEncoder passwordEncoder;
	
	
	public StudentServiceImpl(StudentRepository studentRepository, PasswordEncoder passwordEncoder) {
		super();
		this.studentRepository = studentRepository;
		this.passwordEncoder = passwordEncoder;
	}
	@Override
	public Student saveStudent(Student s) {
		String encodedPassword = passwordEncoder.encode(s.getPassword());
		s.setPassword(encodedPassword);
		return studentRepository.save(s);
	}
	@Override
	@Cacheable(value="student", key = "#id")
	public Student findById(int id) {
		Optional<Student> s = studentRepository.findById(id);
		if(s.isPresent()) {
			return s.get();
		}
		throw new StudentNotFoundException("Student with Id = "+id+ " does not exist");
	}
	@Override
	public List<Student> allstudents(){
		List<Student>students = studentRepository.findAll();
		if(!students.isEmpty()) {
			return students;
		}
		throw new StudentNotFoundException("Database is Empty");
	}
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteStudent(int id) {
		findById(id);
		studentRepository.deleteById(id);
		return "student deleted";
	}
	@Override
	@PreAuthorize("hasRole('ADMIN')")
	public Student updateStudent(Student s) {
		findById(s.getId());
		return studentRepository.save(s);	
	}
	@Override
	@PostAuthorize("retrunObject.name == authentication.name")
	public String uploadProfilePic(int id, FileData profilePic) {
		// TODO Auto-generated method stub
		Student s = findById(id);
		s.setProfileImage(profilePic);
		return "profile pic uploaded";
	}
	@Override
	@PostAuthorize("retrunObject.name == authentication.name")
	public String uploadAssignment(int id, FileData assignment) {
		Student s = findById(id);
		s.setAssignmentFile(assignment);
		return "assignment file uploaded";
	}
	@Override
	@PostAuthorize("retrunObject.name == authentication.name")
	public byte[] downloadAssignmentFile(int id) {
		Student s = findById(id);
		return s.getAssignmentFile().getData();
	}
	@Override
	@PostAuthorize("retrunObject.name == authentication.name")
	public byte[] downloadProfileImage(int id) {
		Student s = findById(id);
		return s.getProfileImage().getData();
	}
}
