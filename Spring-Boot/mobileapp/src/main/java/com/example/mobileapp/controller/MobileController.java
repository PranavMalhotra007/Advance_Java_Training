package com.example.mobileapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.mobileapp.DTO.MobileDTO;
import com.example.mobileapp.service.MobileService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/mobiles")
public class MobileController {
	@Autowired
	private MobileService mobileService;
	@PostMapping
	public ResponseEntity<MobileDTO> saveMobile(@Valid @RequestBody MobileDTO m) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(mobileService.saveMobile(m));
	}
	@GetMapping
	public ResponseEntity<List<MobileDTO>> findAllMobiles(){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(mobileService.findAllMobile());
	}
	@GetMapping("/{id}")
	public ResponseEntity<MobileDTO> findMobileById(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(mobileService.findMobileById(id));
	}
	@GetMapping("/search")
	public ResponseEntity<List<MobileDTO>> searchByName(@RequestParam String name){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(mobileService.findMobileByName(name));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMobileById(@RequestParam int id) {
		return ResponseEntity.status(HttpStatus.GONE)
				.body(mobileService.deleteMobileById(id));
	}
	@PutMapping("/{id}")
	public ResponseEntity<MobileDTO> updateMobile(@PathVariable int id, @Valid @RequestBody MobileDTO m){
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(mobileService.updateMobileById(id, m));
	}
}
