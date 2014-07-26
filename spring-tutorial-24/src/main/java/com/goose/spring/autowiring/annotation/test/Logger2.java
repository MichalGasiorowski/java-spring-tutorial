package com.goose.spring.autowiring.annotation.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Logger2 {
	
	
	private FileWriter fileWriter;
	private ConsoleWriter consoleWriter;

	@Resource(name="squirrel") // JSR-250
	public void setConsoleWriter(ConsoleWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}

	@Resource
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}

	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
	
	@PostConstruct
	public void init() {
		System.out.println("init");
	}
	
	@PreDestroy // doesn't work with prototype scope!
	public void destroy() {
		System.out.println("destroy");
	}
}
