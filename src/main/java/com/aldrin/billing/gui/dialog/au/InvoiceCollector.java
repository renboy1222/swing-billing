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

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
