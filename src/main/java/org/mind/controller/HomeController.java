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
import org.springframework.ui.Model;
import org.springframework.ui.Model;


@Controller
public class HomeController {
	
	Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	UserService uservice;
	
	 @GetMapping("/register")
	    public String openRegisterPage() {
		 log.info("Application loaded , logger implementation successfully ");
	        return "register";
	    }
	 
	 @PostMapping("/registerUser")
	    public String registerUser(@ModelAttribute User user,Model model) {

	        int result = uservice.registerUser(user);

	        if(result > 0) {
	            model.addAttribute("msg","Registration Successful");
	            log.info("Registration Successful");
	        } else {
	            model.addAttribute("msg","Registration Failed");
	            log.error("Registration Failed");
	        }

	        return "register";
	    }
	 
}
