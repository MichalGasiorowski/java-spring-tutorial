package com.goose.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/beans/beans.xml");
		
		IBlender blender = (IBlender)context.getBean("blender");
		blender.blend();
		
		
		((IMachine)blender).start();
		
		IFan fan = (IFan)context.getBean("fan");
		fan.activate(5);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
