package com.tutoriel.conf;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tutoriel.model.AppUser;
import com.tutoriel.service.AccountService;
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
   private AccountService accountService;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	AppUser appUser=accountService.loadUserByUsername(username);
		if(appUser==null) throw new UsernameNotFoundException("invalide");
		Collection<GrantedAuthority>authorities=new ArrayList<>();
		appUser.getAppRoles().forEach(r->{
			
			authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
		});
		return new User(appUser.getUsername(),appUser.getPassword(),authorities);
	}

}
