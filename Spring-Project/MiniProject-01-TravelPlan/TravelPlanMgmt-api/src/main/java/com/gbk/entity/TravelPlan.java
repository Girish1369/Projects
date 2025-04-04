package com.gbk.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="TRAVEL_PLAN")
public class TravelPlan {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private Integer plan_id;
	private String plan_name;
	private String plan_description;
	private Double plan_min_budget;
	private Integer plan_category_id;
	private String active_sw="active";
	
	@Column(name="CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDateTime created_date;
	
	@Column(name="UPDATE_DATE",updatable = true,insertable = false)
	@UpdateTimestamp
	private LocalDateTime updated_date;
	
	private String created_by;
	private String updated_by;
	
	public Integer getPlan_id() {
		return plan_id;
	}
	public void setPlan_id(Integer plan_id) {
		this.plan_id = plan_id;
	}
	public String getPlan_name() {
		return plan_name;
	}
	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}
	public String getPlan_description() {
		return plan_description;
	}
	public void setPlan_description(String plan_description) {
		this.plan_description = plan_description;
	}
	public Double getPlan_min_budget() {
		return plan_min_budget;
	}
	public void setPlan_min_budget(Double plan_min_budget) {
		this.plan_min_budget = plan_min_budget;
	}
	public Integer getPlan_category_id() {
		return plan_category_id;
	}
	public void setPlan_category_id(Integer plan_category_id) {
		this.plan_category_id = plan_category_id;
	}
	public String getActive_sw() {
		return active_sw;
	}
	public void setActive_sw(String active_sw) {
		this.active_sw = active_sw;
	}
	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public LocalDateTime getUpdated_date() {
		return updated_date;
	}
	public void setUpdated_date(LocalDateTime updated_date) {
		this.updated_date = updated_date;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	
	@Override
	public String toString() {
		return "TravelPlan [plan_id=" + plan_id + ", plan_name=" + plan_name + ", plan_description=" + plan_description
				+ ", plan_min_budget=" + plan_min_budget + ", plan_category_id=" + plan_category_id + ", active_sw="
				+ active_sw + ", created_date=" + created_date + ", updated_date=" + updated_date + ", created_by="
				+ created_by + ", updated_by=" + updated_by + "]";
	}
	
	
	
}
