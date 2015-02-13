package com.maple.loganalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultStorage {

	private static ResultStorage resultStorage;

	private List<String> inputLogStorage;
	private Map<String, Integer> statusCodeStorage;
	private Map<String, Integer> apikeyStorage;
	private Map<String, Integer> apiServiceIdStorage;
	private Map<String, Integer> WebBrowserStorage;
	private Map<String, Integer> TimeStorage;

	private ResultStorage() {

		inputLogStorage = new ArrayList<String>();
		statusCodeStorage = new HashMap<String, Integer>();
		apikeyStorage = new HashMap<String, Integer>();
		apiServiceIdStorage = new HashMap<String, Integer>();
		WebBrowserStorage = new HashMap<String, Integer>();
		TimeStorage = new HashMap<String, Integer>();
	}

	public static ResultStorage getStorage() {

		if (resultStorage == null) {
			resultStorage = new ResultStorage();
		}

		return resultStorage;
	}

	protected void addInputLog(String readLine) {

		inputLogStorage.add(readLine);
	}

	protected List<String> getInputLogStorage() {
		return inputLogStorage;
	}

	protected Map<String, Integer> getStatusCodeStorage() {
		return statusCodeStorage;
	}

	protected Map<String, Integer> getApikeyStorage() {
		return apikeyStorage;
	}

	protected Map<String, Integer> getApiServiceIdStorage() {
		return apiServiceIdStorage;
	}

	protected Map<String, Integer> getWebBrowserStorage() {
		return WebBrowserStorage;
	}

	protected Map<String, Integer> getTimeStorage() {
		return TimeStorage;
	}

	private void putDataCounting(Map<String, Integer> storage, String data) {

		if (storage.containsKey(data)) {
			storage.put(data, storage.get(data) + 1);
		} else {
			storage.put(data, 1);
		}

	}

	protected void storeData(DataModel dataModel) {

		String statusCode = dataModel.getStatusCode();
		String apikey = dataModel.getApikey();
		String browser = dataModel.getBrowser();
		String apiServiceId = dataModel.getApiServiceID();
		String time = dataModel.getTime();

		putDataCounting(statusCodeStorage, statusCode);
		if (apikey != null) {
			putDataCounting(apikeyStorage, apikey);
		}
		putDataCounting(WebBrowserStorage, browser);
		putDataCounting(apiServiceIdStorage, apiServiceId);
		putDataCounting(TimeStorage, time);
	}
}
