package pl.edu.agh.carhire.controller.converter;

import pl.edu.agh.carhire.model.Vehicle;
import pl.edu.agh.carhire.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


/**
 * Converts string to Vehicle object. String is id (long).
 * 
 */
@Component
public class StringToVehicleConverter implements Converter<String, Vehicle> {

	@Autowired
	private VehicleService vehicleService;

	@Override
	public Vehicle convert(String id) {
		System.out.println("confd "+ id);
		return vehicleService.findOne(Long.parseLong(id));
	}
}
