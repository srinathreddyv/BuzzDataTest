package com.pearson.buzzdata.model;

import java.io.Serializable;

public class ResponseObject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _token;
	private String code;
	private User user ;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
