package com.ranko.rent_a_car.web;

import com.ranko.rent_a_car.model.Rental;
import com.ranko.rent_a_car.service.RentalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping("/rentals")
public class RentalsController {

    private final Logger logger = LoggerFactory.getLogger(RentalsController.class);

    @Autowired
    private RentalService rentalService;

/*    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }*/

    @RequestMapping(method=RequestMethod.GET)
    public String getRentals(@RequestParam(value="rentalDate", required=false) @DateTimeFormat(pattern="dd/MM/yyyy") Date rentalDate, Model model) {
        Collection<Rental> rentals = (rentalDate == null || "".equals(rentalDate) ? rentalService.findAll() : rentalService.findByRentalDate(rentalDate));
        model.addAttribute("rentals", rentals);

        return "rentals";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String removeRental(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
        logger.debug("delete rental: {}", id);

        rentalService.remove(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Rental is deleted!");

        return "redirect:/rentals";
    }
}
