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

/**
 * Klasa kontrolujaca kontekst auta
 */
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

	/**
	 * Metoda restowa typu GET pobierajaca auto na podstawie modelu
	 * @param carModel model auta
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return cars.jsp
	 */
	@RequestMapping(method=RequestMethod.GET)
	public String getCars(@RequestParam(value="carModel", required=false) String carModel, Model model) {
		Collection<Car> cars = (carModel == null || "".equals(carModel) ? carService.findAll() : carService.findByCarModel(carModel));
		model.addAttribute("cars", cars);

		return "cars";
	}

	/**
	 * Metoda restowa typu GET pobieajaca auto na podstawie ID
	 * @param id auta
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return showCar.jsp
	 */
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

	/**
	 * Metoda restowa typu GET usuwajaca auto po ID
	 * @param id auta
	 * @return przekierowanie do /cars
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeCar(@PathVariable Long id) {
		carService.remove(id);
		return "redirect:/cars";
	}

	/**
	 * Metoda restowa typu POST zapisujaca obiekt auta do bazy
	 * @param car auto do zapisu
	 * @param result wynik zwrotny
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @param redirectAttributes atrybut przekierowania
	 * @return addEditCar.jsp lub przekieroawanie do /cars
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String saveCar(@Valid Car car, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("car", car);
			return "addEditCar";
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Car saved successfully!");
		carService.save(car);
		return "redirect:/cars";
	}

	/**
	 * Metoda restowa typu GET edytujaca auto
	 * @param id id auta
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return addEditCar.jsp
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCar(@PathVariable Long id, Model model) {
		Car car = carService.findOne(id);
		model.addAttribute("car", car);
		return "addEditCar";
	}

	/**
	 * Metoda restowa typu GET inicjalzujaca nowe auto.
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return addEditCar.jsp
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCar(Model model) {
		model.addAttribute("car", new Car());
		return "addEditCar";
	}
}
