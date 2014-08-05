package com.goose.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.goose.spring.web.dao.Offer;
import com.goose.spring.web.dao.OffersDao;

@Service("offersService")
public class OffersService {

	private OffersDao offersDao;

	public OffersService() {
		System.out.println("OffersService constructed.");
	}

	@Autowired
	public void setOffersDao(OffersDao offersDao) {
		this.offersDao = offersDao;
	}

	public List<Offer> getCurrent() {
		return offersDao.getOffers();
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void create(Offer offer) {
		offersDao.saveOrUpdate(offer);
	}

	public void throwTestException() {
		offersDao.getOffer(9999);
	}

	public boolean hasOffer(String name) {
		if(name == null) { return false; }
		
		List<Offer> offers = offersDao.getOffers(name);
		return offers.size() > 0;
	}
	
	public Offer getOffer(String username) {
		if(username == null) { return null; }
		
		List<Offer> offers = offersDao.getOffers(username);
		if(offers.isEmpty()) { return null; }
		return offers.get(0);
		
		
	}

	@Secured({"ROLE_USER", "ROLE_ADMIN"})
	public void saveOrUpdate(Offer offer) {
		if(offer.getId() != 0) {
			offersDao.saveOrUpdate(offer);
		} else {
			offersDao.saveOrUpdate(offer);
		}
		
		
	}

	public void delete(int id) {
		offersDao.delete(id);
	}
	
	
}
