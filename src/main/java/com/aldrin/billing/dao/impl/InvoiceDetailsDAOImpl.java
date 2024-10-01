/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao.impl;

import com.aldrin.billing.dao.InvoiceDetailsDAO;
import static com.aldrin.billing.dao.impl.DBConnection.closeConnection;
import static com.aldrin.billing.dao.impl.DBConnection.getCon;
import com.aldrin.billing.model.InvoiceDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Java Programming with Aldrin
 */
public class InvoiceDetailsDAOImpl extends DBConnection implements InvoiceDetailsDAO {

    @Override
    public void addInvoiceDetails(InvoiceDetails id) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO `invoicedetail` (\n"
                    + "  `InvoiceID`,\n"
                    + "  `ProductID`,\n"
                    + "  `Quantity`,\n"
                    + "  `UnitPrice`\n"
                    + ") VALUES(?,?,?,?) ;");
            ps.setLong(1, id.getInvoice().getInvoiceId());
            ps.setLong(2, id.getProduct().getProductId());
            ps.setInt(3, id.getQuantity());
            ps.setFloat(4, id.getUnitPrice());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<InvoiceDetails> selectInvoiceDetails() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public InvoiceDetails findInvoiceDetailsById(InvoiceDetails invoice) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long getMaxId() {
        Long maxId = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT \n"
                    + "    MAX(INVOICE.InvoiceID) AS InvoiceID  \n"
                    + "FROM \n"
                    + "    INVOICE ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("InvoiceID");
                if (idl == 0) {
                    maxId = 1L;
                } else {
//                    maxId = idl +1;
                    maxId = idl;
                }
            }
            rs.close();
            statement.close();
//            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return maxId;
    }

}
