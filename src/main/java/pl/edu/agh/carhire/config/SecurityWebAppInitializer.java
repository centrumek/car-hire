package pl.edu.agh.carhire.config;

import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
/**
 * Initializer class registers the springSecurityFilter with application war
*/
@Order(2)
public class SecurityWebAppInitializer extends AbstractSecurityWebApplicationInitializer {

}
