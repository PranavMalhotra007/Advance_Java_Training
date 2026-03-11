package com.lpu.loan_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoanController {
	@GetMapping("/give")
	public String giveLoan() {
		return "Loan is given";
	}
	@GetMapping("/getAccount")
	public String getAccount() {
		return "Account details for Loan application";
	}
	@GetMapping("/verify")
	public String verifyLoan() {
		return "Loan case is verified";
	}
}
