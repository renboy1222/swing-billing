/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao.impl;

import com.aldrin.billing.dao.BillingDataDAO;
import com.aldrin.billing.gui.panel.BillingData;
import com.aldrin.billing.model.Customer;
import com.aldrin.billing.model.Invoice;
import com.aldrin.billing.model.InvoiceDetails;
import com.aldrin.billing.model.Payment;
import com.aldrin.billing.model.Product;
import com.aldrin.billing.model.User;
import com.aldrin.billing.util.LoginUser;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Java Programming with Aldrin
 */
public class BillingDataDAOImpl extends DBConnection implements BillingDataDAO {

    @Override
    public ArrayList<BillingData> selectBillingData() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` as Ufirstname \n"
                    + "    , `user`.`surname` as Ulastname \n"
                    + "    , `customer`.`FirstName` as Cfirstname\n"
                    + "    , `customer`.`LastName` as CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
                    + " FROM \n"
                    + "    `user`\n"
                    + "    INNER JOIN `role` \n"
                    + "        ON (`user`.`role_id` = `role`.`id`)\n"
                    + "    INNER JOIN `payment` \n"
                    + "        ON (`payment`.`UserID` = `user`.`id`)\n"
                    + "    INNER JOIN `invoice` \n"
                    + "        ON (`payment`.`InvoiceID` = `invoice`.`InvoiceID`)\n"
                    + "    INNER JOIN `customer` \n"
                    + "        ON (`invoice`.`CustomerID` = `customer`.`CustomerID`)  ORDER BY `invoice`.`InvoiceID` DESC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BillingData> selectBillingDataDetails(Long invoiceID) {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`,`invoice`.`TotalAmount`, `invoice`.`InvoiceDate` "
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date \n"
                    + "    , `user`.`firstname` as Ufirstname\n"
                    + "    , `user`.`surname`as Ulastname\n"
                    + "    , `customer`.`FirstName` as Cfirstname \n"
                    + "    , `customer`.`LastName` as Clastname \n"
                    + "    , `product`.`ProductName`\n"
                    + "    , `product`.`Description`\n"
                    + "    , `invoicedetail`.`Quantity`\n"
                    + "    , `invoicedetail`.`UnitPrice`,  `payment`.`PaymentMethod`\n"
                    + "FROM\n"
                    + "    `user`\n"
                    + "    INNER JOIN `role` \n"
                    + "        ON (`user`.`role_id` = `role`.`id`)\n"
                    + "    INNER JOIN `payment` \n"
                    + "        ON (`payment`.`UserID` = `user`.`id`)\n"
                    + "    INNER JOIN `invoice` \n"
                    + "        ON (`payment`.`InvoiceID` = `invoice`.`InvoiceID`)\n"
                    + "    INNER JOIN `invoicedetail` \n"
                    + "        ON (`invoicedetail`.`InvoiceID` = `invoice`.`InvoiceID`)\n"
                    + "    INNER JOIN `customer` \n"
                    + "        ON (`invoice`.`CustomerID` = `customer`.`CustomerID`)\n"
                    + "    INNER JOIN `product` \n"
                    + "        ON (`invoicedetail`.`ProductID` = `product`.`ProductID`)WHERE  `invoicedetail`.`InvoiceID` = " + invoiceID + " ORDER BY `invoice`.`InvoiceID` DESC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();
                InvoiceDetails invoiceDetails = new InvoiceDetails();
                Product product = new Product();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                product.setProduct(rs.getString("ProductName"));

                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                invoiceDetails.setQuantity(rs.getInt("Quantity"));
                invoiceDetails.setUnitPrice(rs.getFloat("UnitPrice"));

