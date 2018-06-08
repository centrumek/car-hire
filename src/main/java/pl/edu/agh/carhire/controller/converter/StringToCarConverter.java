package pl.edu.agh.carhire.controller.converter;

import pl.edu.agh.carhire.model.Car;
import pl.edu.agh.carhire.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Klasa odpowiadajaca za konwertowanie id auta z typu String do Long.
 */
@Component
public class StringToCarConverter implements Converter<String, Car> {

	@Autowired
	private CarService carService;

	@Override
	public Car convert(String id) {
		return carService.findOne(Long.parseLong(id));
	}
}
