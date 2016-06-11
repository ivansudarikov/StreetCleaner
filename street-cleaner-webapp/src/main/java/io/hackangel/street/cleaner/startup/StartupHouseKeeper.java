package io.hackangel.street.cleaner.startup;

import io.angelhack.mongodb.repos.impl.DummyRepositories;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@Component
public class StartupHouseKeeper implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        event.getApplicationContext().getBean("dummyRepositories", DummyRepositories.class).onStartUp();
    }
}
