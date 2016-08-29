package io.hackangel.street.cleaner.controllers.image;

import io.angelhack.model.ImageCategory;
import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.status.Status;
import io.angelhack.socialcall.images.attach.AttachImageService;
import io.angelhack.socialcall.images.attach.AttachImageServicesFactory;
import io.angelhack.socialcall.images.exception.AttachImageException;
import io.angelhack.socialcall.images.exception.ImageServiceException;
import io.angelhack.socialcall.images.service.ImageProcessingService;
import io.hackangel.street.cleaner.controllers.ControllerConstants;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;
import java.util.concurrent.Executors;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
@RequestMapping(value = ControllerConstants.IMAGE_CONTROLLER_PATH)
public class ImageProcessingController {

    /**
     * Class level logger.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(ImageProcessingController.class);

    @Autowired
    private ImageProcessingService imageProcessingService;

    @Autowired
    private AttachImageServicesFactory attachImageServicesFactory;

    @RequestMapping(method = RequestMethod.POST, value = "/{imageCategory}/")
    @PreAuthorize("isAuthenticated()")
    public SimpleResponse uploadImage(@PathVariable("imageCategory") String rawImageCategory, @RequestParam("referenceId") String referenceId, @RequestParam("file") MultipartFile file) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(Status.OK);
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


    @RequestMapping("")
    @ResponseBody
    public HttpEntity<byte[]> getImage(@RequestParam(value = "imagepath") String imagePath) throws IOException {
        Path path = Paths.get(imagePath);
        byte[] image = Files.readAllBytes(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG); //or what ever type it is
        headers.setContentLength(image.length);
        return new HttpEntity<byte[]>(image, headers);
    }


}
