/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.billing.dao;

import com.aldrin.billing.gui.panel.BillingData;
import com.aldrin.billing.model.User;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ALDRIN B. C.
 */
public interface UserDAO {

//    add User
    public void addUser(User user);

//    update User
    public void updateUser(User user);

//    delete User
    public void deleteUser(User user);

//    list of the User
    public List<User> selectUser();

    public User loginUser(User user) throws NoSuchAlgorithmException;

    public Boolean changePassword(User user);

    public User findPhotoByUserId(User user);

    public void comboBoxUserAccountAdmin();

    public void comboBoxUserAccountUser();

 

}
