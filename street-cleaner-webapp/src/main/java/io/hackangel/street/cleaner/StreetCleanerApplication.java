package io.hackangel.street.cleaner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Ivan on 11.06.2016.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"io"})
@EnableAutoConfiguration
public class StreetCleanerApplication {

    public static void main(String[] args) {
        SpringApplication.run(StreetCleanerApplication.class, args);
    }
}