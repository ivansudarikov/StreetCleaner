package io.hackangel.street.cleaner.controllers.image;

import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.status.Status;
import io.hackangel.street.cleaner.controllers.ControllerConstants;
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
public class ImageUploadController {


    @RequestMapping(method = RequestMethod.POST, value = "/upload/{imageType}")
    @PreAuthorize("isAuthenticated()")
    public SimpleResponse uploadJpegImage(@PathVariable("imageType") String imageType, @RequestParam("file") MultipartFile file) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(Status.OK);
        File image;
        try {
            image = saveImage("", imageType, file.getInputStream());
            simpleResponse.setMessage(image.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return simpleResponse;
    }

    private File saveImage(String userName, String type, InputStream initialStream) {
        File folder = new File(File.separator + "images" + File.separator + userName + File.separator);
        folder.mkdirs();
        return writeImage(folder, initialStream);
    }

    private File writeImage(File folder, InputStream initialStream) {
        File image = new File(folder, UUID.randomUUID().toString().replace("-", "") + ".jpg");
        try {
            image.createNewFile();
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
