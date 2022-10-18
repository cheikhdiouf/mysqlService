package com.tutoriel.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.tutoriel.model.AppUser;
@RepositoryRestResource
public interface AppUserRepository extends JpaRepository<AppUser, Long> {
	public AppUser  findByUsername(String username);
}
