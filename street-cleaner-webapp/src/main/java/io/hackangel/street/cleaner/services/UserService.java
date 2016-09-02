package io.hackangel.street.cleaner.services;

import io.angelhack.rest.pojo.response.UserPojo;

/**
 * Service for updating and getting information about current user
 */
public interface UserService {

    /**
     * Updates current session user.
     * @param userPojo new information
     */
    void updateUser(UserPojo userPojo);
}
