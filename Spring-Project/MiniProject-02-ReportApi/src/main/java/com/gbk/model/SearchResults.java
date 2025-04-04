package com.gbk.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SearchResults {
	private Integer courseId;
	private String courseName;
	private String courseCategory;
	private String facultyName;
	private LocalDateTime startDate;
	private String location;
	private Double fee;
	private Long adminContact;
	private String trainingMode;
	private String courseStatus;
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseCategory() {
		return courseCategory;
	}
	public void setCourseCategory(String courseCategory) {
		this.courseCategory = courseCategory;
	}
	public String getFacultyName() {
		return facultyName;
	}
	public void setFacultyName(String facultyName) {
		this.facultyName = facultyName;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Double getFee() {
		return fee;
	}
	public void setFee(Double fee) {
		this.fee = fee;
	}
	public Long getAdminContact() {
		return adminContact;
	}
	public void setAdminContact(Long adminContact) {
		this.adminContact = adminContact;
	}
	public String getTrainingMode() {
		return trainingMode;
	}
	public void setTrainingMode(String trainingMode) {
		this.trainingMode = trainingMode;
	}
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
	public SearchResults() {
		// TODO Auto-generated constructor stub
	}
	public SearchResults(Integer courseId, String courseName, String courseCategory, String facultyName,
			LocalDateTime startDate, String location, Double fee, Long adminContact, String trainingMode,
			String courseStatus) {
		
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCategory = courseCategory;
		this.facultyName = facultyName;
		this.startDate = startDate;
		this.location = location;
		this.fee = fee;
		this.adminContact = adminContact;
		this.trainingMode = trainingMode;
		this.courseStatus = courseStatus;
	}
	@Override
	public String toString() {
		return "SearchResults [courseId=" + courseId + ", courseName=" + courseName + ", courseCategory="
				+ courseCategory + ", facultyName=" + facultyName + ", startDate=" + startDate + ", location="
				+ location + ", fee=" + fee + ", adminContact=" + adminContact + ", trainingMode=" + trainingMode
				+ ", courseStatus=" + courseStatus + "]";
	}
	
	
	
}
