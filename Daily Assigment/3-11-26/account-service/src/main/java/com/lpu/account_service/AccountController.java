package com.lpu.account_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {
	@GetMapping("/save")
	public String saveAccount() {
		return "Account created";
	}
	@GetMapping("/delete")
	public String deleteAccount() {
		return "Account deleated";
	}
}
