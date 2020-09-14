package com.weatherstatus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Controller
public class LoginController {
	private static final Logger logger = LogManager.getLogger(LoginController.class.getName());	
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		logger.info("inside showMyLoginPage");
		return "fancy-login";
	}
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		logger.info("inside access-denied");
		return "access-denied";
		
	}
}
