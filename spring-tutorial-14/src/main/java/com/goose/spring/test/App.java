	package com.goose.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/test/beans/beans.xml");
		
		FruitBasket basket = (FruitBasket)context.getBean("basket");
		
		System.out.println(basket);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
