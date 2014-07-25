package com.goose.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
	
	public static void main(String[] args) {
		
		//ApplicationContext context = new FileSystemXmlApplicationContext("beans.xml"); // no path because beans.xml is in root path
		ApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/test/beans/beans.xml");
		
		Person person1 = (Person) context.getBean("person");
		//Person person2 = (Person) context.getBean("person");
		//Person person = new Person(); // instantiating without using Spring
		//person.speak();
		
		person1.setTaxId(666);
		//Address address = (Address)context.getBean("address");
		
		//System.out.println(address);
		System.out.println(person1); // person2 has same taxId as person -> by DEFAULT bean has singleton scope
		// scope prototype creates new instances
		// prototype scope -> spring gives away handling of bean
		
		Address address2 = (Address)context.getBean("address2");
		System.out.println(address2);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
