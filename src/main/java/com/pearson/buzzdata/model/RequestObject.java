package com.pearson.buzzdata.model;

import java.io.Serializable;

public class RequestObject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd;
	private String username;
	private String password;
	public String getCmd() {
		return cmd;
	}
	public void setCmd(String cmd) {
		this.cmd = cmd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
