package com.wyb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HelloController {


	@RequestMapping("/hello")
	public String hello(Model m){
		
		m.addAttribute("title","spring security hello world");
		m.addAttribute("message","This is welcome page!");
		return "/jsp/hello";
	}
	
	
	
	@RequestMapping(value={"/","welcome**"})
	public String welcomepage(Model m){
		m.addAttribute("title", "Spring Security Custom Login Form");
		m.addAttribute("message", "This is welcome page!");
		return "/jsp/hello";
	}
	
	
	@RequestMapping("/admin**")
	public String admin(Model m){
		
		m.addAttribute("title","Spring Security Custom Login Form");
		m.addAttribute("message", "This is protected page - Admin Page!");
		return "/jsp/admin";
	}
	
	@RequestMapping("/login")
	public String database(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,Model m){
//		System.out.println("12345");
		if (error != null) {
			m.addAttribute("error", "Invalid username and password!");
		}

		if (logout != null) {
			m.addAttribute("msg", "You've been logged out successfully!");
		}

//		System.out.println("/jsp/login");
		return "/jsp/login";		
	}
	
	
	
}
