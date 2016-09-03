package io.angelhack.socialcall.images.attach.user;

import static io.angelhack.socialcall.images.attach.AttachConstants.AVATAR_ATTACH_SERVICE_BEAN_NAME;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.angelhack.mongodb.enitites.User;
import io.angelhack.mongodb.repos.UserRepository;
import io.angelhack.rest.pojo.response.UserInformation;
import io.angelhack.socialcall.images.attach.AttachImageService;
import io.angelhack.socialcall.images.exception.AttachImageException;

/**
 * @author Ivan
 * @since 29.08.2016
 */
@Component(value = AVATAR_ATTACH_SERVICE_BEAN_NAME)
public class AvatarAttachService implements AttachImageService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void attachImage(String referenceId, String imagePath) throws AttachImageException {
        String userName = ((UserInformation) SecurityContextHolder.getContext().getAuthentication().getDetails()).getUserName();
        if (!userName.equals(referenceId)) {
            // TODO find better solution
            throw new AttachImageException("You can't change not your own avatar!");
        }
        // TODO A. Mylnikov wtf with user creations?
        User userEntity = userRepository.findOneByField("login", userName);
        userEntity.setImagePath(imagePath);
        userRepository.save(userEntity);
    }

    @Override
    public void deleteAttachment(String referenceId, String imagePath) throws AttachImageException {
        // TODO implement
    }
}
