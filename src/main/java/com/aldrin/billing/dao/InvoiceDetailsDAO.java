/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.billing.dao;


import com.aldrin.billing.model.InvoiceDetails;
import java.util.List;

/**
 *
 * @author Java Programming with Aldrin
 */
public interface InvoiceDetailsDAO {

    //    add invoice details
    public void addInvoiceDetails(InvoiceDetails invoiceDetails);

//    list of the invoice details
    public List<InvoiceDetails> selectInvoiceDetails();

    public InvoiceDetails findInvoiceDetailsById(InvoiceDetails invoiceDetails);

    public Long getMaxId();
}
