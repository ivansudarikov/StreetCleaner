package io.angelhack.mongodb.repos;

import io.angelhack.mongodb.enitites.User;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@Repository
public class UserRepository extends MongoRepository<User, String> {

    public UserRepository() {
        super(User.class);
    }

    public User findByName(String name) {
        return findOneByField("name",name);
    }
}
