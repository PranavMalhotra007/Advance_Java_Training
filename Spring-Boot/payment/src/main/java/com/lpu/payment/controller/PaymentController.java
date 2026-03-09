package com.lpu.payment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.lpu.payment.entity.Payment;
import com.lpu.payment.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	@GetMapping("/find/{id}")
	public Payment findByid(@PathVariable int id) {
		return paymentService.findById(id);
	}
	@PostMapping("/save")
	public Payment savePayment(@RequestBody Payment p) {
		return paymentService.save(p);
	}
}
