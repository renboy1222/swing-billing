/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Java Programming with Aldrin
 */
@Setter
@Getter
public class InvoiceDetails {
    private Long invoicecDetailId;
    private Invoice invoice;
    private Product product;
    private Integer quantity;
    private Float unitPrice;
}
