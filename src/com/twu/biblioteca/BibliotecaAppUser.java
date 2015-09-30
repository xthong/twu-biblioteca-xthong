package com.twu.biblioteca;

public class BibliotecaAppUser {

    private String passWord;
    private String name;
    private String emailAddress;
    private String phoneNumber;

    public BibliotecaAppUser(String name, String password, String emailAddress, String phoneNumber) {
        this.name = name;
        this.passWord = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return passWord;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

}
