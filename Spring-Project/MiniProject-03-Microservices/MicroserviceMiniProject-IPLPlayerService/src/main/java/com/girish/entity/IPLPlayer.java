package com.girish.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="IPLPlayer_info")
public class IPLPlayer {
	@Id
	@SequenceGenerator(name="gen1",sequenceName="PID_SEQ",initialValue=1,allocationSize=1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer pId;
	
	@Column(length=20)
	private String pName;
	@Column(length=20)
	private Integer pAge;
	@Column(length=20)
	private String role;
	
	@ManyToOne(targetEntity=IPLTeam.class,cascade=CascadeType.MERGE,fetch=FetchType.EAGER)
	@JoinColumn(name="t_id",referencedColumnName="teamId")
	private IPLTeam team;
	
	
	public IPLPlayer() {
        System.out.println("0-param contructor");
	}
	public IPLPlayer(Integer pId, String pName, Integer pAge, String role,IPLTeam team) {
		this.pId = pId;
		this.pName = pName;
		this.pAge = pAge;
		this.role = role;
		this.team=team;
	}
	public IPLTeam getteam() {
		return team;
	}
	public void setteam(IPLTeam team) {
		this.team=team;
	}
	public Integer getpId() {
		return pId;
	}
	public void setpId(Integer pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public Integer getpAge() {
		return pAge;
	}
	public void setpAge(Integer pAge) {
		this.pAge = pAge;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "IPLPlayer [pId=" + pId + ", pName=" + pName + ", pAge=" + pAge + ", role=" + role + ", team=" + team
				+ "]";
	}
	
	
	

}
