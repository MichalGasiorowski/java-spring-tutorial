package com.goose.spring.aop;

import java.util.Date;

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
public class Logger2 {
	// testing various advice types
	// can also 
	
	@Pointcut("execution(* com.goose.spring.aop.Camera.snap())")
	public void cameraSnap() {
		
	}
	
	@Before("cameraSnap()")
	public void beforeAdvice() {
		System.out.println("Before advice ...");
	}
	
	@After("cameraSnap()") // after execution of cameraSnap()
	public void afterAdvice() {
		System.out.println("After advice ...");
	}
	
	@AfterReturning("cameraSnap()") // after returning normally, won't run if exception is thrown
	public void afterReturningAdvice() {
		System.out.println("After returning advice ...");
	}
	
	@AfterThrowing("cameraSnap()") // after throwing exception, won't run if executed normally
	public void afterThrowingAdvice() {
		System.out.println("After throwing advice ...");
	}
	
	@Around("cameraSnap()") // 
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
		System.out.format("Time to execute: %d(ms)", (high.getTime() - low.getTime()));
	}
	
	
	
}
