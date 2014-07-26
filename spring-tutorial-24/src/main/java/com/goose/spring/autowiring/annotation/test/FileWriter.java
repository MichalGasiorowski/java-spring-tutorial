package com.goose.spring.autowiring.annotation.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fileWriter")
//@Qualifier("filewriter")
public class FileWriter implements LogWriter{

	public void write(String text) {
		// TODO Auto-generated method stub
		System.out.println("Write to file: " + text);
	}
	
}
