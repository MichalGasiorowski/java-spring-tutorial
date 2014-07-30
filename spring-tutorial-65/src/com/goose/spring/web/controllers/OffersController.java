package com.goose.spring.web.controllers;


import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.goose.spring.web.dao.Offer;
import com.goose.spring.web.service.OffersService;

@Controller
public class OffersController {

	
	private OffersService offersService;
	
	
	@Autowired
	public void setOffersService(OffersService offersService) {
		this.offersService = offersService;
	}


	@RequestMapping("/offers")
	public String showOffers(Model model) {
		// testing for exceptions
		
		//offersService.throwTestException();
		
		List<Offer> offers = offersService.getCurrent();
		
		model.addAttribute("offers", offers);
		
		return "offers";
	}
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) {
		System.out.println("Id is:" + id) ;
		return "home";
	}
	
	/*
	// handler method
	@ExceptionHandler(DataAccessException.class)
	public String handleDatabaseException(DataAccessException ex) {
		return "error";
	}
	*/
	
	@RequestMapping("/createoffer")
	public String createOffer(Model model) {
		model.addAttribute("offer", new Offer());
		
		return "createoffer";
	}
	
	/*
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, Offer offer) {
		System.out.println(offer);
		return "offercreated";
	}
	*/
	
	@RequestMapping(value="/docreate", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
		// result is used if offer could be validated successfully or not
		if(result.hasErrors()) {
			/*
			System.out.println("Form does not validate");
			
			List<ObjectError> errors = result.getAllErrors();
			for(ObjectError error: errors) {
				System.out.println(error.getDefaultMessage());
			}
			*/
			
			return "createoffer";
		}
		offersService.create(offer);
		
		return "offercreated";
	}
	
	
}
