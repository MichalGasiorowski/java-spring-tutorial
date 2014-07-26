package com.goose.spring.autowiring.test;

public class Logger3 {
	private LogWriter fileWriter;
	private LogWriter consoleWriter;
	
	public Logger3(ConsoleWriter consoleWriter, FileWriter fileWriter) { // have to get right types for autowiring by constructor!
		this.fileWriter = fileWriter;
		this.consoleWriter = consoleWriter;
	}
	
	public void setFileWriter(LogWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	public void setConsoleWriter(LogWriter consoleWriter) {
		this.consoleWriter = consoleWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	public void writeConsole(String text) {
		consoleWriter.write(text);
	}
}
