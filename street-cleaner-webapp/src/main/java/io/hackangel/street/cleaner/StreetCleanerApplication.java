package io.hackangel.street.cleaner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Ivan on 11.06.2016.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"io"})
@EnableAutoConfiguration
public class StreetCleanerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StreetCleanerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StreetCleanerApplication.class, args);
    }
}