package pl.edu.agh.carhire.service;

import pl.edu.agh.carhire.model.Car;

import java.util.List;


public interface CarService {

	Car findOne(Long id);
	List<Car> findAll();
	List<Car> findByCarModel(String carModel);
	List<Car> findByIdNotIn(List<Long> carIDs);
	Car save(Car car);
	void remove(Long id) throws IllegalArgumentException;
}
