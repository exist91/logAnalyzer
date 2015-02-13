package com.maple.loganalyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//apikey 
//api serviceID http://apis.daum.net/search/[\w]+
//웹 브라우저 \b[[A-Z]+\b
//호출시간 \d{4}(-\d{2}){2} \d{2}(:\d{2}){2}

//로그 저장하기
//반환된 값을 받아서 hashmap? 에 저장

//결과 가공하기
//요구조건대로 저장된 값을 가공

public class LogAnalyzer {

	ResultStorage storage = ResultStorage.getStorage();

	public void splitInputLogToData() {

		Pattern inputLogPattern = Pattern
				.compile("\\[(\\d+)\\]\\[http://apis.daum.net/search/([\\w]+)\\?(apikey=([\\w]+)&)?q=([\\w]+)\\]\\[([\\w]+)\\]\\[(\\d{4}(-\\d{2}){2} \\d{2}(:\\d{2}){2})\\]");
		for (String temp : storage.getInputLogStorage()) {

			Matcher patternMatcher = inputLogPattern.matcher(temp);

			if (patternMatcher.find()) {

				// group 1 : statusCode // 2 : API ServiceID // 3 : apikey가 없으면 null 
				// 4 : apikey // 5 : 검색어(q) // 6 : 웹 브라우져 // 7 : 호출시간 //
				 
				System.out.println(patternMatcher.group(1) + " "
						+ patternMatcher.group(2) + " "
						+ patternMatcher.group(3) + " "
						+ patternMatcher.group(4) + " "
						+ patternMatcher.group(5) + " "
						+ patternMatcher.group(6) + " "
						+ patternMatcher.group(7));
			}

		}
	}
	// storeSplitedData

	// analyzeData
}
