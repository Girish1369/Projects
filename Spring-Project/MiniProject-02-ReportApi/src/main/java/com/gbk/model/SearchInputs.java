package com.gbk.model;

import java.time.LocalDateTime;


public class SearchInputs {
	
	private String courseCategory;
	private String trainingMode;
	private String facultyName;
	private LocalDateTime startDate;
	

	public String getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}
	public String getTraininMode() {
		return trainingMode;
	}
	public void setTraininMode(String traininMode) {
		this.trainingMode = traininMode;
	}
	public String getfacultyName() {
		return  facultyName;
	}
	public void setfacultyNameName(String facultyName) {
		this. facultyName = facultyName;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public SearchInputs() {
		// TODO Auto-generated constructor stub
	}
	public SearchInputs(String courseCategory, String traininMode, String facultyName, LocalDateTime startDate) {
		
		this.courseCategory = courseCategory;
		this.trainingMode = traininMode;
		this. facultyName = facultyName;
		this.startDate = startDate;
	}
	@Override
	public String toString() {
		return "SearchInputs [courseCategory=" + courseCategory + ", traininMode=" + trainingMode + ", faculityName="
				+  facultyName + ", startDate=" + startDate + "]";
	}
	
	
}
