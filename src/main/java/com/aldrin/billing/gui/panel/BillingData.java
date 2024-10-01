/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.gui.panel;


import com.aldrin.billing.model.Customer;
import com.aldrin.billing.model.Invoice;
import com.aldrin.billing.model.InvoiceDetails;
import com.aldrin.billing.model.Payment;
import com.aldrin.billing.model.Product;
import com.aldrin.billing.model.Role;
import com.aldrin.billing.model.User;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Java Programming with Aldrin
 */

@Setter
@Getter
public class BillingData {


    private Customer customer;
    private Invoice invoice;
    private InvoiceDetails invoiceDetails;
    private Payment payment;
    private Product product;
    private Role role;
    private User user;
    private String formattedDate;
    
    
}
