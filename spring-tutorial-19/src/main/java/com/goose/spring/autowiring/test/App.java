package com.goose.spring.autowiring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/autowiring/test/beans/beans.xml");
		
		//Logger logger = (Logger)context.getBean("logger");
		
		//Logger2 logger2 = (Logger2)context.getBean("logger2");
		
		//Logger3 logger3 = (Logger3)context.getBean("logger3");
		
		Logger4 logger4 = (Logger4)context.getBean("logger4");
		
		logger4.writeConsole("Mike, yo!");
		logger4.writeFile("Jacob, yo!");
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
