package com.ranko.rent_a_car.service;

import com.ranko.rent_a_car.model.Rental;
import com.ranko.rent_a_car.model.Vehicle;

import java.util.Collection;
import java.util.Date;


public interface RentalService {

	Rental findOne(Long id);
	Collection<Rental> findAll();
	Collection<Rental> findByRentalDate(Date rentalDate);
	Rental save(Rental rental);
	void remove(Long id) throws IllegalArgumentException;
}
