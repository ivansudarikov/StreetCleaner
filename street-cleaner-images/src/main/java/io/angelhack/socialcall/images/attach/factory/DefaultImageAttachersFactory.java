package io.angelhack.socialcall.images.attach.factory;

import static io.angelhack.socialcall.images.attach.AttachConstants.AVATAR_ATTACH_SERVICE_BEAN_NAME;
import static io.angelhack.socialcall.images.attach.AttachConstants.ORDER_IMAGE_ATTACH_SERVICE_BEAN_NAME;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.angelhack.model.ImageCategory;
import io.angelhack.socialcall.images.attach.AttachImageService;
import io.angelhack.socialcall.images.attach.AttachImageServicesFactory;
import io.angelhack.socialcall.images.attach.user.AvatarAttachService;

/**
 * @author Ivan
 * @since 30.08.2016
 */
@Service
public class DefaultImageAttachersFactory implements AttachImageServicesFactory {

    /**
     * Class level logger.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(DefaultImageAttachersFactory.class);


    @Qualifier(ORDER_IMAGE_ATTACH_SERVICE_BEAN_NAME)
    @Autowired
    private AttachImageService orderImageAttachService;

    @Qualifier(AVATAR_ATTACH_SERVICE_BEAN_NAME)
    @Autowired
    private AvatarAttachService avatarAttachService;

    @Override
    public AttachImageService getAttachImageService(ImageCategory imageCategory) {
        AttachImageService service = null;
        if (imageCategory != null) {
            switch (imageCategory) {
                case AVATAR:
                    service = avatarAttachService;
                    break;
                case ORDER:
                    service = orderImageAttachService;
                    break;
                default: {
                    LOGGER.error("No attach service found for: " + imageCategory);
                    service = null;
                }
            }
        }
        return service;
    }
}
