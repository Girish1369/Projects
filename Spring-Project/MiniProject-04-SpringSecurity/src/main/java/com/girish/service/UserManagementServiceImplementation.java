package com.girish.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.girish.entity.UserInfo;
import com.girish.repository.IUserDetailsRepository;

@Service
public class UserManagementServiceImplementation implements IUserManagementService{

	@Autowired
	private IUserDetailsRepository repo;

	@Override
	public String UserRegistration(UserInfo details) {
		BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
		String encode = encoder.encode(details.getPwd());
		details.setPwd(encode);
		Integer id = repo.save(details).getuId();
		return "user is saved with id::"+id;
	}

	@Override
	public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		Optional<UserInfo> optional = repo.findByuName(username);
		if(optional.isEmpty()) {
			throw new IllegalArgumentException("user is not found");
		}else {
			UserInfo details = optional.get();
//			Set<GrantedAuthority> Sga=new HashSet<>();
//			for(String role: details.getRoles()) {
//				SimpleGrantedAuthority sga=new SimpleGrantedAuthority(role);
//				Sga.add(sga);
//				
//			}
//			//convert userdetails object to user
//			User user=new User(details.getuName(),details.getPwd(),Sga);
			User user=new User(details.getuName(),details.getPwd(),details.getRoles().
					stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toSet()));
			return user;
		}
	}
	
	
	

}
