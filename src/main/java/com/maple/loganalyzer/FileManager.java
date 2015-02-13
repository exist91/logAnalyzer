package com.maple.loganalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

//로그 읽어오기 readLineFromLog
//로그 저장하기 writeToLog
//파일에서 한줄씩 읽어오기, 출력값 파일로 저장하기

public class FileManager {

	public void readLineFromlog(String filename) throws IOException {

		String temp;
		ResultStorage storage = ResultStorage.getStorage();

		BufferedReader fileInput = new BufferedReader(new FileReader(filename));

		while ((temp = fileInput.readLine()) != null) {
			storage.addInputLog(temp);
		}

		fileInput.close();
	}

	public void writeResultToLog(String filename) throws FileNotFoundException {
		File outfile = new File(filename);

		PrintStream ps = new PrintStream(new FileOutputStream(outfile));

		PrintStream sysout = System.out;

		System.setOut(ps);
		// System.setErr(ps);

		// 출력할 것 여기에

		System.setOut(sysout);

		ps.close();
	}

}
