package pl.edu.agh.carhire.repository;

import pl.edu.agh.carhire.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    @Query("SELECT user FROM User user left join fetch user.roles WHERE user.id = :id")
    User findByUserIdWithRoles(@Param("id") Long id);

    @Query("SELECT user FROM User user left join fetch user.roles WHERE user.username = :username")
    User findByUserNameWithRoles(@Param("username") String userName);
    
}