package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepo;
 
@Controller
public class LoginController {
 
    @Autowired
    private UserRepo userRepo;
     
    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }
    
	
	 @GetMapping("/register") public String showRegistrationForm(Model model) {
	 model.addAttribute("user", new User());
	 
	 return "signup_form";
	 }
	
	 
	 @PostMapping("/process_register") public String processRegister(User user) {
	
	 BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); String
	 encodedPassword = passwordEncoder.encode(user.getPassword());
	 user.setPassword(encodedPassword);
	 
	 
	 userRepo.save(user);
	 
	return "register_success"; 
	}
	 
	 @GetMapping("/logout")
	    public String viewLogout() {
		 return "redirect:/";
	    }
	
    
	
}