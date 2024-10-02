/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.model;



/**
 *
 * @author Java Programming with Aldrin
 */

public class InvoiceDetails {
    private Long invoicecDetailId;
    private Invoice invoice;
    private Product product;
    private Integer quantity;
    private Float unitPrice;

    /**
     * @return the invoicecDetailId
     */
    public Long getInvoicecDetailId() {
        return invoicecDetailId;
    }

    /**
     * @param invoicecDetailId the invoicecDetailId to set
     */
    public void setInvoicecDetailId(Long invoicecDetailId) {
        this.invoicecDetailId = invoicecDetailId;
    }

    /**
     * @return the invoice
     */
    public Invoice getInvoice() {
        return invoice;
    }

    /**
     * @param invoice the invoice to set
     */
    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the unitPrice
     */
    public Float getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }
}
