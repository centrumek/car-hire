package com.ranko.rent_a_car.web.converter;

import com.ranko.rent_a_car.model.Vehicle;
import com.ranko.rent_a_car.service.VehicleService;
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
		return vehicleService.findOne(Long.parseLong(id));
	}
}
