package com.goose.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger { // aspect in aspect terminology
	
	// reusable pointcut
	//@Pointcut("execution(void com.goose.spring.aop.Camera.snap())")
	//@Pointcut("execution(void com.goose.spring.aop.Camera.snap(..))") // all arguments returning void
	@Pointcut("execution(* com.goose.spring.aop.Camera.*(..))") // all arguments returning all types from all methods from class Camera
	public void cameraSnap() {
		
	}
	
	@Pointcut("execution(* com.goose.spring.aop.Camera.snap(String))") // all arguments
	//@Pointcut("execution(void com.goose.spring.aop.Camera.snap(String))") // all arguments
	public void cameraSnapName() {
		
	}
	
	
	//@Pointcut("execution(* com.goose.spring.aop.*.*(..))") // all arguments returning all types from all methods from all classes package com.goose.spring.aop
	@Pointcut("execution(* *.*(..))") // all arguments returning all types from all methods from all classes package com.goose.spring.aop
	public void cameraRelatedAction() {
		
	}
	
	//@Before(value="execution(void com.goose.spring.aop.Camera.snap())")
	@Before("cameraSnap()")
	public void aboutToTakePhoto() { // advice
		System.out.println("About to take a photo!");
	}
	
	@Before("cameraSnapName()")
	public void aboutToTakePhotoWithName() { // advice
		System.out.println("About to take a photo with name.");
	}
	
	@Before("cameraRelatedAction()")
	public void beforeCameraRelatedAction() { // advice
		System.out.println("Doing stuff with cameras.");
	}
}
