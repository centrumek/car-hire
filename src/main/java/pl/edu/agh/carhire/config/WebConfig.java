package pl.edu.agh.carhire.config;

import pl.edu.agh.carhire.controller.converter.StringToUserRoleConverter;
import pl.edu.agh.carhire.controller.converter.StringToCarConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Klasa konfiguracyjna aplikacji webowej.
 */
@Configuration
@EnableWebMvc
@ComponentScan("pl.edu.agh.carhire")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    StringToCarConverter stringToCarConverter;

    @Autowired
    StringToUserRoleConverter stringToUserRoleConverter;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/login?error").setViewName("403");
        registry.addViewController("/403").setViewName("403");
        registry.addViewController("/404").setViewName("404");
        registry.addViewController("/admin").setViewName("admin");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * Konfiguracja TilesConfigurer.
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] {
                "/WEB-INF/tiles/tiles.xml"
        });
        tiles.setCheckRefresh(true);
        return tiles;
    }

    /**
     * Konfiguracja ViewResolvers w celu dostarczenia preferowanego widoku.
     */
    @Bean
    public ViewResolver viewResolver() {
        return new TilesViewResolver();
    }

    /**
     * Konfiguracja ResourceHandlers do zaladowania statycznych zasobow takich jak CSS/ Javascript etc...
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
    }

    /**
     * Rejestr formaterow i konwerterow
     * ( w tym przypadku konwerter konwertuje z Stringa car.id zwracany z widoku addEditHires
     * do obiektu Car, wiec Hibernate moze zapisac hire.car do bazy)
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(stringToCarConverter);
        registry.addConverter(stringToUserRoleConverter);
    }

    /**
     * Konfiguracja MessageSource do znajdowania walidacji bledow wiadomosci
     * w pikach konifguracyjnych
     */
    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("validation");
        return messageSource;
    }

}
