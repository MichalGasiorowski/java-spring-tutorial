package com.goose.spring.web.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.List;

import javax.sql.DataSource;
import javax.validation.constraints.AssertFalse;

import org.junit.AfterClass;
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
	
	private User user1 = new User("johnwpurcell", "John Purcell", "hellothere",
			"john@caveofprogramming.com", true, "ROLE_USER");
	private User user2 = new User("richardhannay", "Richard Hannay", "the39steps",
			"richard@caveofprogramming.com", true, "ROLE_ADMIN");
	private User user3 = new User("suetheviolinist", "Sue Black", "iloveviolins",
			"sue@caveofprogramming.com", true, "ROLE_USER");
	private User user4 = new User("rogerblake", "Rog Blake", "liberator",
			"rog@caveofprogramming.com", false, "user");
	
	
	@Before
	public void init() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from messages");
		jdbc.execute("delete from users");
	}
	
	@Test
	public void testCreateRetrieve() {
		usersDao.create(user1);
		
		List<User> users1 = usersDao.getAllUsers();
		
		assertEquals("One user created and one should be retrieved", 1, users1.size());
		assertEquals("Inserted user should be the same as retrieved", user1, users1.get(0));
		
		usersDao.create(user2);
		usersDao.create(user3);
		usersDao.create(user4);
		
		List<User> users2 = usersDao.getAllUsers();
		
		assertEquals("Should be 4 retrieved users", 4, users2.size());
		
	}
	
	@Test
	public void testExists() {
		usersDao.create(user1);
		usersDao.create(user2);
		usersDao.create(user3);
		
		assertTrue("User should exist", usersDao.exists(user2.getUsername()));
		assertFalse("User should exist", usersDao.exists("gklnm45k"));
	}
	
	/*
	@AfterClass
	public void tearDownAfterClass() {
		JdbcTemplate jdbc = new JdbcTemplate(dataSource);
		jdbc.execute("delete from offers");
		jdbc.execute("delete from users");
	}
	*/
	
	/*
	@Test
	public void testUsers() {
		User user = new User("CrazyMike", "Mike the Crazy", "qaz1wsx2", "Mike@gmail.com", true, "ROLE_USER");	
		usersDao.create(user);
		
		List<User> users = usersDao.getAllUsers();
		assertEquals("There should be 1 user", 1, users.size());
		assertTrue("User should exist", usersDao.exists(user.getUsername()));
		assertFalse("User should not exist", usersDao.exists("dsdsdsq1"));
		
		assertEquals("Created user should be identical user", user, users.get(0));
		
	}
	*/
	
	
}
