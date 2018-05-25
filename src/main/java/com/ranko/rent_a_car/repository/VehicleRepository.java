package com.ranko.rent_a_car.repository;

import com.ranko.rent_a_car.model.Vehicle;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findByCarModel(String carModel);
	List<Vehicle> findByIdNotIn(List<Vehicle> vehicles);

}
