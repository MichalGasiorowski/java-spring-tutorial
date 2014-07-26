package com.goose.spring.autowiring.annotation.test;

import org.springframework.stereotype.Component;

@Component(value="consoleWriter")
public class ConsoleWriter implements LogWriter{

	public void write(String text) {
		// TODO Auto-generated method stub
		System.out.println(text);
	}

}
