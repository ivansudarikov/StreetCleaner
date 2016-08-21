package io.hackangel.street.cleaner.security;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.response.UserInformation;

/**
 * Created by amylniko on 14.07.2016.
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
