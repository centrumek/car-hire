package com.ranko.rent_a_car.repository;

import com.ranko.rent_a_car.model.Rental;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

	Collection<Rental> findByRentalDate(Date rentalDate) throws DataAccessException;

//	Rental findById(Long id) throws DataAccessException;

}
