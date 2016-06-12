package io.hackangel.street.cleaner.controllers;

import io.angelhack.mongodb.repos.OrderRepository;
import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.status.Status;
import io.hackangel.street.cleaner.services.impl.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;
import java.util.concurrent.Executors;

/**
 * @author Ivan
 * @since 11.06.2016
 */
@RestController
public class ImageController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(method = RequestMethod.POST, value = "/upload")
    public SimpleResponse uploadImage(@RequestParam("userName") String userName, @RequestParam("file") MultipartFile file) {
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(Status.OK);
        File image;
        try {
            image = saveImage(userName, file.getInputStream());
            orderService.saveOrder(userName, image);
            simpleResponse.setMessage(image.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return simpleResponse;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/upload")
    public SimpleResponse uploadImageWithSocket(@RequestParam("userName") String userName) {
        Executors.newSingleThreadExecutor().submit(() -> {
            try (ServerSocket serverSocket = new ServerSocket(8081)) {
                Socket socket = serverSocket.accept();
                File image = saveImage(userName, socket.getInputStream());
                orderService.saveOrder(userName, image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        SimpleResponse simpleResponse = new SimpleResponse();
        simpleResponse.setStatus(Status.OK);
        simpleResponse.setMessage("Port 8081 for image receiving opened!");
        return simpleResponse;
    }

    private File saveImage(String userName, InputStream initialStream ) {
        File folder = new File("/images/" + userName + "//");
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


}
