package pl.edu.agh.carhire.repository;

import pl.edu.agh.carhire.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

	List<Car> findByCarModel(String carModel);
	List<Car> findByIdNotIn(List<Long> carIDs);

}
