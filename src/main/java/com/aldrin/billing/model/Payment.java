/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.model;


import java.util.Date;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Java Programming with Aldrin
 */
@Setter
@Getter
public class Payment {

    private Long paymentId;
    private Invoice invoice;
    private Date createdAt;
    private Float amount;
    private String method;
    private User user;

}
