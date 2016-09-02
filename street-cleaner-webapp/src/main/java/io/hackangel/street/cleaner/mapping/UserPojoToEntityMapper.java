package io.hackangel.street.cleaner.mapping;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.response.UserPojo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component(value = "userPojoToEntityMapper")
public class UserPojoToEntityMapper implements Converter<UserPojo,User> {

    @Override
    public User convert(UserPojo userPojo) {
        User entity = new User();
        entity.setLogin(userPojo.getLogin());
        entity.setName(userPojo.getName());
        entity.setSurName(userPojo.getSurName());
        entity.setEmail(userPojo.getEmail());
        entity.setBirth(userPojo.getBirth());
        entity.setPassword(userPojo.getPassword());
        return entity;
    }
}
