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

import java.util.List;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerService service;
	/* private PaymentService payService; */
	
	@GetMapping("/home")
	public String home(Model m)
	{
		List<Player> players = service.getAllPlayers();
		m.addAttribute("players", players);
		return "home";
	}
	
	@GetMapping("/addplayer")
	public String addPlayerForm()
	{
		return "add_player";
	}
	
	@PostMapping("/register")
	public String playerRegister(@ModelAttribute Player p, HttpSession session)
	{
		System.out.println(p);
		service.addPlayer(p);
		session.setAttribute("msg", "Exam successfully added !");
		return "redirect:/home";
	}
	
	/*
	 * @GetMapping("/payment") public String paymentForm() { return "payment"; }
	 * 
	 * @PostMapping("/pay") public String examPay(@ModelAttribute Payment payed,
	 * HttpSession session) { System.out.println(payed); payService.pay(payed);
	 * session.setAttribute("msg", "Payed successfully!"); return "redirect:/"; }
	 */
	
	@GetMapping("/edit/{id}")
	public String editPlayer(@PathVariable int id, Model m)
	{
		Player p = service.getPlayerById(id);
		m.addAttribute("players", p);
		return "edit";
	}
	
	@PostMapping("/update")
	public String playerUpdate(@ModelAttribute Player p, HttpSession session)
	{
		System.out.println(p);
		service.addPlayer(p);
		session.setAttribute("msg", "Changes saved successfully !");
		return "redirect:/home";
	}
	
	@GetMapping("/delete/{id}")
	public String playerDelete(@PathVariable int id, HttpSession session)
	{
		service.deletePlayer(id);
		session.setAttribute("msg", "Exam deleted successfully !");
		return "redirect:/home";
	}

}
