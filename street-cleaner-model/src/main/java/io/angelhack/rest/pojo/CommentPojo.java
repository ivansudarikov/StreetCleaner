package io.angelhack.rest.pojo;

/**
 * POJO for order comments.
 * Includes only message, user gets from session.
 *
 * @author amylniko
 *
 */
public class CommentPojo {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
