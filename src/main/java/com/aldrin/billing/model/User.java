/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.model;

import com.aldrin.billing.util.EncryptPassword;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
@ToString
public class User {

    private Long id;
    private String firstname;
    private String surname;
    private String username;
    private String password;
    private java.sql.Timestamp inActiveAt;
    private byte[] photo;
    
    private Role role;

    public User() {

    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        try{
           this.password = new EncryptPassword(password).toString();
        }catch(Exception e){
            e.printStackTrace();
        }  
    }

}
