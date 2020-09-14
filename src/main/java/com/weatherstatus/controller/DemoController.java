package com.weatherstatus.controller;

import java.security.Principal;
import java.util.List;

import org.apache.logging.log4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.weatherstatus.model.Note;
import com.weatherstatus.model.User;
import com.weatherstatus.services.UserService;
import com.weatherstatus.services.WeatherService;


@Controller
public class DemoController {
	private static final Logger logger = LogManager.getLogger(DemoController.class.getName());	
	@Autowired
	public UserService userService;
	@Autowired
	WeatherService weatherService;
	@GetMapping("/")
	public String showDefualt(Model model) {
		logger.info("inside Show defualte");
		Note note=weatherService.getSelectedOne();
		model.addAttribute("noteobj", note);
		return "home";
	}

	@GetMapping("/welcome")
	public String showWelcome() {
		logger.info("inside show welcome");
		return "welcomePage";
	}

	@GetMapping("/registerPage")
	public String showRegister() {	
		logger.info("inside showRegister");
		return "registerPage";
	}

	@GetMapping("/admin")
	public String showAdmin(Model model, Principal principal) {
		logger.info("inside showAdmin");
		List<Note>  notes=weatherService.findAll();
		model.addAttribute("notes", notes);
		return "admin";
	}
	@GetMapping("/admin/updateform")
	public String showUpdateForm(Model model, Principal principal) {
		logger.info("inside showUpdateForm");
		return "updatenote";
	}
	@PostMapping("/admin/updatenote")
	public String saveCustomer(@RequestParam("status") String status,@RequestParam("note") String note) {
		weatherService.updateNote(status,note);	
		return "redirect:/admin";
	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String submitUser(@ModelAttribute("user") User user, Model model, Principal principal) {
		logger.info("inside submitUser with user role");
		logger.info("username:="+user.getUsername()+" userEmail:= "+user.getEmail()+" userMobile:= "+user.getmobileNumber());
		logger.info("username:="+user.getUsername()+" userEmail:= "+user.getEmail()+" userMobile:= "+user.getmobileNumber());
		userService.register(user);
		return "welcomePage";
	}
}
