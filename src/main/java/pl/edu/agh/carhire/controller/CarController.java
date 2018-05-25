package pl.edu.agh.carhire.controller;

import pl.edu.agh.carhire.model.Car;
import pl.edu.agh.carhire.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@Controller
@RequestMapping("/cars")
public class CarController {

	private final Logger logger = LoggerFactory.getLogger(CarController.class);

	@Autowired
	private CarService carService;

	@RequestMapping(method=RequestMethod.GET)
	public String getCars(@RequestParam(value="carModel", required=false) String carModel, Model model) {
		Collection<Car> cars = (carModel == null || "".equals(carModel) ? carService.findAll() : carService.findByCarModel(carModel));
		model.addAttribute("cars", cars);

		return "cars";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewCar(@PathVariable("id") Long id, Model model) {

		logger.debug("showCar() id: {}", id);

		Car car = carService.findOne(id);
		if (car == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "car not found");
		}
		model.addAttribute("car", car);

		return "showCar";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeCar(@PathVariable Long id) {
		carService.remove(id);
		return "cars";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveCar(Car car, Model model) {
			carService.save(car);
			return "redirect:/cars";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCar(@PathVariable Long id, Model model) {
		Car car = carService.findOne(id);
		model.addAttribute("car", car);
		return "addEditCar";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCar(Model model) {
		model.addAttribute("car", new Car());
		return "addEditCar";
	}
}
