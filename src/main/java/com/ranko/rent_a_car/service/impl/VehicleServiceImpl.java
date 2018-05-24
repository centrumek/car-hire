package com.ranko.rent_a_car.service.impl;

import com.ranko.rent_a_car.model.Vehicle;
import com.ranko.rent_a_car.repository.VehicleRepository;
import com.ranko.rent_a_car.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle findOne(Long id) {
		return vehicleRepository.findById(id).get();
	}

	@Override
	public Collection<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public Collection<Vehicle> findByCarModel(String carModel) {
		return vehicleRepository.findByCarModel(carModel);
	}

	@Override
	public Vehicle save(Vehicle vehicle) {
		return vehicleRepository.save(vehicle);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		vehicleRepository.deleteById(id);
	}
}
