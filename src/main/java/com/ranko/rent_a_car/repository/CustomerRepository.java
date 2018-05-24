package com.ranko.rent_a_car.repository;

import com.ranko.rent_a_car.model.Customer;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByLastName(String lastName) throws DataAccessException;
	List<Customer> findByLastNameAndFirstNameOrderByLastNameAscAllIgnoreCase(String lastName, String firstName);

	@Query("SELECT DISTINCT customer FROM Customer customer left join fetch customer.rentals WHERE customer.lastName LIKE :lastName%")
	public Collection<Customer> findByLastNameWithRentals(@Param("lastName") String lastName);

	@Query("SELECT customer FROM Customer customer left join fetch customer.rentals WHERE customer.id =:id")
	public Customer findByIdWithRentals(@Param("id") Long id);
}
