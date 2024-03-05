package com.kodnest.tunehub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class NavController {
	@GetMapping("/login")
	public String login(){
		return "login";
		
	}
	@GetMapping("/Registration")
	public String Registration(){
		return "Registration";
		
	}
	@GetMapping("/newsong")
	public String newsong() {
		return"newsong";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "login";
	}
	
	
	
	
	

}
