package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.entity.User;
import com.app.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	private UserRepository repository;

	
	@GetMapping("/")
	public String login(Model model) {
		User user=new User();
		model.addAttribute("user" ,user);
		
		 return "login";
		
	}
	@PostMapping("/userLogin")
	public String loginUser(@ModelAttribute("user") User user) {
		//System.out.println(user.getUserId());
		//System.out.println(user.getPassword());
		String userId=user.getUserId();
		User userdata=repository.findByUserId(userId);
		if(user.getPassword().equals(userdata.getPassword())) {
			return "home";
		}else {
			return "error";
		}
  }
}
