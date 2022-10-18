package com.tutoriel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tutoriel.model.AppRole;
import com.tutoriel.model.AppUser;
import com.tutoriel.repository.AppRoleRepository;
import com.tutoriel.repository.AppUserRepository;


@Service
@Transactional
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AppUserRepository  appUserRepository ;
	@Autowired
	private AppRoleRepository  approleRepository ;
	@Autowired
	BCryptPasswordEncoder  bCryptPasswordEncoder;
	@Override
	public AppUser saveUser(String username, String password, String confirmedPassword) {
		AppUser user=appUserRepository.findByUsername(username);
		if(user!=null) throw new RuntimeException("utilisateur existe deja");
		if(!password.equals(confirmedPassword)) throw new RuntimeException("les deux mots de mot ne sont pas identifique");
		AppUser appUser=new AppUser();
		appUser.setUsername(username);
		appUser.setActived(true);
		appUser.setPassword(bCryptPasswordEncoder.encode(password));
		appUserRepository.save(appUser);
		addRoleToUser(username, "User");
		return appUser;
	}

	@Override
	public AppRole saveRole(AppRole role) {
		// TODO Auto-generated method stub
		return approleRepository.save(role);
	}

	@Override
	public AppUser loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return appUserRepository.findByUsername(username);
	}

	@Override
	public void addRoleToUser(String Username, String roleName) {
		// TODO Auto-generated method stub
		AppUser appUser=appUserRepository.findByUsername(Username);
		AppRole appRole=approleRepository.findByRoleName(roleName);
		appUser.getAppRoles().add(appRole); 
	}

	

}
