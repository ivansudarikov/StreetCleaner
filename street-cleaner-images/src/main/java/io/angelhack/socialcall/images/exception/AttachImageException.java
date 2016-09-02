package io.angelhack.socialcall.images.exception;

/**
 * @author Ivan
 * @since 29.08.2016
 */
public class AttachImageException extends Exception {
    /**
     * Creates new exception with given message.
     *
     * @param message to be assigned to the exception
     * @see Exception#Exception(String)
     */
    public AttachImageException(String message) {
        super(message);
    }

    /**
     * Creates new exception with given message and caused throwable.
     *
     * @param message   to be assigned to the exception.
     * @param throwable to be used.
     * @see Exception#Exception(String, Throwable)
     */
    public AttachImageException(String message, Throwable throwable) {
        super(message, throwable);
    }

    /**
     * Creates new ecception object wrapped
     *
     * @param throwable
     */
    public AttachImageException(Throwable throwable) {
        super(throwable);
    }
}
