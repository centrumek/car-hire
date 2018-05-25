package com.ranko.rent_a_car.repository;

import com.ranko.rent_a_car.model.Rental;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

	List<Rental> findByRentalDate(Date rentalDate);
	List<Rental> findByRentalDateGreaterThanEqualAndReturnDateLessThanEqual(Date rentalDate, Date returnDate);


}
