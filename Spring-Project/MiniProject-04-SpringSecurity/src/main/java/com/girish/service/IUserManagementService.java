package com.girish.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.girish.entity.UserInfo;

public interface IUserManagementService extends UserDetailsService{

	public String UserRegistration(UserInfo details);
}
