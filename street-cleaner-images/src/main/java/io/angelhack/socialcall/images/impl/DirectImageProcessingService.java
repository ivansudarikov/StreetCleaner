package io.angelhack.socialcall.images.impl;

import io.angelhack.model.ImageCategory;
import io.angelhack.socialcall.images.exception.ImageServiceException;
import io.angelhack.socialcall.images.service.ImageProcessingService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * This implementation of image service uses direct storage of image into server.
 *
 * @author Ivan
 * @since 29.08.2016
 */
@Service
public class DirectImageProcessingService implements ImageProcessingService {

    public static final int BUFFER_SIZE = 8 * 1024;

    @Override
    public String saveImage(InputStream imageStream, ImageCategory category) throws ImageServiceException {
        // TODO we should use file type
        return saveImage(category.getRawType(), imageStream).getName();
    }

    private File saveImage(String type, InputStream initialStream) throws ImageServiceException {
        File folder = new File(File.separator + "images" + File.separator + type + File.separator);
        folder.mkdirs();
        return writeImage(folder, initialStream);
    }

    private File writeImage(File folder, InputStream initialStream) throws ImageServiceException {
        File image = new File(folder, UUID.randomUUID().toString().replace("-", "") + ".jpg");
        // we close input stream right after we save image
        try (InputStream imageInputStream = initialStream) {
            image.createNewFile();
            try (OutputStream outStream = new FileOutputStream(image)) {
                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead;
                while ((bytesRead = imageInputStream.read(buffer)) != -1) {
                    outStream.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            throw new ImageServiceException("Error while save image occurred", e);
        }
        return image;
    }

    @Override
    public byte[] readImage(String path) throws ImageServiceException {
        return new byte[0];
    }
}
