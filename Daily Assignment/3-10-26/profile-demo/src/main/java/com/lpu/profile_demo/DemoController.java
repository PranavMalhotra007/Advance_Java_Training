package com.lpu.profile_demo;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DemoController {
	@GetMapping("/rt")
	public ResponseEntity<String> takeDataFromUser(){
		String url = "http://localhost:8081/user/data";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.GET,null,String.class);
		return responseEntity;
	}
	@GetMapping("/rt/all")
	public ResponseEntity<String> DataFromUser(){
	    String url = "http://localhost:8081/user/find/all";
	    RestTemplate template = new RestTemplate();
	    ResponseEntity<String> responseEntity =
	            template.exchange(url, HttpMethod.GET, null, String.class);
	    return responseEntity;
	}
	@GetMapping("/rt/{id}")
	public ResponseEntity<String> FromUser(@PathVariable int id){
		String url = "http://localhost:8081/user/find/"+id;
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> responseEntity = template.exchange(url, HttpMethod.GET,null,String.class);
		return responseEntity;
	}
	@PostMapping("/rt/save")
	public ResponseEntity<Customer> saveUser(@RequestBody Customer customer){
		String url = "http://localhost:8081/user/save";
		RestTemplate template = new RestTemplate();
		HttpEntity<Customer> request = new HttpEntity<>(customer);
		ResponseEntity<Customer> responseEntity = template.exchange(url, HttpMethod.POST,request,Customer.class);
		return responseEntity;
	}
}
