package io.hackangel.street.cleaner.Util;

import io.angelhack.rest.pojo.SimpleResponse;
import io.angelhack.rest.status.Status;

/**
 * Created by amylniko on 31.08.2016.
 */
public class SimpleResponseUtil {

    private static final String OK_MESSAGE = "OK";

    private static final String ERROR_MESSAGE = "ERROR";

    public static SimpleResponse getGoodResponse(String message) {
        SimpleResponse response = new SimpleResponse();
        response.setMessage(message);
        response.setStatus(Status.OK);
        return response;
    }

    public static SimpleResponse getGoodResponse() {
        return getGoodResponse(OK_MESSAGE);
    }

    public static SimpleResponse getBadResponse(String message) {
        SimpleResponse response = new SimpleResponse();
        response.setStatus(Status.ERROR);
        return response;
    }

    public static SimpleResponse getBadResponse() {
        return getBadResponse(ERROR_MESSAGE);
    }



}
