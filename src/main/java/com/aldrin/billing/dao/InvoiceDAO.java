/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.aldrin.billing.dao;

import com.aldrin.billing.model.Invoice;
import com.aldrin.billing.model.Payment;
import java.util.List;

/**
 *
 * @author Java Programming with Aldrin
 */
public interface InvoiceDAO {

    //    add invoice
    public void addInvoice(Invoice invoice);

//    list of the invoice
    public List<Invoice> selectInvoice();

    public Payment findInvoiceById(Invoice invoice);

    public Long getMaxId();
    
    public void comboBoxInvoice(Long userId);
}
