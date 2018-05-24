package com.ranko.rent_a_car.service;

import com.ranko.rent_a_car.model.Vehicle;

import java.util.Collection;


public interface VehicleService {

	Vehicle findOne(Long id);
	Collection<Vehicle> findAll();
	Collection<Vehicle> findByCarModel(String carModel);
	Vehicle save(Vehicle vehicle);
	void remove(Long id) throws IllegalArgumentException;
}
