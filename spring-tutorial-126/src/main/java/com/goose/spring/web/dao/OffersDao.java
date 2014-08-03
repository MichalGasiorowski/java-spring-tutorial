package com.goose.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.goose.spring.web.dao.Offer;

@Component("offersDao")
public class OffersDao {

	// private JdbcTemplate jdbc;
	private NamedParameterJdbcTemplate jdbc;

	
	public OffersDao() {
		System.out.println("Successfully loaded offers DAO!");
	}

	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public Offer getOffer(int id) {

		// MapSqlParameterSource params = new MapSqlParameterSource("name",
		// "Sue");
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("id", id);

		return jdbc.queryForObject("select * from offers, users where offers.username = users.username and users.enabled = true and id = :id",
				params, new OfferRowMapper());
	}

	public List<Offer> getOffers() {
		return jdbc.query("select * from offers, users where offers.username = users.username and users.enabled = true", new OfferRowMapper());
	}
	
	public List<Offer> getOffers(String username) {
		return jdbc.query("select * from offers, users where offers.username = users.username and users.enabled = true and offers.username=:username",
				new MapSqlParameterSource("username", username),
				new OfferRowMapper());
	}
	
	public boolean delete(int id) {
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return (jdbc.update("delete from offers where id=:id", params)) == 1;
	}
	
	public boolean update(Offer offer) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("update offers set text=:text where id=:id", params) == 1;
	}
	
	public boolean create(Offer offer) {
		// creates a set of paramaters that can be used to replace placeholders in SQL
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(offer);
		
		return jdbc.update("insert into offers (username, text) values (:username, :text)", params) == 1;
		//make sure names of parameters have same names as in bean
	}

	@Transactional
	public int[] create(List<Offer> offers) {
		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(offers.toArray());
		
		//return jdbc.batchUpdate("insert into offers (id, name, text, email) values (:id, :name, :text, :email)", params);
		return jdbc.batchUpdate("insert into offers (username, text) values (:username, :text)", params);
		
	}
	
	
	

}
