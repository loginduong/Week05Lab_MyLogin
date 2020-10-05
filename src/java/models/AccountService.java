/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.ArrayList;

/**
 *
 * @author 760483
 */
public class AccountService {

    private final String PASSWORD = "password";
    private ArrayList<String> usernames;

    public User login(String username, String password) {
        usernames.add("abe");
        usernames.add("barb");

        if (usernames.contains(username) && password.equals(this.PASSWORD)) {
            User user = new User(username, null);
            return user;
        } else {
            return null;
        }

    }

}
