package com.goose.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		//ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml"); // no path because beans.xml is in root path
		ApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/test/beans/beans.xml");
		
		Person person = (Person) context.getBean("person");
		
		//Person person = new Person(); // instantiating without using Spring
		person.speak();
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
