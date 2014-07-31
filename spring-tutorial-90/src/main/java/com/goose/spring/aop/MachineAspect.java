package com.goose.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;



@Component
@Aspect
public class MachineAspect {
	
	// introductions
	
	// all components in value are going to implement this interface 
	@DeclareParents(value="com.goose.spring.aop.*", defaultImpl=com.goose.spring.aop.Machine.class) 
	private IMachine machineMixin;
	
	@Around("within(com.goose.spring.aop.*)")
	public void runMachine(ProceedingJoinPoint jp) {
		System.out.println("Running ...");
		
		try {
			jp.proceed();
		} catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("... completed.");
		
	}
	

}
