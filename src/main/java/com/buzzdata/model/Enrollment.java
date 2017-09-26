package com.buzzdata.model;

import java.io.Serializable;

public class Enrollment implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String userid; 
	private String courseid;
	private String roleid; 
	private String domainid; 
	private String reference; 
	private String guid; 
	private String privileges;
	private String status; 
	private String startdate;
	private String enddate; 
	private String flags;
	private String firstactivitydate; 
	private String lastactivitydate;
	private String creationdate; 
	private String creationby; 
	private String modifieddate; 
	private String modifiedby; 
	private String version;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getDomainid() {
		return domainid;
	}
	public void setDomainid(String domainid) {
		this.domainid = domainid;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public String getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getFlags() {
		return flags;
	}
	public void setFlags(String flags) {
		this.flags = flags;
	}
	public String getFirstactivitydate() {
		return firstactivitydate;
	}
	public void setFirstactivitydate(String firstactivitydate) {
		this.firstactivitydate = firstactivitydate;
	}
	public String getLastactivitydate() {
		return lastactivitydate;
	}
	public void setLastactivitydate(String lastactivitydate) {
		this.lastactivitydate = lastactivitydate;
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
	@Override
	public String toString() {
		return "Enrollment [id=" + id + ", userid=" + userid + ", courseid="
				+ courseid + ", roleid=" + roleid + ", domainid=" + domainid
				+ ", reference=" + reference + ", guid=" + guid
				+ ", privileges=" + privileges + ", status=" + status
				+ ", startdate=" + startdate + ", enddate=" + enddate
				+ ", flags=" + flags + ", firstactivitydate="
				+ firstactivitydate + ", lastactivitydate=" + lastactivitydate
				+ ", creationdate=" + creationdate + ", creationby="
				+ creationby + ", modifieddate=" + modifieddate
				+ ", modifiedby=" + modifiedby + ", version=" + version + "]";
	}

	
	
}

