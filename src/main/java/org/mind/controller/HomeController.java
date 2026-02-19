package org.mind.controller;

import org.mind.model.User;
import org.mind.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import org.springframework.ui.Model;

@Controller
public class HomeController {

	Logger log = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	UserService uservice;

	// get for to open login page   default project run kela ka login ch page open hoil 
	@GetMapping("/")
	public String openLoginPage() {
		return "login";
	}
	@GetMapping("/log")
	public String log() {
		return "login";
	}
	
	@GetMapping("/register")
	public String openRegisterPage() {
		log.info("Application loaded , logger implementation successfully ");
		return "register";
	}

	@PostMapping("/registerUser")
	public String registerUser(@ModelAttribute User user, Model model) {

		int result = uservice.registerUser(user);

		if (result > 0) {
			model.addAttribute("msg", "Registration Successful");
			log.info("Registration Successful");
		} else {
			model.addAttribute("msg", "Registration Failed");
			log.error("Registration Failed");
		}
		return "register";
	}

	// post to check the login page 
	@PostMapping("/login")
	public String loginCheck(
	        @RequestParam("username") String username,@RequestParam("password") String password,Model m) {

	    User u = uservice.loginUser(username, password);

	    if (u != null) {
	        m.addAttribute("user", u);
//	        log.info("Login successFull");
	        return "dashboard";
	    }
	    else {
	    	m.addAttribute("msg", "Login Failed invalid credentials");
			log.error("Login Failed");
	    }
	    return "login";
	}


}
