package io.hackangel.street.cleaner.mapping;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.response.UserInformationResponse;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by amylniko on 15.08.2016.
 */
@Component(value = "userEntityToUserResponseConverter")
public class UserEntityToUserResponseConverter implements Converter<User, UserInformationResponse> {
    @Override
    public UserInformationResponse convert(User user) {
        UserInformationResponse response = new UserInformationResponse();
        response.setSurName(user.getSurName());
        response.setBirth(user.getBirth());
        response.setEmail(user.getEmail());
        response.setImageId(0);
        response.setName(user.getName());
        return response;
    }
}
