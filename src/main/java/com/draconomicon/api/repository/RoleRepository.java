package com.draconomicon.api.repository;

import org.springframework.data.repository.CrudRepository;

import com.draconomicon.api.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
	
}
