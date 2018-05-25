package pl.edu.agh.carhire.service.impl;

import pl.edu.agh.carhire.model.Role;
import pl.edu.agh.carhire.repository.RoleRepository;
import pl.edu.agh.carhire.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findOne(Long id) {
		return roleRepository.findById(id).get();
	}

//	@Override
//	public Set<Role> findRolesByUserName(String userName) {
//		return roleRepository.findRolesByUserName(userName);
//	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		Role role = roleRepository.findById(id).get();
		if (role == null) {
			throw new IllegalArgumentException(String.format(
					"Role with id=%d does not exist.", id));
		}
		roleRepository.deleteById(id);
	}

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
}
