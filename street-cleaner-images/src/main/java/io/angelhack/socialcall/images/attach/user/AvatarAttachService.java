package io.angelhack.socialcall.images.attach.user;

import static io.angelhack.socialcall.images.attach.AttachConstants.AVATAR_ATTACH_SERVICE_BEAN_NAME;

import org.springframework.stereotype.Component;

import io.angelhack.socialcall.images.attach.AttachImageService;
import io.angelhack.socialcall.images.exception.AttachImageException;

/**
 * @author Ivan
 * @since 29.08.2016
 */
@Component(value = AVATAR_ATTACH_SERVICE_BEAN_NAME)
public class AvatarAttachService implements AttachImageService {
    @Override
    public void attachImage(String referenceId, String imagePath) throws AttachImageException {

    }

    @Override
    public void deleteAttachment(String referenceId, String imagePath) throws AttachImageException {

    }
}
