package pl.edu.agh.carhire.controller;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.edu.agh.carhire.model.Car;
import pl.edu.agh.carhire.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
@Transactional
@RequestMapping("/cars")
public class CarController {

	private final Logger logger = LoggerFactory.getLogger(CarController.class);

	@Autowired
	private CarService carService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

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
		return "redirect:/cars";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String saveCar(@Valid Car car, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		System.out.println(car);
		if(result.hasErrors()) {
			model.addAttribute("car", car);
			return "addEditCar";
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Car saved successfully!");
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
