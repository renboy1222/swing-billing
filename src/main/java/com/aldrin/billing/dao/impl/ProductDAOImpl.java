/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.dao.impl;

import com.aldrin.billing.dao.ProductDAO;
import com.aldrin.billing.model.Product;
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


/**
 *
 * @author ALDRIN B. C.
 */

public class ProductDAOImpl extends DBConnection implements ProductDAO {

    private ArrayList<ComboBoxList> list;

    @Override
    public void addProduct(Product product) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("INSERT INTO `product` (\n"
                    + "  `ProductName`,\n"
                    + "  `Description`,\n"
                    + "  `Price`) VALUES(?,?,?) ;");
            ps.setString(1, product.getProduct());
            ps.setString(2, product.getDescription());
            ps.setFloat(3, product.getPrice());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE \n"
                    + "  `product` \n"
                    + "SET\n"
                    + "  `ProductName` = ?,\n"
                    + "  `Description` = ?,\n"
                    + "  `Price` = ?\n"
                    + "WHERE `ProductID` = ? ;");
            ps.setString(1, product.getProduct());
            ps.setString(2, product.getDescription());
            ps.setFloat(3, product.getPrice());
            ps.setLong(4, product.getProductId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteProduct(Product product) {
        try {
            getDBConn();
            java.sql.PreparedStatement ps = getCon().prepareStatement("UPDATE CUSTOMER SET ACTIVE =? WHERE CUSTOMER.ID = ? ");
            ps.setBoolean(1, true);
//            ps.setLong(2, product.getId());
            ps.execute();
            ps.close();
            closeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Product> selectProduct() {
        ArrayList<Product> list = new ArrayList<>();
        try {
            String query = "SELECT \n"
                    + "  `ProductID`,\n"
                    + "  `ProductName`,\n"
                    + "  `Description`,\n"
                    + "  `Price` \n"
                    + "FROM\n"
                    + "  `product` WHERE `deletedAt` IS NULL ORDER BY `ProductName` ASC ;";
            getDBConn();
            Statement st = getCon().createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Product c = new Product();
                c.setProductId(rs.getLong("ProductID"));
                c.setProduct(rs.getString("ProductName"));
                c.setDescription(rs.getString("Description"));
                c.setPrice(rs.getFloat("Price"));
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
    public void comboBoxProduct() {
        this.setList(new ArrayList<ComboBoxList>());
        try {
            getDBConn();
            PreparedStatement statement;
            ResultSet rs;
            statement = getCon().prepareStatement("SELECT \n"
                    + "  `ProductID`,\n"
                    + "  `ProductName`,\n"
                    + "  `Description`,\n"
                    + "  `Price`\n"
                    + " FROM \n"
                    + "  `product` WHERE `product`.`deletedAt` IS NULL ORDER BY `ProductName` ASC");
            rs = statement.executeQuery();
            while (rs.next()) {
                Long idl = rs.getLong("ProductID");
                String productNamel = rs.getString("ProductName");
                String price1 = rs.getString("Price");
                this.getList().add(new ComboBoxList(idl, productNamel + "[" + price1 + "]"));
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
    public Product findProductById(Product product) {
        Product pr = null;
        try {
            getDBConn();
            PreparedStatement statement = getCon().prepareStatement("SELECT \n"
                    + "  `ProductID`,\n"
                    + "  `ProductName`,\n"
                    + "  `Description`,\n"
                    + "  `Price`  \n"
                    + "FROM\n"
                    + "  `product` WHERE `ProductID` =" + product.getProductId() + " ");
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                pr = new Product();
                Product p = new Product();
                p.setProductId(rs.getLong("ProductID"));
                p.setProduct(rs.getString("ProductName"));
                p.setDescription(rs.getString("Description"));
                p.setPrice(rs.getFloat("Price"));
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
