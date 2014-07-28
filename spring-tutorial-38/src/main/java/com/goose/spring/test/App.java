package com.goose.spring.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.goose.spring.dao.OffersDAO;
import com.goose.spring.model.Offer;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/goose/spring/beans/beans.xml");

		OffersDAO offersDao = (OffersDAO) context.getBean("offersDao");

		try {
			
			//offersDao.delete(1);
			
			/*
			Offer offer1 = new Offer("Dave", "dave@yoyo.com", "Coding is fun");
			Offer offer2 = new Offer("Karen", "karen@gmail.com", "Testing for stuff");
			
			offersDao.create(offer1);
			offersDao.create(offer2);
			*/
			List<Offer> newOffers = new ArrayList<Offer>();
			newOffers.add(new Offer(3, "Hue", "hue@yahoo.com", "Cash for coding mad skills."));
			newOffers.add(new Offer(2, "MaNigga", "tuPAC-nigga4life@mailinator.com", "Pimping street runners for ca$h."));
			
			int[] rvals = offersDao.create(newOffers);
			for(int value: rvals) {
				System.out.println("Updated " + value + " rows");
			}
			
			Offer offer1 = new Offer(5, "Albert", "albert@cern.gov", "Banging atoms together!");
			if(offersDao.update(offer1)) {
				System.out.println("Object updated!");
			} else {
				System.out.println("Cannot update object.");
			}
			
			List<Offer> offers = offersDao.getOffers();

			for (Offer offer : offers) {
				System.out.println(offer);
			}
			
			Offer offer = offersDao.getOffer(2);
			System.out.println("Should be Mike:" + offer);
		} catch(CannotGetJdbcConnectionException ex) {
			System.out.println("Cannot get database connection.");
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();

	}

}
