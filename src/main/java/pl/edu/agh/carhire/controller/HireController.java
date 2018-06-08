package pl.edu.agh.carhire.controller;

import pl.edu.agh.carhire.model.Customer;
import pl.edu.agh.carhire.model.Hire;
import pl.edu.agh.carhire.service.CustomerService;
import pl.edu.agh.carhire.service.HireService;
import pl.edu.agh.carhire.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.validation.Valid;


@Controller
@RequestMapping("/customers/{customerId}/hires")
public class HireController {

	private final Logger logger = LoggerFactory.getLogger(HireController.class);

	@Autowired
	private HireService hireService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private CarService carService;

	@ModelAttribute("customer")
	public Customer findCustomer(@PathVariable("customerId") Long id) {
		return customerService.findOneWithHires(id);
	}

	@InitBinder("customer")
	public void initCustomerBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}

	@InitBinder("car")
	public void initCarBinder(WebDataBinder binder) {
		binder.setDisallowedFields("id");
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newHire(Customer customer, Model model) {
		Hire hire = new Hire();
		customer.addHire(hire);
		model.addAttribute("hire", hire);
		model.addAttribute("cars", carService.findAll());
		return "addEditHire";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveNewHire(Customer customer, @Valid Hire hire, BindingResult result, ModelMap model, final RedirectAttributes redirectAttributes) {
		System.out.println("hire: " + hire);
		if (result.hasErrors()) {
			hire.setCustomer(customer);
			model.addAttribute("hire", hire);
			model.addAttribute("cars", carService.findAll());
			return "addEditHire";
		} else {
			redirectAttributes.addFlashAttribute("css", "success");
			redirectAttributes.addFlashAttribute("msg", "Hire saved successfully!");
			customer.addHire(hire);
			hireService.save(hire);
			return "redirect:/customers/{customerId}";
		}
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editHire(Customer customer, @PathVariable Long id, Model model) {
		Hire hire = hireService.findOne(id);
		customer.addHire(hire);
		model.addAttribute("hire", hire);
		model.addAttribute("cars", carService.findAll());
		return "addEditHire";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewHire(@PathVariable("id") Long id, Model model) {
		logger.debug("showHire() id: {}", id);
		Hire hire = hireService.findOne(id);
		if (hire == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "hire not found");
		}
		model.addAttribute("hire", hire);

		return "showHire";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeHire(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
		logger.debug("delete hire: {}", id);
		hireService.remove(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Hire is deleted!");

		return "redirect:/customers/{customerId}";
	}


	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handle(HttpMessageNotReadableException e) {
		logger.warn("Returning HTTP 400 Bad Request", e);
	}
}
