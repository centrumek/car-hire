package pl.edu.agh.carhire.controller.converter;

import pl.edu.agh.carhire.model.Car;
import pl.edu.agh.carhire.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * Converts string to Car object. String is id (long).
 * 
 */
@Component
public class StringToVehicleConverter implements Converter<String, Car> {

	@Autowired
	private VehicleService vehicleService;

	@Override
	public Car convert(String id) {
		System.out.println("confd "+ id);
		return vehicleService.findOne(Long.parseLong(id));
	}
}
