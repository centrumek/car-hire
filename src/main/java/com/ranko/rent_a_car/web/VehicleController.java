package com.ranko.rent_a_car.web;

import com.ranko.rent_a_car.model.Vehicle;
import com.ranko.rent_a_car.service.VehicleService;
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
public class VehicleController {

	private final Logger logger = LoggerFactory.getLogger(VehicleController.class);

	@Autowired
	private VehicleService vehicleService;

	@RequestMapping(method=RequestMethod.GET)
	public String getVehicles(@RequestParam(value="carModel", required=false) String carModel, Model model) {
		Collection<Vehicle> vehicles = (carModel == null || "".equals(carModel) ? vehicleService.findAll() : vehicleService.findByCarModel(carModel));
		model.addAttribute("vehicles", vehicles);

		return "vehicles";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewVehicle(@PathVariable("id") Long id, Model model) {

		logger.debug("showVehicle() id: {}", id);

		Vehicle vehicle = vehicleService.findOne(id);
		if (vehicle == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "vehicle not found");
		}
		model.addAttribute("vehicle", vehicle);

		return "showVehicle";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeVehicle(@PathVariable Long id) {
		vehicleService.remove(id);
		return "vehicles";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveVehicle(Vehicle vehicle, Model model) {
			vehicleService.save(vehicle);
			return "redirect:/vehicles";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editVehicle(@PathVariable Long id, Model model) {
		Vehicle vehicle = vehicleService.findOne(id);
		model.addAttribute("vehicle", vehicle);
		return "addEditVehicle";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newVehicle(Model model) {
		model.addAttribute("vehicle", new Vehicle());
		return "addEditVehicle";
	}
}
