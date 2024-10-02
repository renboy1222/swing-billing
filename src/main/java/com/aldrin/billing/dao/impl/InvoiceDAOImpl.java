/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao.impl;

import com.aldrin.billing.dao.InvoiceDAO;
import static com.aldrin.billing.dao.impl.DBConnection.closeConnection;
import static com.aldrin.billing.dao.impl.DBConnection.getCon;
import com.aldrin.billing.model.Invoice;
import com.aldrin.billing.model.Payment;
import com.aldrin.billing.util.ComboBoxList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Java Programming with Aldrin
 */

public class InvoiceDAOImpl extends DBConnection implements InvoiceDAO {

    private ArrayList<ComboBoxList> list;

    @Override
    public void addInvoice(Invoice invoice) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO `invoice` (\n"
                    + "  `CustomerID`,\n"
                    + "  `InvoiceDate`,\n"
                    + "  `TotalAmount`) VALUES(?,NOW(),?) ;");
            ps.setLong(1, invoice.getCustomer().getId());
            ps.setFloat(2, invoice.getTotalAmount());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Invoice> selectInvoice() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Payment findInvoiceById(Invoice invoice) {
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

    @Override
    public void comboBoxInvoice(Long userId) {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "   \n"
                    + "FROM\n"
                    + "    `user`\n"
                    + "    INNER JOIN `role` \n"
                    + "        ON (`user`.`role_id` = `role`.`id`)\n"
                    + "    INNER JOIN `payment` \n"
                    + "        ON (`payment`.`UserID` = `user`.`id`)\n"
                    + "    INNER JOIN `invoice` \n"
                    + "        ON (`payment`.`InvoiceID` = `invoice`.`InvoiceID`)\n"
                    + "    INNER JOIN `customer` \n"
                    + "        ON (`invoice`.`CustomerID` = `customer`.`CustomerID`)\n"
                    + "WHERE user.`id` = ? ORDER BY `invoice`.`InvoiceID` ASC ");
            statement.setLong(1, userId);
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("InvoiceID");
                String invoiceId = rs.getString("InvoiceID");

                this.getList().add(new ComboBoxList(idl, invoiceId));
            }
            rs.close();
            statement.close();
            closeConnection();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * @return the list
     */
    public ArrayList<ComboBoxList> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(ArrayList<ComboBoxList> list) {
        this.list = list;
    }
}
