package com.maple.loganalyzer;

import java.util.ArrayList;
import java.util.List;

public class ResultStorage {

	private static ResultStorage resultStorage;

	private List<String> inputLogStorage;

	private ResultStorage() {

		inputLogStorage = new ArrayList<String>();
	}

	protected void addInputLog(String readLine) {

		inputLogStorage.add(readLine);
	}

	protected List<String> getInputLogStorage() {
		return inputLogStorage;
	}

	public static ResultStorage getStorage() {

		if (resultStorage == null) {
			resultStorage = new ResultStorage();
		}

		return resultStorage;
	}
}
