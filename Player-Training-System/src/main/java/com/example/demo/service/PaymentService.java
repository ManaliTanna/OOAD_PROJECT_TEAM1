package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Payment;
import com.example.demo.repository.PaymentRepo;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepo repo;

	public void pay(Payment payed) {
		repo.save(payed);
	}

	
	 public List<Payment> getAllPayments() { return repo.findAll(); }
	  
	 public Payment getPaymentById(int id) 
	 {
		 Optional<Payment> payed = repo.findById(id);
		 if(payed.isPresent()) 
		 { 
			 return payed.get(); 
			 } 
		 return null; }
	 
	 public void deletePayment(int id) { repo.deleteById(id); }
	 
}
