package com.pearson.buzzdata.model;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
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

	private String id;
	private String reference;
	private String flags;
	private String lastpasswordchangeddate;
	private String firstlogindate;
	private String lastlogindate;
	private String creationdate;
	private String creationby;
	private String modifieddate;
	private String  modifiedby;
	private String version;
	
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getFlags() {
		return flags;
	}
	public void setFlags(String flags) {
		this.flags = flags;
	}
	public String getLastpasswordchangeddate() {
		return lastpasswordchangeddate;
	}
	public void setLastpasswordchangeddate(String lastpasswordchangeddate) {
		this.lastpasswordchangeddate = lastpasswordchangeddate;
	}
	public String getFirstlogindate() {
		return firstlogindate;
	}
	public void setFirstlogindate(String firstlogindate) {
		this.firstlogindate = firstlogindate;
	}
	public String getLastlogindate() {
		return lastlogindate;
	}
	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}
	public String getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(String creationdate) {
		this.creationdate = creationdate;
	}
	public String getCreationby() {
		return creationby;
	}
	public void setCreationby(String creationby) {
		this.creationby = creationby;
	}
	public String getModifieddate() {
		return modifieddate;
	}
	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}
	public String getModifiedby() {
		return modifiedby;
	}
	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	

}
