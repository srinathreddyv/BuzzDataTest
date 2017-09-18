package com.buzzdata.model;

import java.io.Serializable;

public class ResponseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ResponseObject response;
	
	
	public ResponseObject getResponse() {
		return response;
	}
	public void setResponse(ResponseObject response) {
		this.response = response;
	}
	
	
	
}
