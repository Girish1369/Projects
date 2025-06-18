package com.girish.entity;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Security_Info")
public class UserInfo {

	@Id 
	@SequenceGenerator(name="gen1",sequenceName = "UID_SEQ",allocationSize = 1,initialValue = 1)
	@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
	private Integer uId;
	@Column(length=45,nullable=false,unique=true)
	private String uName;
	
	@Column(length=70,nullable=false)
	private String pwd;
	
	@Column(length=100,nullable=false)
	private String email;
	
	private boolean status=true;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="Security_Roles",
	joinColumns=@JoinColumn(name="userId",referencedColumnName="uId"))
	@Column(name="role")
	private Set<String> roles;
	public UserInfo() {
		// TODO Auto-generated constructor stub
	}
	public UserInfo(Integer uId, String uName, String pwd, String email, boolean status, Set<String> roles) {
		this.uId = uId;
		this.uName = uName;
		this.pwd = pwd;
		this.email = email;
		this.status = status;
		this.roles = roles;
	}
	public Integer getuId() {
		return uId;
	}
	public void setuId(Integer uId) {
		this.uId = uId;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Set<String> getRoles() {
		return roles;
	}
	public void setRoles(Set<String> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "UserInfo [uId=" + uId + ", uName=" + uName + ", pwd=" + pwd + ", email=" + email + ", status=" + status
				+ ", roles=" + roles + "]";
	}
	
	
	
}
