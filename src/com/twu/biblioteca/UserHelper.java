package com.twu.biblioteca;

import java.util.Arrays;
import java.util.List;

public class UserHelper {
    private final List<BibliotecaAppUser> BibliotecaAppUsers;

    public UserHelper() {
        BibliotecaAppUsers = Arrays.asList(new BibliotecaAppUser("xthong", "111", "123@qq.com", "12345678"));
    }

    public UserHelper(List<BibliotecaAppUser> bibliotecaAppUsers) {
        this.BibliotecaAppUsers = bibliotecaAppUsers;
    }

    public boolean logIn(CurrentUser currentUser) {
        boolean status =false;
        for (BibliotecaAppUser user : BibliotecaAppUsers){
            if (user.getName().equals(currentUser.getName()) && user.getPassword().equals(currentUser.getPassword())){
                status=true;
            }
        }
        return status;
    }

    public List<BibliotecaAppUser> getUsers() {
        return BibliotecaAppUsers;
    }

    public BibliotecaAppUser getUserDetail(String name) {
        BibliotecaAppUser user = null;
        for (BibliotecaAppUser bibliotecaAppUser:BibliotecaAppUsers){
            if (bibliotecaAppUser.getName().equals(name)){
                user=bibliotecaAppUser;
            }
        }
        return user ;
    }

}
