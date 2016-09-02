package io.angelhack.socialcall.images.service;

import io.angelhack.model.ImageCategory;
import io.angelhack.socialcall.images.exception.ImageServiceException;

import java.io.InputStream;

/**
 * @author Ivan
 * @since 29.08.2016
 */
public interface ImageProcessingService {

    /**
     * @param image
     * @param category
     * @return relative image stored path, to be used in {@link }
     * @throws ImageServiceException
     */
    String saveImage(InputStream image, ImageCategory category) throws ImageServiceException;

    /**
     * @param path
     * @return
     * @throws ImageServiceException
     */
    byte[] readImage(String path) throws ImageServiceException;
}
