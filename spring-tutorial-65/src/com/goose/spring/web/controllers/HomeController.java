package com.goose.spring.web.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.goose.spring.web.dao.Offer;


@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String showHome() {
		return "home";
	}
	
}
