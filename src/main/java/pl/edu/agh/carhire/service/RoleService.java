package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.Role;

import java.util.List;


public interface RoleService {
//	Set<Role> findRolesByUserName(String userName);

	Role findOne(Long id);
	Role findByName(String name);
	List<Role> findAll();
	Role save(Role role);
	void remove(Long id) throws IllegalArgumentException;
}
