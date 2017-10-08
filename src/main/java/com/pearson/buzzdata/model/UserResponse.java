package com.pearson.buzzdata.model;

import java.io.Serializable;

public class UserResponse implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserdataResponse response;

	public UserdataResponse getResponse() {
		return response;
	}

	public void setResponse(UserdataResponse response) {
		this.response = response;
	}
	
	
}
