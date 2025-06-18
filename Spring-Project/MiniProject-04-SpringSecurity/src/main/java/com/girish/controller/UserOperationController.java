package com.girish.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.girish.entity.UserInfo;
import com.girish.service.IUserManagementService;

@Controller
@RequestMapping("/user")
public class UserOperationController {

	@Autowired
	private IUserManagementService service;
	
	@GetMapping("/register")
	public String showRegisterUserForm(@ModelAttribute("userInfo") UserInfo details) {
		return "user_registration_form";
	}
	
	@PostMapping("/register")
	public String registerUser(Map<String,Object> map,@ModelAttribute("userInfo") UserInfo details) {
		String result = service.UserRegistration(details);
		map.put("resultMsg", result);
		
		return "user_registered_sucess";
	}
	@GetMapping("/login")
	public String showLogin() {
		return "customer_login_form";
	}
}
