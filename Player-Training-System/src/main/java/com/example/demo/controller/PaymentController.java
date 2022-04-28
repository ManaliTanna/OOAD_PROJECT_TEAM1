package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.Payment;
import com.example.demo.entity.Player;
import com.example.demo.service.PaymentService;
import com.example.demo.service.PlayerService;

import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class PaymentController {
	
	@Autowired
	private PaymentService payService;
	
	
	/*
	 * @GetMapping("/payment") public String paymentForm() { return "payment"; }
	 */
	
	@PostMapping("/pay")
	public String examPay(@ModelAttribute Payment payed, HttpSession session)
	{
		System.out.println(payed);
		payService.pay(payed);
		session.setAttribute("msg", "Paid successfully!");
		
		return "redirect:/home";
	}
	
	@GetMapping("/payment/{id}")
	public String PaymentForm(@PathVariable int id, Model m)
	{
		Payment p = payService.getPaymentById(id);
		m.addAttribute("payment", p);
		return "payment";
	}
	


}
