/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.gui.dialog.au;

import com.aldrin.billing.model.Customer;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Java Programming with Aldrin
 */
@Setter
@Getter
public class PaymentCollector {

    private Float cash;
    private Customer customer;
    private Float change;
    private Float total;

    public PaymentCollector(Float cash, Customer customer, Float change, Float total) {
        this.cash = cash;
        this.customer = customer;
        this.change = change;
        this.total = total;
    }
    
    public PaymentCollector(){
        
    }
    
    private static PaymentCollector paymentCollector;

    /**
     * @return the paymentCollector
     */
    public static PaymentCollector getPaymentCollector() {
        return paymentCollector;
    }

    /**
     * @param aPaymentCollector the paymentCollector to set
     */
    public static void setPaymentCollector(PaymentCollector aPaymentCollector) {
        paymentCollector = aPaymentCollector;
    }
}
