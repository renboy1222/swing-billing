/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.gui.dialog.au;

import com.aldrin.billing.model.Customer;


/**
 *
 * @author Java Programming with Aldrin
 */

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

    /**
     * @return the cash
     */
    public Float getCash() {
        return cash;
    }

    /**
     * @param cash the cash to set
     */
    public void setCash(Float cash) {
        this.cash = cash;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the change
     */
    public Float getChange() {
        return change;
    }

    /**
     * @param change the change to set
     */
    public void setChange(Float change) {
        this.change = change;
    }

    /**
     * @return the total
     */
    public Float getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Float total) {
        this.total = total;
    }
}
