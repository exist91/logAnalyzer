package com.maple.loganalyzer;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		FileManager fileManager = new FileManager();
		LogAnalyzer logAnalyzer = new LogAnalyzer();
		
		fileManager.readLineFromlog("src/main/resources/input.log");
		logAnalyzer.analyzeData();
		fileManager.writeResultToLog("src/main/resources/output.log");
	}
}
