package io.hackangel.street.cleaner.services.impl;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.mongodb.repos.UserRepository;
import io.angelhack.rest.pojo.response.UserInformation;
import io.angelhack.rest.pojo.response.UserPojo;
import io.hackangel.street.cleaner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @{inheritDoc}
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Searches user in repository by given login.
     * @param login user's login
     * @return user if given login exists, otherwise null.
     */
    public User findUserByLogin(String login) {
        return userRepository.find(login);
    }

    /**
     * {@inheritDoc}
     */
    public void updateUser(UserPojo userPojo) {
        if(userPojo.getLogin()!=null) {
            User user = null;
            if(null != (user=findUserByLogin(userPojo.getLogin()))) {
                updateUserEntityFields(user,userPojo);
                userRepository.save(user);
                updateUserInformation(userPojo);
            }
        }
    }

    private void updateUserInformation(UserPojo userPojo) {
        UserInformation userInformation = (UserInformation) SecurityContextHolder.getContext().getAuthentication().getDetails();
        userInformation.setName(userPojo.getName());
        userInformation.setSurName(userPojo.getSurName());
        userInformation.setEmail(userPojo.getEmail());
        userInformation.setBirth(userPojo.getBirth());
        userInformation.setUserName(userPojo.getLogin());
    }

    private void updateUserEntityFields(User userEntity, UserPojo userPojo) {
        userEntity.setPassword(userPojo.getPassword());
        userEntity.setEmail(userPojo.getEmail());
        userEntity.setName(userPojo.getName());
        userEntity.setSurName(userPojo.getSurName());
        userEntity.setBirth(userPojo.getBirth());
    }
}
