package io.angelhack.rest.pojo;

import java.util.List;

/**
 * @author amylniko
 */
public class ThankUsersPojo {

    private String message;

    private List<String> users;

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
