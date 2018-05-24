package com.ranko.rent_a_car.service.impl;

import com.ranko.rent_a_car.model.Rental;
import com.ranko.rent_a_car.repository.RentalRepository;
import com.ranko.rent_a_car.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

@Service
public class RentalServiceImpl implements RentalService {

	@Autowired
	private RentalRepository rentalRepository;

	@Override
	public Rental findOne(Long id) {
		return rentalRepository.findById(id).get();
	}

	@Override
	public Collection<Rental> findAll() {
		return rentalRepository.findAll();
	}

	@Override
	public Collection<Rental> findByRentalDate(Date rentalDate) {
		return rentalRepository.findByRentalDate(rentalDate);
	}

	@Override
	public Rental save(Rental rental) {
		return rentalRepository.saveAndFlush(rental);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		rentalRepository.deleteById(id);
	}
}
