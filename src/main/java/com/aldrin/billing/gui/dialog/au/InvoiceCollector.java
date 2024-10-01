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
public class InvoiceCollector {

    private Float cash;
    private Customer customer;
    private Float change;
    private Float total;
    private String paymentMethod;

    public InvoiceCollector(Float cash, Customer customer, Float change, Float total,String paymentMethod) {
        this.cash = cash;
        this.customer = customer;
        this.change = change;
        this.total = total;
        this.paymentMethod =paymentMethod;
    }
    
    public InvoiceCollector(){
        
    }
    
    private static InvoiceCollector paymentCollector;

    /**
     * @return the paymentCollector
     */
    public static InvoiceCollector getPaymentCollector() {
        return paymentCollector;
    }

    /**
     * @param aPaymentCollector the paymentCollector to set
     */
    public static void setPaymentCollector(InvoiceCollector aPaymentCollector) {
        paymentCollector = aPaymentCollector;
    }
}
