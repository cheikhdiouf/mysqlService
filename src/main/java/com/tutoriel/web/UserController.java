package com.tutoriel.web;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tutoriel.model.AppUser;
import com.tutoriel.service.AccountService;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@RestController
public class UserController {
	@Autowired
	private AccountService accountService;
	
	//@RequestMapping(value ="/register", method = RequestMethod.POST)
	@PostMapping("/register")
	public AppUser register(@RequestBody UserForm  userForm) 
	{
		return accountService.saveUser(userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword());
	}

}

@Data
@Setter @Getter
class UserForm{
private	String username;
private	String	password; 
private	String confirmedPassword;
	
}
