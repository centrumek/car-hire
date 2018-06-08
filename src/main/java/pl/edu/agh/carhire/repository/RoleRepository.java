package pl.edu.agh.carhire.repository;

import pl.edu.agh.carhire.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	 Role findByName(String name);
}