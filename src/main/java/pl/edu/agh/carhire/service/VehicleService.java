package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.Vehicle;

import java.util.List;


public interface VehicleService {

	Vehicle findOne(Long id);
	List<Vehicle> findAll();
	List<Vehicle> findByCarModel(String carModel);
	List<Vehicle> findByIdNotIn(List<Long> vehicleIDs);
	Vehicle save(Vehicle vehicle);
	void remove(Long id) throws IllegalArgumentException;
}
