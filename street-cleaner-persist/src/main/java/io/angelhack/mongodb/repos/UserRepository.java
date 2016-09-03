package io.angelhack.mongodb.repos;

import io.angelhack.mongodb.enitites.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@Repository
public class UserRepository extends MongoRepository<User, ObjectId> {

    public UserRepository() {
        super(User.class);
    }

    /**
     * Find user by given login.
     *
     * @param login user's login
     * @return
     */
    public User findByLogin(String login) {
        return findOneByField("login",login);
    }
}
