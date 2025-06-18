package com.girish.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.girish.entity.UserInfo;

public interface IUserDetailsRepository extends JpaRepository<UserInfo, Integer> {
	public Optional<UserInfo> findByuName(String uName);
}
