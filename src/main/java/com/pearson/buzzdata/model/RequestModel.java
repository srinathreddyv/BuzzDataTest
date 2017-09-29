package com.pearson.buzzdata.model;

import java.io.Serializable;

public class RequestModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequestObject request ; 
	
	public void setRequest(RequestObject request) {
		this.request = request;
	}
	
	public RequestObject getRequest() {
		return request;
	}

	@Override
	public String toString() {
		return "request=" + request + "]";
	}
	
	

	
	
}
