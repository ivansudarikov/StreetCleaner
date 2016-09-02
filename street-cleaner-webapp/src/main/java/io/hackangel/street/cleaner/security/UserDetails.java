package io.hackangel.street.cleaner.security;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.response.UserInformation;

/**
 * User details which stired in Spring Security session.
 * Contains user (not entity, just pojo)
 *
 * @author amylniko
 */
public class UserDetails  {

    private UserInformation userInformation;

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }
}
