package com.lpu.demo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("/lpu")
@RestController
public class LpuController {
	@RequestMapping("/m1")
	public String saveM() {
		return "M1 Saved";
	}
	@PostMapping("/student")
	public String saveStudent() {
		return "Student Saved";
	}
	@PostMapping("/trainer")
	public String saveTrainer() {
		return "Trainer Saved";
	}
	@PostMapping("/security")
	public String saveSecurity() {
		return "Security Saved";
	}
}
