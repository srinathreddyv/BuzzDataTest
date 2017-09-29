package com.pearson.buzzdata.model;

import java.io.Serializable;

public class EnrollmentResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private EnrollmentObject response;


	public EnrollmentObject getResponse() {
		return response;
	}


	public void setResponse(EnrollmentObject response) {
		this.response = response;
	}


	@Override
	public String toString() {
		return "EnrollmentResponse [response=" + response + "]";
	}
	
	
	
}
