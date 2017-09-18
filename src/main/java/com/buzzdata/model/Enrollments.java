package com.buzzdata.model;

import java.io.Serializable;
import java.util.List;

public class Enrollments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Enrollment> enrollment;
	public List<Enrollment> getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}
	@Override
	public String toString() {
		return "Enrollments [enrollment=" + enrollment + "]";
	}
	
	
	
	
}
