package pl.edu.agh.carhire.controller;

import pl.edu.agh.carhire.model.Customer;
import pl.edu.agh.carhire.service.CustomerService;
import pl.edu.agh.carhire.service.HireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

/**
 * Klasa kontrolujaca kontekst klienta
 */
@Controller
@Transactional
@RequestMapping("/customers")
public class CustomerController {

	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	/**
	 * Metoda restowa typu GET pobierajaca Klientow.
	 * @param lastName nazwisko klienta
	 * @param firstName imie klienta
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return customers.jsp
	 */
	@RequestMapping(method= RequestMethod.GET)
	public String getCustomers(@RequestParam(value="lastName", required=false) String lastName, @RequestParam(required=false) String firstName, Model model) {
		Collection<Customer> customers = ((lastName == null || "".equals(lastName)) && (firstName == null || "".equals(firstName)) ?
				customerService.findAll() : customerService.findByLastNameAndFirstName(lastName, firstName));
		model.addAttribute("customers", customers);

		return "customers";
	}

	/**
	 * Metoda restowa typu GET inicjalizujaca nowego klineta
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return addEditCustomer.jsp
	 */
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "addEditCustomer";
	}

	/**
	 * Metoda restowa typu POST zapisuajca klineta
	 * @param customer klient do zapisu
	 * @param result wynik zwrotny
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @param redirectAttributes atrybut przekierowania
	 * @return addEditCustomer.jsp lub przekierowanie do /customers{customerID}
	 */
	@RequestMapping(method=RequestMethod.POST)
	public String saveCustomer(@Valid Customer customer, BindingResult result, Model model, final RedirectAttributes redirectAttributes) {
		if(result.hasErrors()) {
			model.addAttribute("customer", customer);
			return "addEditCustomer";
		}
		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Customer saved successfully!");
		customerService.save(customer);

		return "redirect:/customers/" + customer.getId();
	}

	/**
	 * Metoda restowa typu GET edytujaca klienta
	 * @param id klienta
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return addEditCustomer.jsp
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCustomer(@PathVariable Long id, Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);
		return "addEditCustomer";
	}

	/**
	 * Metoda restowa typu GET pobierajaca klienta na podstawie ID
	 * @param id klineta
	 * @param model obiekt przeplywajacy miedzy frontem, a backendem.
	 * @return showCustomer.jsp
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewCustomer(@PathVariable("id") Long id, Model model) {

		logger.debug("showCustomer() id: {}", id);

		Customer customer = customerService.findOneWithHires(id);
		if (customer == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "customer not found");
		}
		model.addAttribute("customer", customer);

		return "showCustomer";

	}

	/**
	 * Metoda restowa typu GET usuwajaca klienta po ID
	 * @param id klienta
	 * @param redirectAttributes atrybut przekirowania
	 * @return przekierowanie do /customers
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeCustomer(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
		logger.debug("delete customer: {}", id);

		customerService.remove(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Customer is deleted!");

		return "redirect:/customers";
	}

}
