package pl.edu.agh.carhire.service.impl;

import pl.edu.agh.carhire.model.Car;
import pl.edu.agh.carhire.repository.CarRepository;
import pl.edu.agh.carhire.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarRepository carRepository;

	@Override
	public Car findOne(Long id) {
		return carRepository.findById(id).orElse(new Car());
	}

	@Override
	public List<Car> findAll() {
		return carRepository.findAll();
	}

	@Override
	public List<Car> findByCarModel(String carModel) {
		return carRepository.findByCarModel(carModel);
	}

	@Override
	public List<Car> findByIdNotIn(List<Long> carIDs) {
		return carRepository.findByIdNotIn(carIDs);
	}

	@Override
	public Car save(Car car) {
		return carRepository.save(car);
	}

	@Override
	public void remove(Long id) throws IllegalArgumentException {
		carRepository.deleteById(id);
	}
}
