package com.pearson.buzzdata.model;

import java.io.Serializable;


public class EnrollmentObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _token;
	private String code;
	private Enrollments enrollments;
	public String get_token() {
		return _token;
	}
	public void set_token(String _token) {
		this._token = _token;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Enrollments getEnrollments() {
		return enrollments;
	}
	public void setEnrollments(Enrollments enrollments) {
		this.enrollments = enrollments;
	}
	
	@Override
	public String toString() {
		return "EnrollmentObject [_token=" + _token + ", code=" + code
				+ ", enrollments=" + enrollments + "]";
	}
	
}
