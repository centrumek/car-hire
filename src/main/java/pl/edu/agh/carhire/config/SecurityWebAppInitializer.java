package pl.edu.agh.carhire.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
/**
 * Klasa inicjalizujaca rejestr SpringSecurityFilter z aplikacja
*/
@Order(2)
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

}
