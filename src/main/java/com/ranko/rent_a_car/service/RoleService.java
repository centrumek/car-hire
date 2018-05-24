package com.ranko.rent_a_car.service;

import com.ranko.rent_a_car.model.Role;

import java.util.List;
import java.util.Set;


public interface RoleService {
//	Set<Role> findRolesByUserName(String userName);

	Role findOne(Long id);
	Role findByName(String name);
	List<Role> findAll();
	Role save(Role role);
	void remove(Long id) throws IllegalArgumentException;
}
