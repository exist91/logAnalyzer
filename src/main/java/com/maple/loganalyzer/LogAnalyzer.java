package com.maple.loganalyzer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalyzer {

	public DataModel splitInputLogToData(String inputLog) {

		DataModel result = new DataModel();

		Pattern inputLogPattern = Pattern
				.compile("\\[(\\d+)\\]\\[http://apis.daum.net/search/([\\w]+)\\??(apikey=([\\w]+)&)?q=([\\w]+)\\]\\[([\\w]+)\\]\\[(\\d{4}(-\\d{2}){2} \\d{2}(:\\d{2}){2})\\]");

		Matcher patternMatcher = inputLogPattern.matcher(inputLog);

		if (patternMatcher.find()) {

			result.setStatusCode(patternMatcher.group(1));
			result.setApiServiceID(patternMatcher.group(2));
			if (patternMatcher.group(3) != null) {
				result.setApikey(patternMatcher.group(4));
			}
			result.setQuestion(patternMatcher.group(5));
			result.setBrowser(patternMatcher.group(6));
			result.setTime(patternMatcher.group(7));
		}

		return result;
	}

	public void analyzeData() {

		ResultStorage storage = ResultStorage.getStorage();

		for (String line : storage.getInputLogStorage()) {

			storage.storeData(splitInputLogToData(line));
		}

	}
}
