package io.hackangel.street.cleaner;

import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.repos.OrderRepository;
import org.mongodb.morphia.geo.GeometryCollection;
import org.mongodb.morphia.geo.Point;
import org.mongodb.morphia.geo.PointBuilder;
import org.mongodb.morphia.query.Shape;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by Ivan on 11.06.2016.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"io"})
@ImportResource("classpath:security.xml")
public class StreetCleanerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(StreetCleanerApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(StreetCleanerApplication.class, args);
    }
}