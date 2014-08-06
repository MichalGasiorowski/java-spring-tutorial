package com.goose.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.goose.spring.web.dao.Message;
import com.goose.spring.web.dao.MessagesDao;
import com.goose.spring.web.dao.User;
import com.goose.spring.web.dao.UsersDao;

@Service("usersService")
public class UsersService {

	@Autowired
	private UsersDao usersDao;

	@Autowired
	private MessagesDao messagesDao;
	
	
	public UsersService() {
		System.out.println("OffersService constructed.");
	}

	public void create(User user) {
		usersDao.create(user);
	}

	public boolean exists(String username) {
		return usersDao.exists(username);
	}


	// backup way of securing, kinda
	@Secured("ROLE_ADMIN")
	public List<User> getAllUsers() {
		return usersDao.getAllUsers();
	}
	
	public void sendMessage(Message message) {
		messagesDao.saveOrUpdate(message);
	}
	
	public User getUser(String username) {
		return usersDao.getUser(username);
	}
}
