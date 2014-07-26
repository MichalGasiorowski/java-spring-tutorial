package com.goose.spring.autowiring.annotation.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger {
	
	
	private FileWriter fileWriter;
	private ConsoleWriter consoleWriter;
	
	
	/*
	@Autowired
	public Logger(FileWriter fileWriter, ConsoleWriter consoleWriter) {
		this.fileWriter = fileWriter;
		this.consoleWriter = consoleWriter;
	}
	*/

	@Autowired
	@Qualifier("filewriter")
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	@Autowired
	@Qualifier("toconsole")
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
}
