/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao.impl;

import com.aldrin.billing.dao.PaymentDAO;
import static com.aldrin.billing.dao.impl.DBConnection.closeConnection;
import static com.aldrin.billing.dao.impl.DBConnection.getCon;
import com.aldrin.billing.model.Payment;
import java.util.List;

/**
 *
 * @author Java Programming with Aldrin
 */
public class PaymentDAOImpl extends DBConnection implements PaymentDAO {

    @Override
    public void addPayment(Payment payment) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO `payment` (\n"
                    + "  `InvoiceID`,\n"
                    + "  `PaymentDate`,\n"
                    + "  `Amount`,\n"
                    + "  `PaymentMethod`,\n"
                    + "  `UserID`) VALUES(?,NOW(),?,?,?) ;");
            ps.setLong(1, payment.getInvoice().getInvoiceId());
            ps.setFloat(2, payment.getAmount());
            ps.setString(3, payment.getMethod());
            ps.setLong(4, payment.getUser().getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Payment> selectPayment() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Payment findPaymentById(Payment payment) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
