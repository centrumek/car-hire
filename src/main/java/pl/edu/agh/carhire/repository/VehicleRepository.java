package pl.edu.agh.carhire.repository;

import pl.edu.agh.carhire.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

	List<Vehicle> findByCarModel(String carModel);
	List<Vehicle> findByIdNotIn(List<Long> vehicleIDs);

}
