package io.angelhack.mongodb.repos.configuartion;

import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.mongodb.repos.UserRepository;
import io.angelhack.mongodb.repos.impl.DummyRepositories;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ivan
 * @since 11.06.2016
 * TODO: Normal persistence configuration
 */
@Configuration
public class DummyPersistenceConfiguration {

    private final DummyRepositories dummyRepositories;

    public DummyPersistenceConfiguration() {
        this.dummyRepositories = new DummyRepositories();
    }

    @Bean(autowire = Autowire.BY_NAME)
    OrderRepository orderRepository(){
        return dummyRepositories;
    }

    @Bean(autowire = Autowire.BY_NAME)
    UserRepository userRepository(){
        return dummyRepositories;
    }

    @Bean(autowire = Autowire.BY_NAME, name = "dummyRepositories")
    DummyRepositories dummyRepositories() {
        return dummyRepositories;
    }

}
