package io.hackangel.street.cleaner.controllers.image;

import static io.hackangel.street.cleaner.controllers.ControllerConstants.MAXIMUM_FILE_SIZE_ALLOWED;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.angelhack.model.ImageCategory;
import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.status.Status;
import io.angelhack.socialcall.images.attach.AttachImageService;
import io.angelhack.socialcall.images.attach.AttachImageServicesFactory;
import io.angelhack.socialcall.images.exception.AttachImageException;
import io.angelhack.socialcall.images.exception.ImageServiceException;
import io.angelhack.socialcall.images.service.ImageProcessingService;
import io.hackangel.street.cleaner.controllers.ControllerConstants;

/**
 * This controller is used for image uploading from client.
 *
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
@RequestMapping(value = ControllerConstants.IMAGE_UPLOAD_CONTROLLER_PATH)
public class ImageUploadController {

    /**
     * Class level logger.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(ImageUploadController.class);
    public static final String IMAGE_JPEG = "image/jpeg";

    @Autowired
    private ImageProcessingService imageProcessingService;

    @Autowired
    private AttachImageServicesFactory attachImageServicesFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/{imageCategory}/")
    @PreAuthorize("isAuthenticated()")
    public SimpleResponse uploadImage(@PathVariable("imageCategory") String rawImageCategory,
                                      @RequestParam("referenceId") String referenceId,
                                      @RequestParam("file") MultipartFile file) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(Status.OK);
        if (isValidContentType(file.getContentType())) {
            //trying to upload non jpg
            simpleResponse.setStatus(Status.ERROR);
            simpleResponse.setMessage("Content type not jpeg! should be: " + IMAGE_JPEG);
            return simpleResponse;
        }

        if (isValidFileSize(file.getSize())) {
            //trying to upload non jpg
            simpleResponse.setStatus(Status.ERROR);
            simpleResponse.setMessage("File is to large! should be < 1.5 mb");
            return simpleResponse;
        }

        ImageCategory value = ImageCategory.getFromStringValue(rawImageCategory);
        if (value != null) {
            AttachImageService imageService = attachImageServicesFactory.getAttachImageService(value);
            if (imageService != null) {
                try {
                    String imagePath = imageProcessingService.saveImage(file.getInputStream(), value);
                    imageService.attachImage(referenceId, imagePath);
                } catch (ImageServiceException | AttachImageException | IOException e) {
                    simpleResponse.setStatus(Status.ERROR);
                    simpleResponse.setMessage(e.getMessage());
                }
            } else {
                simpleResponse.setStatus(Status.ERROR);
                simpleResponse.setMessage("No image service found!");
            }
        } else {
            simpleResponse.setStatus(Status.ERROR);
            simpleResponse.setMessage("Unknown message category: " + rawImageCategory);
        }
        return simpleResponse;
    }

    private boolean isValidFileSize(long size) {
        return size < MAXIMUM_FILE_SIZE_ALLOWED;
    }

    private boolean isValidContentType(String fileContentType) {
        return StringUtils.isEmpty(fileContentType) || !fileContentType.split(";")[0].equalsIgnoreCase(IMAGE_JPEG);
    }
}
