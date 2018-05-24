package com.ranko.rent_a_car.web;

import com.ranko.rent_a_car.model.Customer;
import com.ranko.rent_a_car.service.CustomerService;
import com.ranko.rent_a_car.service.RentalService;
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

@Controller
@Transactional
@RequestMapping("/customers")
public class CustomerController {

	private final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RentalService rentalService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
	}

	@RequestMapping(method= RequestMethod.GET)
	public String getCustomers(@RequestParam(value="lastName", required=false) String lastName, @RequestParam(required=false) String firstName, Model model) {
		Collection<Customer> customers = ((lastName == null || "".equals(lastName)) && (firstName == null || "".equals(firstName)) ?
				customerService.findAll() : customerService.findByLastNameAndFirstName(lastName, firstName));
		model.addAttribute("customers", customers);

		return "customers";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "addEditCustomer";
	}

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

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editCustomer(@PathVariable Long id, Model model) {
		Customer customer = customerService.findOne(id);
		model.addAttribute("customer", customer);
		return "addEditCustomer";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String viewCustomer(@PathVariable("id") Long id, Model model) {

		logger.debug("showCustomer() id: {}", id);

		Customer customer = customerService.findOneWithRentals(id);
		if (customer == null) {
			model.addAttribute("css", "danger");
			model.addAttribute("msg", "customer not found");
		}
		model.addAttribute("customer", customer);

		return "showCustomer";

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String removeCustomer(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
		logger.debug("delete customer: {}", id);

		customerService.remove(id);

		redirectAttributes.addFlashAttribute("css", "success");
		redirectAttributes.addFlashAttribute("msg", "Customer is deleted!");

		return "redirect:/customers";
	}

}
