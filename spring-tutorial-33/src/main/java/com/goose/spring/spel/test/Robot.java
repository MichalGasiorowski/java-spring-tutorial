package com.goose.spring.spel.test;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {

	private String id = "Average robot";
	private String speech = "hello";

	public void speak() {
		System.out.println(id + ": " + speech);
	}

	/*
	 @Inject
	public void setId(@Value("12345") String id) {
		this.id = id;
	}  
	 */
	
	@Inject
	public void setId(@Value("#{randomText.text?.length()}") String id) {
		this.id = id;
	}

	@Inject
	//new java.util.Date().toString()
	// T(Math).PI   		--> static methods
	// T(Math).sin(T(Math).PI/4) ^ 2
	// T(Math).sin(T(Math).PI/4) ^ 2 le 0.8 ? 'yes' : 'no'
	public void setSpeech(@Value("#{T(Math).sin(T(Math).PI/4) ^ 2 le 0.8 ? 'yes' : 'no'}") String speech) {
		this.speech = speech;
	}

}
