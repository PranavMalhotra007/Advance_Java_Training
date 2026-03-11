package com.lpu.payment.service;

import org.springframework.stereotype.Service;

import com.lpu.payment.entity.Payment;
import com.lpu.payment.repository.PaymentRepository;

@Service
public class PaymentService {
	private PaymentRepository paymentRepository;

	public PaymentService(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}
	public Payment findById(int id) {
		 return paymentRepository.findById(id).orElse(null);
	 }
	 public Payment save(Payment p) {
		 return paymentRepository.save(p);
	 }
}
