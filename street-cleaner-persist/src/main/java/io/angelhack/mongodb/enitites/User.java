package io.angelhack.mongodb.enitites;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;
import org.mongodb.morphia.annotations.Indexed;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class User {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String login;

    private String name;

    private String password;

    private String surName;

    private String phoneNumber;

    private String email;

    private Date birth;

    private String imagePath;

    @Embedded
    private List<History> historyList;

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

    public User(String userName, String password, String phoneNumber) {
        this.name = userName;
        this.password = password;
		this.phoneNumber = phoneNumber;
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
        if(historyList==null) {
            historyList = new ArrayList<>();
        }
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

    public ObjectId getId() {
        return id;
    }

    @Override
	public String toString() {
		return "User{" +
				"login='" + login + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", surName='" + surName + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", email='" + email + '\'' +
				", birth=" + birth +
				", imagePath=" + imagePath +
				", historyList=" + historyList +
				'}';
	}


}
