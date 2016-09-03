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
     * Saves given image input stream of given image category.
     *
     * @param image    input stream, should not be {@code null}.
     * @param category image category, avatar, order and etc., should not be {@code null}.
     * @return relative image stored path, to be used in {@link #readImage(ImageCategory, String)} this path will be used as is on webpages.
     * @throws ImageServiceException
     */
    String saveImage(InputStream image, ImageCategory category) throws ImageServiceException;

    /**
     * @param path
     * @return
     * @throws ImageServiceException
     */
    byte[] readImage(ImageCategory category, String name) throws ImageServiceException;
}
