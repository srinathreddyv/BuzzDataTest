package com.pearson.buzzdata.model;

import java.io.Serializable;

public class User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String userid;
	private String username;
	private String firstname;
	private String lastname;
	private String email;
	private String domainid;
	private String domainname;
	private String userspace;
	private String token;
	private String authenticationexpirationminutes;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getDomainname() {
		return domainname;
	}
	public void setDomainname(String domainname) {
		this.domainname = domainname;
	}
	public String getUserspace() {
		return userspace;
	}
	public void setUserspace(String userspace) {
		this.userspace = userspace;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getAuthenticationexpirationminutes() {
		return authenticationexpirationminutes;
	}
	public void setAuthenticationexpirationminutes(
			String authenticationexpirationminutes) {
		this.authenticationexpirationminutes = authenticationexpirationminutes;
	}
	

}
