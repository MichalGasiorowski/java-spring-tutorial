package com.goose.spring.autowiring.test;

public class FileWriter implements LogWriter{

	public void write(String text) {
		// TODO Auto-generated method stub
		System.out.println("Write to file: " + text);
	}
	
}
