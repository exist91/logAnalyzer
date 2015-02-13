package com.maple.loganalyzer;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

	
		FileManager fileManager = new FileManager();
		//ResultStorage resultStorage = ResultStorage.getStorage();

		fileManager.readLineFromlog("src/main/resources/input.log");
		
		
		
		fileManager.writeResultToLog("src/main/resources/output.log");
	}
}
