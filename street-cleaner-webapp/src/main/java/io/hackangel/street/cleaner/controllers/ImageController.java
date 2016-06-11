package io.hackangel.street.cleaner.controllers;

import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.status.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
public class ImageController {

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public SimpleResponse uploadImage(@RequestParam("userName") String userName, @RequestParam("file") MultipartFile file) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(Status.OK);
        File image = saveImage(userName, file);
        simpleResponse.setMessage(image.getName());
        return simpleResponse;
    }

    private File saveImage(@RequestParam("userName") String userName, @RequestParam("file") MultipartFile file) {
        File folder = new File("/images/" + userName + "//");
        folder.mkdirs();
        File image = new File(folder, UUID.randomUUID().toString().replace("-", "") + ".jpg");
        try {
            image.createNewFile();
            InputStream initialStream = file.getInputStream();
            try (OutputStream outStream = new FileOutputStream(image)) {
                byte[] buffer = new byte[8 * 1024];
                int bytesRead;
                while ((bytesRead = initialStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }


}
