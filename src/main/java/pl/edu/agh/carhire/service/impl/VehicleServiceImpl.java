package pl.edu.agh.carhire.service.impl;

import pl.edu.agh.carhire.model.Vehicle;
import pl.edu.agh.carhire.repository.VehicleRepository;
import pl.edu.agh.carhire.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	private VehicleRepository vehicleRepository;

	@Override
	public Vehicle findOne(Long id) {
		return vehicleRepository.findById(id).orElse(new Vehicle());
	}

	@Override
	public List<Vehicle> findAll() {
		return vehicleRepository.findAll();
	}

	@Override
	public List<Vehicle> findByCarModel(String carModel) {
		return vehicleRepository.findByCarModel(carModel);
	}

	@Override
	public List<Vehicle> findByIdNotIn(List<Long> vehicleIDs) {
		return vehicleRepository.findByIdNotIn(vehicleIDs);
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
