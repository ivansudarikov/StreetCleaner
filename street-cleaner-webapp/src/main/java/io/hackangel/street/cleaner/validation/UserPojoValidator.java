package io.hackangel.street.cleaner.validation;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.response.UserPojo;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by amylniko on 28.07.2016.
 */
@Component(value = "userPojoValidator")
public class UserPojoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        if(clazz.equals(UserPojo.class)) {
            return true;
        }
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        //TODO Implement
    }
}
