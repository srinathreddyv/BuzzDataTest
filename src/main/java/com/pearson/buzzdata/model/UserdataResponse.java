package com.pearson.buzzdata.model;

import java.io.Serializable;

public class UserdataResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _token;
	private String code;
	private Users users;
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
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	
}
