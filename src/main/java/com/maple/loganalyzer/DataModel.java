package com.maple.loganalyzer;

public class DataModel {

	private String statusCode;
	private String apiServiceID;
	private String apikey;
	private String question;
	private String browser;
	private String time;
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getApiServiceID() {
		return apiServiceID;
	}
	public void setApiServiceID(String apiServiceID) {
		this.apiServiceID = apiServiceID;
	}
	public String getApikey() {
		return apikey;
	}
	public void setApikey(String apikey) {
		this.apikey = apikey;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
