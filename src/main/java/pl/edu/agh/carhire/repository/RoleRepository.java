package pl.edu.agh.carhire.repository;

import pl.edu.agh.carhire.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
//	@Query("select ur.role from Role ur, User u where u.userName=?1 and ur.user.id=u.id")
//    public List<String> findRoleByUserName(String username);

//@Query("select u.userName, r.name  from Role r, User u where u.userName=?1 and r.user.id=u.id")
//public Set<Role> findRolesByUserName(String username);

	public Set<Role> findByUsers_Id(String username);
	public Role findByName(String name);
	
}