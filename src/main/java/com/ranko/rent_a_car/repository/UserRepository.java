package com.ranko.rent_a_car.repository;

import com.ranko.rent_a_car.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    @Query("SELECT user FROM User user left join fetch user.roles WHERE user.id = :id")
    public User findByUserIdWithRoles(@Param("id") Long id);

    @Query("SELECT user FROM User user left join fetch user.roles WHERE user.username = :username")
    public User findByUserNameWithRoles(@Param("username") String userName);
    
}