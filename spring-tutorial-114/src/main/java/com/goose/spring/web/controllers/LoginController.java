package com.goose.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.goose.spring.web.dao.User;
import com.goose.spring.web.service.UsersService;

@Controller
public class LoginController {

	private UsersService usersService;
	
	@Autowired
	public void setUsersService(UsersService usersService) {
		this.usersService = usersService;
	}

	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@RequestMapping("denied")
	public String showDenied() {
		return "denied";
	}
	

	@RequestMapping("/admin")
	public String showAdmin(Model model) {
		List<User> users = usersService.getAllUsers();
		
		model.addAttribute("users", users);
		
		return "admin";
	}
	
	@RequestMapping("/loggedout")
	public String showLoggedOut() {
		return "loggedout";
	}
	
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new User());
		return "newaccount";
	}
	
	@RequestMapping(value="/createaccount", method=RequestMethod.POST)
	public String createAccount(@Valid User user, BindingResult result) {
		if(result.hasErrors()) {
			return "newaccount";
		}
		
		user.setEnabled(true);
		user.setAuthority("ROLE_USER");
		
		if(usersService.exists(user.getUsername())) {
			System.out.println("Duplicate username");
			result.rejectValue("username", "DuplicateKey.user.username");
			return "newaccount";
		}
		
		// ugly...
		try{
			usersService.create(user);
		} catch(DuplicateKeyException ex) {
			result.rejectValue("username", "DuplicateKey.user.username", "Username already exist.");
			return "newaccount";
		}
		
		
		return "accountcreated";
	}
	
	
}
