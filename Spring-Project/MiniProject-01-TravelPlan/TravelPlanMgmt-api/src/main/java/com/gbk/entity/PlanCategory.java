package com.gbk.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="PLAN_CATEGORY")
public class PlanCategory {

	@Id
	@SequenceGenerator(name="seq1",initialValue = 1,allocationSize = 1,sequenceName = "cat_sequence")
	@GeneratedValue(generator = "seq1",strategy = GenerationType.SEQUENCE)
	private Integer category_id;
	private String category_name;
	private String active_sw="active";
	
	@Column(name="CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDateTime created_date;
	
	@Column(name="UPDATE_DATE",updatable = true,insertable = false)
	@UpdateTimestamp
	private LocalDateTime updated_date;
	
	private String created_by;
	private String updated_by;
	public Integer getCategory_id() {
		return category_id;
	}
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	public String getCategory_name() {
		return category_name;
	}
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
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
		return "PlanCategory [category_id=" + category_id + ", category_name=" + category_name + ", active_sw="
				+ active_sw + ", created_date=" + created_date + ", updated_date=" + updated_date + ", created_by="
				+ created_by + ", updated_by=" + updated_by + "]";
	}
	
}
