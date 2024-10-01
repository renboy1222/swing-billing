/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao.impl;

import com.aldrin.billing.dao.CustomerDAO;
import static com.aldrin.billing.dao.impl.DBConnection.closeConnection;
import static com.aldrin.billing.dao.impl.DBConnection.getCon;
import com.aldrin.billing.model.Customer;
import com.aldrin.billing.util.ComboBoxList;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author ALDRIN B. C.
 */
@Setter
@Getter
public class CustomerDAOImpl extends DBConnection implements CustomerDAO {

    private ArrayList<ComboBoxList> list;

    @Override
    public void addCustomer(Customer customer) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO `customer` (\n"
                    + "  `FirstName`,\n"
                    + "  `LastName`,\n"
                    + "  `Email`,\n"
                    + "  `PhoneNumber`,\n"
                    + "  `Address`,\n"
                    + "  `City`,\n"
                    + "  `State`,\n"
                    + "  `ZipCode`) VALUES(?,?,?,?,?,?,?,?) ;");
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhoneNumber());
            ps.setString(5, customer.getAddesss());
            ps.setString(6, customer.getCity());
            ps.setString(7, customer.getState());
            ps.setInt(8, customer.getZipCode());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE \n"
                    + "  `customer` \n"
                    + "SET \n"
                    + "  `FirstName` = ?,\n"
                    + "  `LastName` = ?,\n"
                    + "  `Email` = ?,\n"
                    + "  `PhoneNumber` = ?,\n"
                    + "  `Address` = ?,\n"
                    + "  `City` = ?,\n"
                    + "  `State` = ?,\n"
                    + "  `ZipCode` = ?  \n"
                    + "WHERE `CustomerID` = ? ;");
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhoneNumber());
            ps.setString(5, customer.getAddesss());
            ps.setString(6, customer.getCity());
            ps.setString(7, customer.getState());
            ps.setInt(8, customer.getZipCode());
            ps.setLong(9, customer.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCustomer(Customer customer) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE CUSTOMER SET ACTIVE =? WHERE CUSTOMER.ID = ? ");
            ps.setBoolean(1, true);
            ps.setLong(2, customer.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Customer> selectCustomer() {
        ArrayList<Customer> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `CustomerID`,\n"
                    + "  `FirstName`,\n"
                    + "  `LastName`,\n"
                    + "  `Email`,\n"
                    + "  `PhoneNumber`,\n"
                    + "  `Address`,\n"
                    + "  `City`,\n"
                    + "  `State`,\n"
                    + "  `ZipCode`,\n"
                    + "  `DeletedAt` \n"
                    + "FROM\n"
                    + "  `customer` WHERE `DeletedAt` IS NULL ORDER BY `LastName` ASC  ";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Customer c = new Customer();
                c.setId(rs.getLong("CustomerID"));
                c.setFirstName(rs.getString("FirstName"));
                c.setLastName(rs.getString("LastName"));
                c.setEmail(rs.getString("Email"));
                c.setPhoneNumber(rs.getString("PhoneNumber"));
                c.setAddesss(rs.getString("Address"));
                c.setCity(rs.getString("City"));
                c.setState(rs.getString("State"));
                c.setZipCode(rs.getInt("Zipcode"));
                c.setDeletedAt(rs.getTimestamp("DeletedAt"));
                list.add(c);
            }
            rs.close();
            st.close();
            closeConnection();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    private static byte[] convertBlobToBytes(java.sql.Blob blob) throws IOException, SQLException {
        try (InputStream inputStream = blob.getBinaryStream()) {
            return convertInputStreamToBytes(inputStream);
        }
    }

    private static byte[] convertInputStreamToBytes(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }
        return outputStream.toByteArray();
    }

    private static void writeBytesToFile(byte[] bytes, String filePath) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(bytes);
        }
    }

    @Override
    public void comboBoxCustomer() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT \n"
                    + "  `CustomerID`,\n"
                    + "  `FirstName`,\n"
                    + "  `LastName`\n"
                    + "FROM `customer` WHERE `deletedAt`IS NULL ORDER BY `LastName` ASC;");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("CustomerID");
                String firstnamel = rs.getString("FirstName");
                String lastnamel = rs.getString("LastName");
                this.getList().add(new ComboBoxList(idl, lastnamel + ", " + firstnamel));
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

    @Override
    public Customer findCustomerById(Customer customer) {
        Customer pr = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT \n"
                    + "  `CustomerID`,\n"
                    + "  `FirstName`,\n"
                    + "  `LastName`\n"
                    + "FROM `customer` WHERE `deletedAt`IS NULL and  CustomerID =" + customer.getId() + " ORDER BY `LastName` ASC; ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                pr = new Customer();
                Customer p = new Customer();
                p.setId(rs.getLong("CustomerID"));
                p.setFirstName(rs.getString("FirstName"));
                p.setLastName(rs.getString("LastName"));
                pr = p;
            }
            rs.close();
            statement.close();
//            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pr;
    }

}
