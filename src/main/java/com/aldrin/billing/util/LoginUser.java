/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.util;

import com.aldrin.billing.model.User;

/**
 *
 * @author Java Programming with Aldrin
 */
public class LoginUser {

    private static String password;

    private static User user;

    public LoginUser() {
        getUser();
    }

    /**
     * @return the user
     */
    public static User getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUser(User aUser) {
        user = aUser;
    }

    /**
     * @return the password
     */
    public static String getPassword() {
        return password;
    }

    /**
     * @param aPassword the password to set
     */
    public static void setPassword(String aPassword) {
        password = aPassword;
    }
}
