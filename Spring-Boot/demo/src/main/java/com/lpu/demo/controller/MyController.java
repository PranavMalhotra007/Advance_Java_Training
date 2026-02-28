package com.lpu.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;

@RestController
public class MyController {
	@GetMapping("/hi")
	public String hi() {
		return "byeeeee";
	}
	//http://localhost:8080/takeData?id=101&name=Raju
	@GetMapping("/takeData")
	public String takeData(@RequestParam int id, @RequestParam String name) {
		return "ID = "+id+" Name = "+name;
	}
	//http://localhost:8080/takeData/101
	@GetMapping("/takeData/{id}")
	public String takeData2(@PathVariable int id) {
		return "ID = "+id;
	}
	//http://localhost:8080/takeData/101/natsu
	@GetMapping("/takeData/{id}/{name}")
	public String takeData3(@PathVariable int id, @PathVariable String name) {
		return "ID = "+id+" Name = "+name;
	}
	//http://localhost:8080/student/101/college/9
	@GetMapping("/student/{id}/college/{cid}")
	public String takeData4(@PathVariable int id, @PathVariable int cid) {
		return "ID = "+id+" College ID = "+cid;
	}
	//http://localhost:8080/takeDataComb/101?name=Ramu
	@GetMapping("/takeDataComb/{id}")
	public String takeData5(@PathVariable int id, @RequestParam String name) {
		return "ID = "+id+" Name = "+name;
	}
	@GetMapping("/takeData2")
	public String takeData6(@RequestHeader int id, @RequestHeader String name) {
		return "ID = "+id+" Name = "+name;
	}
	@GetMapping("/student")
	public String getStudent(@RequestBody Student s) {
		return "ID = "+s.getId()+" Name = "+s.getName();
		
	}
}
