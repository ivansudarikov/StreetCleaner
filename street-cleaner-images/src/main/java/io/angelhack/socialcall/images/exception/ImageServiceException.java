package io.angelhack.socialcall.images.exception;

/**
 * This is image service exception and it defines possible errors that can happen during image processing (i.e. image retrieve, upload or whatever)
 *
 * @author Ivan
 * @since 29.08.2016
 */
public class ImageServiceException extends Exception {

    /**
     * Creates new exception with given message.
     *
     * @param message to be assigned to the exception
     * @see Exception#Exception(String)
     */
    public ImageServiceException(String message) {
        super(message);
    }

    /**
     * Creates new exception with given message and caused throwable.
     *
     * @param message   to be assigned to the exception.
     * @param throwable to be used.
     * @see Exception#Exception(String, Throwable)
     */
    public ImageServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Creates new ecception object wrapped
     * @param throwable
     */
    public ImageServiceException(Throwable throwable) {
        super(throwable);
    }
}
