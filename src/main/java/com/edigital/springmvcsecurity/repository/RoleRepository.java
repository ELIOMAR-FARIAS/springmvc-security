package com.edigital.springmvcsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edigital.springmvcsecurity.model.Role;

@Repository
public interface RoleRepository  extends JpaRepository<Role, Long>{
	

}
