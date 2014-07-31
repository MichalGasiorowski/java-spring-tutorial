package com.goose.spring.aop;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

	// testing various advice types
	// can also

	/* 
	 
	@Pointcut("execution(* com.goose.spring.camera.Camera.snap())")
	public void cameraSnap() {
	}
	*/
	
	/* 82 Within pointcut
	  
	//@Pointcut("within(com.goose.spring.camera.Camera)") // match any joint point within Camera class
	@Pointcut("within(com.goose.spring..*)") // all subpackages in com.goose.spring all methods
	public void cameraSnap() {
	}

	@Before("cameraSnap()")
	public void beforeAdvice() {
		System.out.println("Before advice ...");
	}
	*/
	
	
	/* 84 Annotation-Specific PCDs
	// PCD Pointcut Designator
	
	//@Pointcut("within(@Deprecated com.goose.spring..*)") // @Deprecated applies to deprecated classes
	@Pointcut("within(@org.springframework.stereotype.Component com.goose.spring..*)") // all components 
	public void somePointCut() {
		
	}
	
	@Before("somePointCut()")
	public void somePointCutDemo() {
		System.out.println("******** BEFORE DEMO *********");
	}
	*/
	
	/*
	
	// @within is almost the same as @target in Spring
	@Pointcut("@target(org.springframework.stereotype.Component)") // @target annotation -> all methods in all classes with this annotation
	public void somePointCut() {
		
	}
	
	@Before("somePointCut()")
	public void somePointCutDemo() {
		System.out.println("******** BEFORE DEMO *********");
	}
	
	*/
	
	/*
	
	@Pointcut("@annotation(java.lang.Deprecated)") // all deprecated methods
	public void somePointCut() {

	}
		
	@Before("somePointCut()")
	public void somePointCutDemo() {
		System.out.println("******** BEFORE DEMO *********");
	}
	
	*/
	
	/* 
	 
	@Pointcut("@args(org.springframework.stereotype.Component)") // @args targets methods with args that have annotation of type
	public void somePointCut() {

	}
		
	@Before("somePointCut()")
	public void somePointCutDemo() {
		System.out.println("******** BEFORE DEMO *********");
	}


	*/
	
	/* 84 "Bean" PCD
	
	//@Pointcut("bean(camera)") // bean PCD targets bean with id camera
	@Pointcut("bean(*camera)") // asterisks possible also (0 or more)
	public void somePointCut() {

	}
		
	@Before("somePointCut()")
	public void somePointCutDemo() {
		System.out.println("******** BEFORE DEMO *********");
	}
	
	*/
	
	/* 86 Args PCD
	
	//@Pointcut("args()") // any methods in our container witch tak no arguments
	//@Pointcut("args(String)") // any methods in our container witch takes String
	//@Pointcut("args(com.goose.spring.other.Car)") // any methods in our container witch takes Car
	//@Pointcut("args(int, *)") // any methods in our container witch takes int and second argument with any type
	//@Pointcut("args(int, ..)") // any methods in our container witch takes int and 0 or more arguments following
	@Pointcut("args(double)") // also finds methods with arguments witch can be cast to double
	public void somePointCut() {
	}
			
	@Before("somePointCut()")
	public void somePointCutDemo() {
		System.out.println("******** BEFORE DEMO *********");
	}
	
	*/

	
	/* 88 Getting arguments using "Args"
	
	//@Pointcut("args(int)")
	//@Pointcut("target(com.goose.spring.camera.Camera)")
	//@Pointcut("args(int, double)")
	//public void somePointCut() {
	//}
	
	//@Before("somePointCut()")
	//public void somePointCutDemo(JoinPoint jp) {
	//	System.out.println("******** BEFORE DEMO *********");	
	//	for(Object obj: jp.getArgs()) {
	//		System.out.println("ARG: "+ obj);
	//	}
	//}
	
	
	//@Pointcut("args(int)")
		//@Pointcut("target(com.goose.spring.camera.Camera)")
		//@Pointcut("args(int, double)")
	//@Pointcut("args(exposure, ..)"
	@Pointcut("args(exposure, aperture)")
	public void somePointCut(int exposure, double aperture) {
	}
				
	
	//@Before("somePointCut()")
	@Before("somePointCut(exposure, aperture)")
	public void somePointCutDemo(JoinPoint jp, int exposure, double aperture) {
		System.out.println("******** BEFORE DEMO *********");
		System.out.format("exposure: %d, aperture: %.2f\n", exposure, aperture);
	}
	
	*/
	
	@Pointcut("args(exposure, aperture)")
	public void somePointCut(int exposure, double aperture) {
	}
	
	@Pointcut("target(com.goose.spring.camera.Camera)")
	public void targetCamera() {
	}
					
		
		
	@Before("targetCamera() && somePointCut(exposure, aperture)") // combining pointcut designators 
	public void somePointCutDemo(JoinPoint jp, int exposure, double aperture) {
		System.out.println("******** BEFORE DEMO *********");
		System.out.format("exposure: %d, aperture: %.2f\n", exposure, aperture);
	}
	
	//@After("within(com.goose.spring..*) && @annotation(Deprecated)") // combining with deprecated annotation
	@After("within(com.goose.spring..*) && !@annotation(Deprecated)")
	public void someAfterAdvice() {
		System.out.println("After advice running!!!");
	}
	
	/* 83 this, target, matching subpackages
	@Pointcut("within(com.goose.spring..*)") // all subpackages in com.goose.spring all methods
	public void withinDemo() {
	}
	
	@Pointcut("target(com.goose.spring.camera.Camera)")  // target is about actual class
	public void targetDemo() {
	}
	
	@Pointcut("this(com.goose.spring.camera.Camera)") // about type of the bean is proxied // it works fine in newer Spring
	public void thisDemo() {
	}

	@Before("withinDemo()")
	public void withinDemoAdvice() {
		System.out.println("****** BEFORE DEMO *********");
	}
	
	@Before("targetDemo()")
	public void targetDemoAdvice() {
		System.out.println("****** TARGET DEMO *********");
	}
	
	@Before("thisDemo()")
	public void thistDemoAdvice() {
		System.out.println("****** THIS DEMO *********");
	}
	
	*/
	
	
	
	
	/* 80 Advice types: After, Around etc

	@After("cameraSnap()")
	// after execution of cameraSnap()
	public void afterAdvice() {
		System.out.println("After advice ...");
	}

	@AfterReturning("cameraSnap()")
	// after returning normally, won't run if exception is thrown
	public void afterReturningAdvice() {
		System.out.println("After returning advice ...");
	}

	@AfterThrowing("cameraSnap()")
	// after throwing exception, won't run if executed normally
	public void afterThrowingAdvice() {
		System.out.println("After throwing advice ...");
	}

	@Around("cameraSnap()")
	public void aroundAdvice(ProceedingJoinPoint p) {
		Date low = new Date();
		System.out.println("Around advice (before) ... time:" + low);

		try {
			p.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println("In around advice: " + e.getMessage());
		}
		Date high = new Date();
		System.out.println("Around advice (after) time:" + high);
		System.out.format("Time to execute: %d(ms)",
				(high.getTime() - low.getTime()));

	}
	
	*/

}
