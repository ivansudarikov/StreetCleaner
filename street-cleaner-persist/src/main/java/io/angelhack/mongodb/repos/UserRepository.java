package io.angelhack.mongodb.repos;

import io.angelhack.mongodb.enitites.User;

/**
 * @author Ivan
 * @since 11.06.2016
 */
public interface UserRepository {

    User findOneByName(String name);

}
