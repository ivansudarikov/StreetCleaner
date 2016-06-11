package io.hackangel.street.cleaner.controllers;

import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.status.Status;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
public class ImageUploadController {

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public SimpleResponse uploadImage(@RequestParam("userName") String userName, @RequestParam("file") MultipartFile file) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(Status.OK);
        simpleResponse.setMessage(file.getContentType());
        return simpleResponse;
    }
}
