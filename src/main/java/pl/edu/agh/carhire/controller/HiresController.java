package pl.edu.agh.carhire.controller;

import pl.edu.agh.carhire.model.Hire;
import pl.edu.agh.carhire.service.HireService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Collection;
import java.util.Date;

@Controller
@RequestMapping("/hires")
public class HiresController {

    private final Logger logger = LoggerFactory.getLogger(HiresController.class);

    @Autowired
    private HireService hireService;

/*    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
    }*/

    @RequestMapping(method=RequestMethod.GET)
    public String getHires(@RequestParam(value="hireDate", required=false) @DateTimeFormat(pattern="dd/MM/yyyy") Date hireDate, Model model) {
        Collection<Hire> hires = (hireDate == null || "".equals(hireDate) ? hireService.findAll() : hireService.findByHireDate(hireDate));
        model.addAttribute("hires", hires);

        return "hires";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String removeHire(@PathVariable Long id, final RedirectAttributes redirectAttributes) {
        logger.debug("delete hire: {}", id);

        hireService.remove(id);

        redirectAttributes.addFlashAttribute("css", "success");
        redirectAttributes.addFlashAttribute("msg", "Hire is deleted!");

        return "redirect:/hires";
    }
}
