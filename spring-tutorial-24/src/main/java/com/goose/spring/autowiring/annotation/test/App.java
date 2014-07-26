package com.goose.spring.autowiring.annotation.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/autowiring/annotation/beans/beans.xml");
		
		//Logger logger = (Logger)context.getBean("logger");
		
		//Logger2 logger = (Logger2)context.getBean("logger2");
		
		Logger4 logger = (Logger4)context.getBean("logger4");
		
		logger.writeConsole("Mike, yo!");
		logger.writeFile("Jacob, yo!");
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
