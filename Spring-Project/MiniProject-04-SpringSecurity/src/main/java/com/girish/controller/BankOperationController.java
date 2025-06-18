package com.girish.controller;

import java.util.Map;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bank")
public class BankOperationController {
	
//	@GetMapping("/")
//	public String showHome() {
//		return "welcome";
//	}
	
	@GetMapping("/offer")
	public String showOffer() {
		return "show_offers";
	}
	
	@GetMapping("/balance")
	public String showBalance(Map<String,Object> map) {
		map.put("balance",new Random().nextInt(20000));
		return "show_balance";
	}
	@GetMapping("/loan")
	public String approveLoan(Map<String,Object> map) {
		map.put("amount", new Random().nextInt(20000));
		return "loan";
	}
	@GetMapping("/denied")
	public String errorMsg() {
		return "denied_file";
	}
}
