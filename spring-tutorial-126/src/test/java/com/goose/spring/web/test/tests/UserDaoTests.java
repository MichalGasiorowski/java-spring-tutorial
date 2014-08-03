package com.goose.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.goose.spring.web.dao.User;
import com.goose.spring.web.dao.UsersDao;



@ActiveProfiles("dev")
// only for dev profile
@ContextConfiguration(locations = {
		"file:src/main/java/com/goose/spring/web/config/dao-context.xml",
		"file:src/main/java/com/goose/spring/web/config/security-context.xml",
		"file:src/test/java/com/goose/spring/web/test/config/datasource.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDaoTests {
	
	@Autowired
	private UsersDao usersDao;

	@Autowired
	private DataSource dataSource;
	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}
	
	
	@Test
	public void testUsers() {
		User user = new User("CrazyMike", "Mike the Crazy", "qaz1wsx2", "Mike@gmail.com", true, "ROLE_USER");
		
		assertTrue("User creation should work.", usersDao.create(user));
		
		List<User> users = usersDao.getAllUsers();
		assertEquals("There should be 1 user", 1, users.size());
		assertTrue("User should exist", usersDao.exists(user.getUsername()));
		assertEquals("Created user should be identical user", user, users.get(0));
		
	}
	
}
