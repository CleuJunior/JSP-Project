package com.javaserverpages.train.javaserverpagesfirst.servlets.model;

import java.io.Serializable;

public class ModelLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    private String login;
    private String password;

    public ModelLogin(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "ModelLogin{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
