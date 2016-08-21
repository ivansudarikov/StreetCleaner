package io.angelhack.mongodb.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import io.angelhack.mongodb.enitites.Order;
import io.angelhack.mongodb.enitites.User;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.UnknownHostException;

/**
 * Created by amylniko on 26.07.2016.
 */
@Configuration
public class MongoConfiguration {

    private static final String MONGO_HOST_NAME = "localhost";

    private static final int MONGO_PORT = 27017;

    private static final String MONGO_DATABSE_NAME = "Street_Cleaner";

    @Bean
    public Datastore getDB() throws UnknownHostException {
        Mongo mongo = new MongoClient(new ServerAddress(MONGO_HOST_NAME, MONGO_PORT));
        Morphia morphia = new Morphia();
        morphia.map(User.class);
        morphia.map(Order.class);
        return morphia.createDatastore((MongoClient) mongo, MONGO_DATABSE_NAME);
    }

}
