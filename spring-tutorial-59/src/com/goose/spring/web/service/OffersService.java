package com.goose.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goose.spring.web.dao.Offer;
import com.goose.spring.web.dao.OffersDAO;

@Service("offersService")
public class OffersService {
	
	
	private OffersDAO offersDao;
	
	
	
	public OffersService() {
		System.out.println("OffersService constructed.");
	}


	@Autowired
	public void setOffersDao(OffersDAO offersDao) {
		this.offersDao = offersDao;
	}


	public List<Offer> getCurrent() {
		return offersDao.getOffers();
	}
}
