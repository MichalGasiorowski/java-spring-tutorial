package com.goose.spring.camera;

import org.springframework.stereotype.Component;

import com.goose.spring.other.Car;


@Component("camera")
//@Deprecated
public class Camera implements PhotoSnapper{ // implements PhotoSnapper suposedly doesn't work ( in Spring below 3.2.7 version )
	
	public Camera() {
		System.out.println("Hello from Camera contructor.");
	}
	
	@Deprecated
	public void snap() {//throws Exception{
		// joint point - anywhere in code where aspect can run some advice
		// in spring -> only one joint point : method execution
		
		System.out.println("SNAP");
		//throw new Exception("It's a lion. Get in the car!");
	}
	
	
	public void snap(int exposure) {
		System.out.println("SNAP. exposure: " + exposure);
	}
	
	public void snap(int exposure, double aperture) {
		System.out.println("SNAP. exposure: " + exposure + " aperture: " + aperture);
	}
	
	public String snap(String name) {
		System.out.println("SNAP. Name: " + name);
		return name;
	}
	
	public void snapNightTime() {
		System.out.println("SNAP. Night mode.");
	}
	
	public void snapCar(Car car) {
		System.out.println("Car snap!");
	}
}
