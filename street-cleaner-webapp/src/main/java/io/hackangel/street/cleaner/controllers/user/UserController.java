package io.hackangel.street.cleaner.controllers.user;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.rest.pojo.response.UserInformationResponse;
import io.angelhack.rest.pojo.response.UserPojo;
import io.angelhack.rest.pojo.response.UserResponse;
import io.angelhack.rest.pojo.response.UserInformation;
import io.angelhack.rest.status.Status;
import io.hackangel.street.cleaner.controllers.ControllerConstants;
import io.hackangel.street.cleaner.security.UserDetails;
import io.hackangel.street.cleaner.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Controller for user operations, such as get information (name, email, etc.),
 * update user information, upload new order.
 *
 * @author Ivan
 * @author Aleksandr Mylnikov
 * @since 11.06.2016
 */
@RestController
@RequestMapping(value = ControllerConstants.USER_CONTROLLER_PATH)
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    /**
     * Converter from Morphia entity to response.
     */
    @Qualifier(value = "userEntityToUserResponseConverter")
    Converter<User, UserInformationResponse> userEntityToPojoConverter;

    /**
     * Gets information about user (name, surname etc.).
     * <p>
     * NOTE! No user id must be sended, because we can get user by jsessionid.
     *
     * @return user's indormation.
     */
    @RequestMapping(method = RequestMethod.GET, value = "/")
    public UserInformation getInfo() {
        UserInformation userInformation = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getDetails()).getUserInformation();
        return userInformation;
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public UserResponse updateUser(@RequestBody UserPojo user) {
        userService.updateUser(user);
        return getUserResponse(Status.OK);
    }

    /**
     * Creates response for operation with given status and user.
     * @param status
     * @param user
     * @return operation response
     */
    private UserResponse getUserResponse(Status status) {
        UserResponse userResponse = new UserResponse();
        userResponse.setStatus(status);
        return userResponse;
    }

}
