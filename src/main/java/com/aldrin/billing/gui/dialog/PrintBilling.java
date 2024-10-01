/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.gui.dialog;

import com.aldrin.billing.dao.impl.DBConnection;
import static com.aldrin.billing.dao.impl.DBConnection.closeConnection;
import static com.aldrin.billing.dao.impl.DBConnection.getCon;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Java Programming with Aldrin
 */
public class PrintBilling extends DBConnection {

    private String invoiceId;
    private String invoiceDate;
    private String userFirstname;
    private String userSurname;
    private String customerFirstname;
    private String customerLastname;
    private Float totalAmount;
    private String paymentMethod;
    private Integer quantity;
    private Float unitPrice;
    private String productName;
    private String productDescription;
    
    public PrintBilling(){
        
    }

    public PrintBilling(String invoiceId, String invoiceDate, String userFirstname, String userSurname,
            String customerFirstname, String customerLastname, Float totalAmount, String paymentMethod, Integer quantity,
            Float unitPrice, String productName, String productDescription) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.userFirstname = userFirstname;
        this.userSurname = userSurname;
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        this.totalAmount = totalAmount;
        this.paymentMethod = paymentMethod;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.productName = productName;
        this.productDescription = productDescription;

    }

    /**
     * @return the invoiceId
     */
    public String getInvoiceId() {
        return invoiceId;
    }

    /**
     * @param invoiceId the invoiceId to set
     */
    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    /**
     * @return the invoiceDate
     */
    public String getInvoiceDate() {
        return invoiceDate;
    }

    /**
     * @param invoiceDate the invoiceDate to set
     */
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    /**
     * @return the userFirstname
     */
    public String getUserFirstname() {
        return userFirstname;
    }

    /**
     * @param userFirstname the userFirstname to set
     */
    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    /**
     * @return the userSurname
     */
    public String getUserSurname() {
        return userSurname;
    }

    /**
     * @param userSurname the userSurname to set
     */
    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    /**
     * @return the customerFirstname
     */
    public String getCustomerFirstname() {
        return customerFirstname;
    }

    /**
     * @param customerFirstname the customerFirstname to set
     */
    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }

    /**
     * @return the customerLastname
     */
    public String getCustomerLastname() {
        return customerLastname;
    }

    /**
     * @param customerLastname the customerLastname to set
     */
    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }

    /**
     * @return the totalAmount
     */
    public Float getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(Float totalAmount) {
        this.totalAmount = totalAmount;
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

    /**
     * @return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
        return productDescription;
    }

    /**
     * @param productDescription the productDescription to set
     */
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public ArrayList<PrintBilling> printBillingReceipt(Long invoiceID) {
        ArrayList<PrintBilling> list = new ArrayList<>();
        try {
            String query = "SELECT\n"
                    + "   `invoice`.`InvoiceID`\n"
                    + "    ,`invoice`.`InvoiceDate`,`invoice`.`TotalAmount`, `invoice`.`InvoiceDate` "
                    + "    ,DATE_FORMAT(`invoice`.`InvoiceDate`, '%b.%d,%Y %h:%i %p') AS formatted_date \n"
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

                String invoiceId = rs.getString("InvoiceID");
                String invoiceDate = rs.getString("InvoiceDate");
                String userFirstname = rs.getString("Ulastname");
                String userSurname = rs.getString("Ulastname");
                String customerFirstname = rs.getString("Clastname");
                String customerLastname = rs.getString("Ufirstname");
                Float totalAmount = rs.getFloat("TotalAmount");
                String paymentMethod = rs.getString("PaymentMethod");
                Integer quantity = rs.getInt("Quantity");
                Float unitPrice = rs.getFloat("UnitPrice");
                String productName = rs.getString("ProductName");
                String productDescription = rs.getString("Description");

                PrintBilling bd = new PrintBilling(invoiceId, invoiceDate, userFirstname, userSurname, customerFirstname, customerLastname, totalAmount, paymentMethod, quantity, unitPrice, productName, productDescription);
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
//    
//    public static void main(String[] args) {
//        PrintBilling pb = new PrintBilling();
//        for(PrintBilling p:pb.printBillingReceipt(15L)){
//            System.out.println("product:"+p.getProductName());
//            System.out.println("quantity:"+p.getQuantity());
//            System.out.println("unit price:"+p.getUnitPrice());
//            System.out.println("line total:"+(p.getQuantity()*p.getUnitPrice()));
//        }
//    }
}
