/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao;

import com.aldrin.billing.model.Customer;
import com.aldrin.billing.model.User;
import java.util.List;

/**
 *
 * @author Java Programming with Aldrin
 */
public interface CustomerDAO {

    //    add Customer
    public void addCustomer(Customer customer);

//    update Customer
    public void updateCustomer(Customer customer);

//    delete Customer
    public void deleteCustomer(Customer customer);

//    list of the Customer
    public List<Customer> selectCustomer();

    public void comboBoxCustomer();
    
     public Customer findCustomerById(Customer customer) ;

}
