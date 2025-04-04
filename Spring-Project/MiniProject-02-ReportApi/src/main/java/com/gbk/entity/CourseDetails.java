package com.gbk.entity;


import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="COURSE_DETAILS")
public class CourseDetails {
	@Id
	@GeneratedValue
	private Integer courseId;
	@Column(length=30)
	private String courseName;
	@Column(length=30)
	private String courseCategory;
	@Column(length=30)
	private String facultyName;
	private LocalDateTime startDate;
	@Column(length=30)
	private String location;
	private Double fee;
	@Column(length=30)
	private String adminName;
	private Long adminContact;
	
	private String trainingMode;
	
	private String courseStatus;
	
	@CreationTimestamp
	@Column(insertable=true,updatable=false)
	private LocalDateTime creationDate;
	@UpdateTimestamp
	@Column(insertable=false,updatable=true)
	private LocalDateTime updatedDate;
	@Column(length=30)
	private String createdBy;
	@Column(length=30)
	private String updatedBy;
	
	public String getCourseStatus() {
		return courseStatus;
	}
	public void setCourseStatus(String courseStatus) {
		this.courseStatus = courseStatus;
	}
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
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
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
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}
	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public CourseDetails() {
		// TODO Auto-generated constructor stub
	}
	public CourseDetails(Integer courseId, String courseName, String courseCategory, String facultyName,
			LocalDateTime startDate, String location, Double fee, String adminName, Long adminContact, String trainingMode,
			LocalDateTime creationDate, LocalDateTime updatedDate, String createdBy, String updatedBy,String courseStatus) {
		
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseCategory = courseCategory;
		this.facultyName = facultyName;
		this.startDate = startDate;
		this.location = location;
		this.fee = fee;
		this.adminName = adminName;
		this.adminContact = adminContact;
		this.trainingMode = trainingMode;
		this.creationDate = creationDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.courseStatus=courseStatus;
	}
	@Override
	public String toString() {
		return "CourseDetails [courseId=" + courseId + ", courseName=" + courseName + ", courseCategory="
				+ courseCategory + ", facultyName=" + facultyName + ", startDate=" + startDate + ", location="
				+ location + ", fee=" + fee + ", adminName=" + adminName + ", adminContact=" + adminContact
				+ ", trainingMode=" + trainingMode + ", creationDate=" + creationDate + ", updatedDate=" + updatedDate
				+ ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", courseStatus=" + courseStatus + "]";
	}
	
	
	
	
	

}
