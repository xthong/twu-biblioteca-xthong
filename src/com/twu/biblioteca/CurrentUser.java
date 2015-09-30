package com.twu.biblioteca;

public class CurrentUser {

    private final String name;
    private final String password;

    public CurrentUser(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

}
