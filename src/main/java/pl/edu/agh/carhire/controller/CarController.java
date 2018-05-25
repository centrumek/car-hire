package pl.edu.agh.carhire.controller;

import pl.edu.agh.carhire.model.Car;
import pl.edu.agh.carhire.service.VehicleService;
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
@RequestMapping("/vehicles")
public class CarController {

	private final Logger logger = LoggerFactory.getLogger(CarController.class);

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(method=RequestMethod.GET)
	public String getVehicles(@RequestParam(value="carModel", required=false) String carModel, Model model) {
		Collection<Car> cars = (carModel == null || "".equals(carModel) ? vehicleService.findAll() : vehicleService.findByCarModel(carModel));
		model.addAttribute("cars", cars);

		return "cars";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewVehicle(@PathVariable("id") Long id, Model model) {

		logger.debug("showVehicle() id: {}", id);

		Car car = vehicleService.findOne(id);
		if (car == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "car not found");
		}
		model.addAttribute("car", car);

		return "showVehicle";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeVehicle(@PathVariable Long id) {
		vehicleService.remove(id);
		return "vehicles";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveVehicle(Car car, Model model) {
			vehicleService.save(car);
			return "redirect:/vehicles";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editVehicle(@PathVariable Long id, Model model) {
		Car car = vehicleService.findOne(id);
		model.addAttribute("car", car);
		return "addEditVehicle";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newVehicle(Model model) {
		model.addAttribute("vehicle", new Car());
		return "addEditVehicle";
	}
}
