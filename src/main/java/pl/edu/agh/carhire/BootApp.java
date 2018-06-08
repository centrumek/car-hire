package pl.edu.agh.carhire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Klasa startujaca aplikacje car-hire za pomocą Spring Boot'a wraz z osadzonym
 * w srodku niej Tomcatem oraz lokalna baza danych Derby.
 */
@EnableAutoConfiguration
@Configuration
@EntityScan("pl.edu.agh.carhire.model")
@ComponentScan("pl.edu.agh.carhire")
@SpringBootApplication()
public class BootApp {
    public static void main(String[] args) {
        SpringApplication.run(BootApp.class, args);
    }

    @Bean
    ServletWebServerFactory servletWebServerFactory(){
        return new TomcatServletWebServerFactory();
    }
}
