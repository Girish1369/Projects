package com.girish.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="IPL_INFO")
public class IPLTeam implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer teamId;
	@Column(length=20)
	private String teamName;
	@Column(length=20)
	private String teamOwner;
	@Column(length=20)
	private String area;
	public IPLTeam() {
		// TODO Auto-generated constructor stub
	}
	public IPLTeam(Integer teamId, String teamName, String teamOwner, String area) {
		this.teamId = teamId;
		this.teamName = teamName;
		this.teamOwner = teamOwner;
		this.area = area;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamOwner() {
		return teamOwner;
	}
	public void setTeamOwner(String teamOwner) {
		this.teamOwner = teamOwner;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	@Override
	public String toString() {
		return "IPLTeam [teamId=" + teamId + ", teamName=" + teamName + ", teamOwner=" + teamOwner + ", area=" + area
				+ "]";
	}
		
}
