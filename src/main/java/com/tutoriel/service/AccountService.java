package com.tutoriel.service;

import org.springframework.stereotype.Service;

import com.tutoriel.model.AppRole;
import com.tutoriel.model.AppUser;

public interface AccountService {
	public AppUser saveUser(String username,String password,String confirmedPassword) ;
	public AppRole saveRole(AppRole role) ;
	public AppUser loadUserByUsername(String username);
	public void addRoleToUser(String Username,String roleName);
	

}
