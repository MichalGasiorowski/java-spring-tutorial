package com.goose.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.goose.spring.camera.Camera;
import com.goose.spring.other.Car;

public class App {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/goose/spring/beans/beans.xml");
		
		Object obj = context.getBean("camera");
		System.out.println("Class of obj: " + obj.getClass());
		System.out.println(obj instanceof Camera);
		Camera camera = (Camera)context.getBean("camera");
		
		/*
		try {
			camera.snap();
		} catch (Exception e) {
			System.out.println("Caught exception: " + e.getMessage());
		}
		*/
		camera.snap();
		camera.snap(400);
		camera.snap("Old Castle");
		camera.snap(600, 1.6);
		
		Car car = (Car) context.getBean("car");
		car.start();
		
		camera.snapCar(new Car());
		
		((ClassPathXmlApplicationContext)context).close();
	}

}
