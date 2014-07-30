package com.goose.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.goose.spring.camera.accessories.Lens;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/aop/beans.xml");
		
		Camera camera = (Camera)context.getBean("camera");
		Lens lens = (Lens)context.getBean("lens");
		
		camera.snap();
		camera.snap(1000);
		camera.snap("Warsaw Old Castle");
		camera.snapNightTime();
		
		lens.zoom(7);
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
