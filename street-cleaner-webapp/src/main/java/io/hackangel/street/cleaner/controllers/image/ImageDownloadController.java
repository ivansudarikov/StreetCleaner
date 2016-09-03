package io.hackangel.street.cleaner.controllers.image;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.angelhack.model.ImageCategory;
import io.angelhack.socialcall.images.exception.ImageServiceException;
import io.angelhack.socialcall.images.service.ImageProcessingService;
import io.hackangel.street.cleaner.controllers.ControllerConstants;

/**
 * @author Ivan
 * @since 03.09.2016
 */
@RestController
@RequestMapping(value = ControllerConstants.IMAGE_DOWNLOAD_CONTROLLER_PATH)
public class ImageDownloadController {

    /**
     * Class level logger.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(ImageUploadController.class);

    @Autowired
    private ImageProcessingService imageProcessingService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/{category}/{imageName:.+}")
    public HttpEntity<byte[]> getImage(@PathVariable(value = "category") String category,
                                       @PathVariable(value = "imageName") String imageName) {
        HttpHeaders headers = new HttpHeaders();
        try {
            ImageCategory imageCategory = ImageCategory.getFromStringValue(category);
            byte[] image = imageProcessingService.readImage(imageCategory, imageName);
            headers.setContentType(MediaType.IMAGE_JPEG); //or what ever type it is
            headers.setContentLength(image.length);
            return new HttpEntity<>(image, headers);
        } catch (ImageServiceException e) {
            LOGGER.error("Unable to read image", e);
            return new HttpEntity<>(null, headers);
        }
    }
}
