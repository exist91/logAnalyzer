package com.maple.loganalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Set;

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

		ResultStorage storage = ResultStorage.getStorage();
		ValueComparator valueComparator;
		Set<String> keySet;
		Map<String, Integer> hashMap;
		Entry<String, Integer> maxEntry = null;
		int sum = 0;
		int rankCount = 3;

		File outfile = new File(filename);

		PrintStream ps = new PrintStream(new FileOutputStream(outfile));

		PrintStream sysout = System.out;

		System.setOut(ps);
		// System.setErr(ps);

		System.out.println("최다호출 APIKEY\n");
		hashMap = storage.getApikeyStorage();
		for (Entry<String, Integer> entry : hashMap.entrySet()) {
			if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
				maxEntry = entry;
			}
		}
		System.out.println(maxEntry.getKey() + "\n\n");

		System.out.println("상태코드 별 횟수\n");
		hashMap = storage.getStatusCodeStorage();
		keySet = hashMap.keySet();
		for (String statusCode : keySet) {
			Integer count = hashMap.get(statusCode);
			System.out.println(statusCode + " : " + count);
		}
		System.out.println();

		System.out.println("상위 3개의 API ServiceID와 각각의 요청 수\n");
		hashMap = storage.getApiServiceIdStorage();
		valueComparator = new ValueComparator(hashMap);
		TreeMap<String, Integer> sortedMap = new TreeMap<String, Integer>(
				valueComparator);
		sortedMap.putAll(hashMap);
		keySet = sortedMap.keySet();
		for (String apiServiceId : keySet) {
			Integer count = hashMap.get(apiServiceId);
			if (rankCount > 0) {
				System.out.println(apiServiceId + " : " + count);
			}
			rankCount--;
		}
		System.out.println();

		System.out.println();

		System.out.println("피크 시간대\n");
		hashMap = storage.getTimeStorage();
		maxEntry = null;
		for (Entry<String, Integer> entry : hashMap.entrySet()) {
			if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
				maxEntry = entry;
			}
		}
		System.out.println(maxEntry.getKey() + "\n\n");

		System.out.println("웹 브라우저 별 사용비율\n");
		hashMap = storage.getWebBrowserStorage();
		keySet = hashMap.keySet();
		for (String browser : keySet) {
			Integer count = hashMap.get(browser);
			sum += count;
		}
		for (String browser : keySet) {
			Integer count = hashMap.get(browser);
			System.out.println(browser + " : " + (float) count * 100
					/ (float) sum + "%\n");
		}

		System.setOut(sysout);

		ps.close();
	}
}
