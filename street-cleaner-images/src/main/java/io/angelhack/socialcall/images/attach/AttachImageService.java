package io.angelhack.socialcall.images.attach;

import io.angelhack.socialcall.images.exception.AttachImageException;

/**
 * @author Ivan
 * @since 29.08.2016
 */
public interface AttachImageService {

    /**
     * Attaches given image path to object with given id.
     *
     * @param referenceId unique object id, should not be {@code null}.
     * @param imagePath   unique image path (image id), should not be {@code null}.
     * @throws AttachImageException in case attachment failed, i.e. no such reference object found.
     */
    void attachImage(String referenceId, String imagePath) throws AttachImageException;


    /**
     * Deletes attached image with given image path for given object.
     *
     * @param referenceId unique reference object id, should not be {@code null}.
     * @param imagePath   unique image path (image id), should not be {@code null}.
     * @throws AttachImageException in case delete attachment failed, i.e. no such reference object found.
     */
    void deleteAttachment(String referenceId, String imagePath) throws AttachImageException;
}

