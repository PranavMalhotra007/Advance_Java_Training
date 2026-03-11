package com.lpu.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.College;
import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.CollegeRepository;

@Service
public class CollegeService {
	@Autowired
	private CollegeRepository collegeRepository;
	public CollegeService() {
		// TODO Auto-generated constructor stub
	}
	public College saveCollege(College c) {
		if (c.getStudents() != null) {
	        for (Student s : c.getStudents()) {
	            s.setCollege(c); 
	        }
	    }
		 return collegeRepository.save(c);
	}
	public String deleteCollege(College c) {
		collegeRepository.delete(c);
		return "College Deleted";
	}
	public College findById(int id) {
		return collegeRepository.findById(id).orElse(null);
	}
}
