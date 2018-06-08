package pl.edu.agh.carhire.controller;

import static org.springframework.web.bind.annotation.RequestMethod.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Klasa kontorlujaca kontekst strony glownej
 */
@Controller
public class HomeController {

    /**
     * Metoda restowa typu GET pobierajaca strone glowna.
     * @return home.jsp
     */
    @RequestMapping(value = "/", method=GET)
    public String home() {
        return "home";
    }
}
