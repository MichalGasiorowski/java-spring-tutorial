package com.goose.spring.aop;

import org.springframework.stereotype.Component;


@Component
public class Blender implements IBlender {
	
	public void blend() {
		System.out.println("Blending ...");
	}
}
