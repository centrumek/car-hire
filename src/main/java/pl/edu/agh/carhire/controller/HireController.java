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

/**
 * Klasa kontrolujaca kontekst danego wypozyczenia
 */
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

	/**
	 * Metoda restowa typu GET inicjalizujaca nowe wypozyczenie
	 * @param customer klient wypozyczajacy
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return addEditHire.jsp
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newHire(Customer customer, Model model) {
		Hire hire = new Hire();
		customer.addHire(hire);
		model.addAttribute("hire", hire);
		model.addAttribute("cars", carService.findAll());
		return "addEditHire";
	}

	/**
	 * Metoda restowa typu POST zapisujaca do bazy danych wypozyczenie.
	 * @param customer klient wypozyczajacy
	 * @param hire dane wypozyczenia
	 * @param result informacja zwrotna
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @param redirectAttributes atrybut przekierowania
	 * @return addEditHire.jsp lub przekierowanie do /customers/{customerID}
	 */
	@RequestMapping(method = RequestMethod.POST)
	public String saveNewHire(Customer customer, @Valid Hire hire, BindingResult result, ModelMap model, final RedirectAttributes redirectAttributes) {
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

	/**
	 * Metoda restowa typu GET edytujaca dane wypozyczenie
	 * @param customer klient wypozyczajacy
	 * @param id wypozyczenia
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return addEditHire.jsp
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editHire(Customer customer, @PathVariable Long id, Model model) {
		Hire hire = hireService.findOne(id);
		customer.addHire(hire);
		model.addAttribute("hire", hire);
		model.addAttribute("cars", carService.findAll());
		return "addEditHire";
	}

	/**
	 * Metoda restowa typu GET pobierajaca dane wypozyczenie
	 * @param id wypozyczenia
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return showHire.jsp
	 */
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

	/**
	 * Metoda restowa typu GET usuwajaca dane wypozyczenie po ID.
	 * @param id wypozyczenia
	 * @param redirectAttributes atrybut przekierowania
	 * @return przekierowanie do /customers/{customerID}
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeHire(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
		logger.debug("delete hire: {}", id);
		hireService.remove(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Hire is deleted!");

		return "redirect:/customers/{customerId}";
	}


	/**
	 * Metoda trzymajaca brak odczytu wiadomosci HTTP zwracajaca blad w loggerze
	 * @param e obiekt bledu.
	 */
	@ExceptionHandler
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public void handle(HttpMessageNotReadableException e) {
		logger.warn("Returning HTTP 400 Bad Request", e);
	}
}
