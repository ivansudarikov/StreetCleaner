package io.hackangel.street.cleaner.mapping;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.response.UserInformation;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by amylniko on 15.08.2016.
 */
@Component(value = "userEntityToUserInformationConverter")
public class UserEntityToUserInformationConverter implements Converter<User, UserInformation> {
    @Override
    public UserInformation convert(User user) {
        UserInformation response = new UserInformation();
        response.setUserName(user.getLogin());
        response.setSurName(user.getSurName());
        response.setBirth(user.getBirth());
        response.setEmail(user.getEmail());
        response.setImagePath(user.getImagePath());
        response.setName(user.getName());
        return response;
    }
}
