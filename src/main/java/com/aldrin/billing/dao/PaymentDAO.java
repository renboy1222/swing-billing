/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.billing.dao;

import com.aldrin.billing.model.Payment;
import com.aldrin.billing.model.Product;
import java.util.List;

/**
 *
 * @author Java Programming with Aldrin
 */
public interface PaymentDAO {
    //    add Payment

    public void addPayment(Payment payment);

//    list of the Payment
    public List<Payment> selectPayment();

    public Payment findPaymentById(Payment payment);
}
