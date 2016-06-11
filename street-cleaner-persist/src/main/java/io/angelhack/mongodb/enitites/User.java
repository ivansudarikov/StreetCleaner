package io.angelhack.mongodb.enitites;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by sasha_000 on 10.06.2016.
 */
public class User {

    private String userName;

    private String password;

    List<History> historyList;

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.historyList = new LinkedList<History>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<History> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(List<History> historyList) {
        this.historyList = historyList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", historyList=" + historyList +
                '}';
    }
}