                bd.setInvoiceDetails(invoiceDetails);
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                bd.setProduct(product);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BillingData> selectBillingDataByToday() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` AS Ufirstname \n"
                    + "    , `user`.`surname` AS Ulastname \n"
                    + "    , `customer`.`FirstName` AS Cfirstname\n"
                    + "    , `customer`.`LastName` AS CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
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
                    + "        WHERE `invoice`.`InvoiceDate` >= CURDATE()\n"
                    + "  AND `invoice`.`InvoiceDate` < CURDATE() + INTERVAL 1 DAY\n"
                    + "   ORDER BY `invoice`.`InvoiceID` DESC  ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BillingData> selectBillingDataByYesterday() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = " SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` AS Ufirstname \n"
                    + "    , `user`.`surname` AS Ulastname \n"
                    + "    , `customer`.`FirstName` AS Cfirstname\n"
                    + "    , `customer`.`LastName` AS CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
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
                    + "        WHERE `invoice`.`InvoiceDate`>= CURDATE() - INTERVAL 1 DAY\n"
                    + "  AND `invoice`.`InvoiceDate` < CURDATE() \n"
                    + "   ORDER BY `invoice`.`InvoiceID` DESC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BillingData> selectBillingDataByCurrentWeek() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` AS Ufirstname \n"
                    + "    , `user`.`surname` AS Ulastname \n"
                    + "    , `customer`.`FirstName` AS Cfirstname\n"
                    + "    , `customer`.`LastName` AS CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
                    + "FROM\n"
                    + "    `user`\n"
                    + "    INNER JOIN `billing`.`role` \n"
                    + "        ON (`user`.`role_id` = `role`.`id`)\n"
                    + "    INNER JOIN `payment` \n"
                    + "        ON (`payment`.`UserID` = `user`.`id`)\n"
                    + "    INNER JOIN `invoice` \n"
                    + "        ON (`payment`.`InvoiceID` = `invoice`.`InvoiceID`)\n"
                    + "    INNER JOIN `customer` \n"
                    + "        ON (`invoice`.`CustomerID` = `customer`.`CustomerID`)\n"
                    + "        WHERE `invoice`.`InvoiceDate` >= CURRENT_TIMESTAMP() - INTERVAL 7 DAY\n"
                    + "  AND `invoice`.`InvoiceDate` <= CURRENT_TIMESTAMP() \n"
                    + "   ORDER BY `invoice`.`InvoiceID` DESC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BillingData> selectBillingDataByCurrentMonth() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` AS Ufirstname \n"
                    + "    , `user`.`surname` AS Ulastname \n"
                    + "    , `customer`.`FirstName` AS Cfirstname\n"
                    + "    , `customer`.`LastName` AS CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
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
                    + "       WHERE `invoice`.`InvoiceDate` >= DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y-%m-01')\n"
                    + "  AND `invoice`.`InvoiceDate` < DATE_FORMAT(CURRENT_TIMESTAMP() + INTERVAL 1 MONTH, '%Y-%m-01')\n"
                    + "   ORDER BY `invoice`.`InvoiceID` DESC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    //user priviledges
    @Override
    public ArrayList<BillingData> selectBillingDataByTodayUser() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` AS Ufirstname \n"
                    + "    , `user`.`surname` AS Ulastname \n"
                    + "    , `customer`.`FirstName` AS Cfirstname\n"
                    + "    , `customer`.`LastName` AS CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
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
                    + "        WHERE `user`.`id` =" + new LoginUser().getUser().getId() + "   and `invoice`.`InvoiceDate` >= CURDATE()\n"
                    + "  AND `invoice`.`InvoiceDate` < CURDATE() + INTERVAL 1 DAY\n"
                    + "   ORDER BY `invoice`.`InvoiceID` DESC  ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BillingData> selectBillingDataByYesterdayUser() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = " SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` AS Ufirstname \n"
                    + "    , `user`.`surname` AS Ulastname \n"
                    + "    , `customer`.`FirstName` AS Cfirstname\n"
                    + "    , `customer`.`LastName` AS CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
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
                    + "        WHERE `user`.`id` =" + new LoginUser().getUser().getId() + "   and `invoice`.`InvoiceDate`>= CURDATE() - INTERVAL 1 DAY\n"
                    + "  AND `invoice`.`InvoiceDate` < CURDATE() \n"
                    + "   ORDER BY `invoice`.`InvoiceID` DESC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BillingData> selectBillingDataByCurrentWeekUser() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` AS Ufirstname \n"
                    + "    , `user`.`surname` AS Ulastname \n"
                    + "    , `customer`.`FirstName` AS Cfirstname\n"
                    + "    , `customer`.`LastName` AS CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
                    + "FROM\n"
                    + "    `user`\n"
                    + "    INNER JOIN `billing`.`role` \n"
                    + "        ON (`user`.`role_id` = `role`.`id`)\n"
                    + "    INNER JOIN `payment` \n"
                    + "        ON (`payment`.`UserID` = `user`.`id`)\n"
                    + "    INNER JOIN `invoice` \n"
                    + "        ON (`payment`.`InvoiceID` = `invoice`.`InvoiceID`)\n"
                    + "    INNER JOIN `customer` \n"
                    + "        ON (`invoice`.`CustomerID` = `customer`.`CustomerID`)\n"
                    + "        WHERE  `user`.`id` =" + new LoginUser().getUser().getId() + "   and  `invoice`.`InvoiceDate` >= CURRENT_TIMESTAMP() - INTERVAL 7 DAY\n"
                    + "  AND `invoice`.`InvoiceDate` <= CURRENT_TIMESTAMP() \n"
                    + "   ORDER BY `invoice`.`InvoiceID` DESC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BillingData> selectBillingDataByCurrentMonthUser() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` AS Ufirstname \n"
                    + "    , `user`.`surname` AS Ulastname \n"
                    + "    , `customer`.`FirstName` AS Cfirstname\n"
                    + "    , `customer`.`LastName` AS CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
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
                    + "       WHERE `user`.`id` =" + new LoginUser().getUser().getId() + "   and  `invoice`.`InvoiceDate` >= DATE_FORMAT(CURRENT_TIMESTAMP(), '%Y-%m-01')\n"
                    + "  AND `invoice`.`InvoiceDate` < DATE_FORMAT(CURRENT_TIMESTAMP() + INTERVAL 1 MONTH, '%Y-%m-01')\n"
                    + "   ORDER BY `invoice`.`InvoiceID` DESC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    @Override
    public ArrayList<BillingData> selectBillingDataUser() {
        ArrayList<BillingData> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`\n"
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b. %d, %Y %h:%i %p') AS formatted_date\n"
                    + "    , `user`.`firstname` as Ufirstname \n"
                    + "    , `user`.`surname` as Ulastname \n"
                    + "    , `customer`.`FirstName` as Cfirstname\n"
                    + "    , `customer`.`LastName` as CLastname\n"
                    + "    , `invoice`.`TotalAmount`\n"
                    + "    , `payment`.`PaymentMethod`\n"
                    + " FROM \n"
                    + "    `user`\n"
                    + "    INNER JOIN `role` \n"
                    + "        ON (`user`.`role_id` = `role`.`id`)\n"
                    + "    INNER JOIN `payment` \n"
                    + "        ON (`payment`.`UserID` = `user`.`id`)\n"
                    + "    INNER JOIN `invoice` \n"
                    + "        ON (`payment`.`InvoiceID` = `invoice`.`InvoiceID`)\n"
                    + "    INNER JOIN `customer` \n"
                    + "        ON (`invoice`.`CustomerID` = `customer`.`CustomerID`) where `user`.`id` =" + new LoginUser().getUser().getId() + "   and  ORDER BY `invoice`.`InvoiceID` DESC ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                BillingData bd = new BillingData();
                Invoice invoice = new Invoice();
                User user = new User();
                Customer customer = new Customer();
                Payment payment = new Payment();

                customer.setFirstName(rs.getString("Cfirstname"));
                customer.setLastName(rs.getString("Clastname"));
                user.setFirstname(rs.getString("Ufirstname"));
                user.setSurname(rs.getString("Ulastname"));
                invoice.setInvoiceId(rs.getLong("InvoiceID"));
                invoice.setTotalAmount(rs.getFloat("TotalAmount"));
                invoice.setCreatedAt(rs.getDate("InvoiceDate"));
                payment.setMethod(rs.getString("PaymentMethod"));
                bd.setFormattedDate(rs.getString("formatted_date"));
                bd.setCustomer(customer);
                bd.setUser(user);
                bd.setInvoice(invoice);
                bd.setPayment(payment);
                list.add(bd);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

}
