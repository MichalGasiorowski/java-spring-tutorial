package com.goose.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/test/beans/beans.xml");
		
		//Jungle jungle = (Jungle)context.getBean("jungle");
		MapJungle jungle2 = (MapJungle)context.getBean("jungle2");
		Jungle3 jungle3 = (Jungle3)context.getBean("jungle3");
		System.out.println(jungle3);
		
		((ClassPathXmlApplicationContext)context).close();
		
		// cant refer to inner beans!
	}

}
