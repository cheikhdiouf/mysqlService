package com.tutoriel;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.tutoriel.model.AppRole;
import com.tutoriel.service.AccountService;

@SpringBootApplication
public class MysqlServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MysqlServiceApplication.class, args);
	}

	/*
	 * @Bean CommandLineRunner start(AccountService accountService) {
	 * 
	 * return args->{ accountService.saveRole(new AppRole(null,"USER"));
	 * accountService.saveRole(new AppRole(null,"ADMIN"));
	 * Stream.of("user1","user2","user3","admin").forEach(u->{
	 * accountService.saveUser("user", "1234", "1234"); }); }; }
	 */
	@Bean
 BCryptPasswordEncoder bCryptPasswordEncoder()
	{
	return new  BCryptPasswordEncoder();
	}
}
