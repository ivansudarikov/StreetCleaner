package io.hackangel.street.cleaner.mapping;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.response.UserPojo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by amylniko on 09.08.2016.
 */
@Component(value = "userEntityToPojoMapper")
public class UserEntityToPojoMapper implements Converter<User,UserPojo> {

    @Override
    public UserPojo convert(User user) {
        UserPojo userPojo = new UserPojo();
        userPojo.setBirth(user.getBirth());
        userPojo.setSurName(user.getSurName());
        userPojo.setEmail(user.getEmail());
        userPojo.setName(user.getLogin());
        return userPojo;
    }
}
