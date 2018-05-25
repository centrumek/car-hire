package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.User;

import java.util.List;


public interface UserService {

	User findOne(Long id);
	User findOneWithRoles(Long id);
	List<User> findAll();
	User findByUserName(String userName);
	User save(User user);
	void remove(Long id) throws IllegalArgumentException;
	User findByUserNameWithRoles(String userName);
	boolean isUsernameUnique(Long id, String username);
}
