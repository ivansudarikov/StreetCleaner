package io.angelhack.mongodb.enitites;

import com.sun.javafx.beans.IDProperty;
import org.mongodb.morphia.annotations.Id;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by sasha_000 on 10.06.2016.
 */
public class User {

    @Id
    private String login;

    private String name;

    private String password;

    private String surName;

    private String email;

    private Date birth;

    List<History> historyList;

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public User() {}

    public User(String userName, String password) {
        this.name = userName;
        this.password = password;
        this.historyList = new LinkedList<History>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", historyList=" + historyList +
                '}';
    }
}
