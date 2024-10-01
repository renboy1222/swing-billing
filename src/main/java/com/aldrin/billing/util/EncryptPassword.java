/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Java Programming with Aldrin
 */
public class EncryptPassword {
    
    String password;

//    String pw = new EncryptPassword(password).toString();
    public EncryptPassword(String password) throws NoSuchAlgorithmException {
        yourPassword(password);
    }
    
    public String yourPassword(String password) throws NoSuchAlgorithmException {
        
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashInBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
//        System.out.println(sb.toString());
        this.password = sb.toString();
        return sb.toString();
    }
    
    public String toString() {
        return password;
    }
    
//    public static void main(String[] args) {
//        try {
//            String pass = new EncryptPassword("USER").toString();
//            
//            System.out.print("USER:" + pass);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
    
}
