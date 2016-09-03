package io.hackangel.street.cleaner.controllers;

/**
 * Here all REST controller constants are situated.
 *
 * @author Ivan
 * @since 18.08.2016
 */
public final class ControllerConstants {

    private ControllerConstants() {
    }

    /**
     * Defines common rest API prefix for application.
     */
    public static final String API_PREFIX = "/rest/api";

    /**
     * Defines prefix for image processing controller.
     */
    public static final String IMAGE_UPLOAD_CONTROLLER_PATH = API_PREFIX + "/image";

    /**
     * Defines prefix for order processing controller.
     */
    public static final String ORDER_CONTROLLER_PATH = API_PREFIX + "/order";

    /**
     * Defines prefix for user handling controller.
     */
    public static final String USER_CONTROLLER_PATH = API_PREFIX + "/user";

    /**
     * Defines prefix for downloading images to client applications such as mobile app or web-part.l
     */
    public static final String IMAGE_DOWNLOAD_CONTROLLER_PATH = "/image";

    public static final long MAXIMUM_FILE_SIZE_ALLOWED = 650_000;

}
