package io.hackangel.street.cleaner.security;

import io.angelhack.mongodb.enitites.User;

/**
 * Created by amylniko on 14.07.2016.
 */
public class UserDetails  {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if(user==null)
            this.user = user;
    }
}
