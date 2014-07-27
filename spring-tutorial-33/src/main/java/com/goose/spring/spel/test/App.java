package com.goose.spring.spel.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/spel/test/beans/beans.xml");
		
		Robot robot = (Robot)context.getBean("robot");
		robot.speak();
		
		
		((ClassPathXmlApplicationContext)context).close();
		
	}

}
