/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aldrin.billing.dao.impl;

import com.aldrin.billing.gui.dialog.JDialogDBSetup;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Java Programming with Aldrin
 */
public class DBConnection {

    private static Connection con;

    public void getDBConn() {

        synchronized ("") {
            try {
                loadConnection();
                if (this.getCon() == null || this.getCon().isClosed()) {
                    JDialogDBSetup dbSetup = new JDialogDBSetup(null, true);
                    dbSetup.setVisible(true);
                    return;
                } else {
                }
            } catch (SQLException ex) {

                ex.printStackTrace();
            }
        }
    }

    /**
     * @return the con
     */
    public static Connection getCon() {
        return con;
    }

    /**
     * @param aCon the con to set
     */
    public static void setCon(Connection aCon) {
        con = aCon;
    }

    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    private static Connection connection = null;
    private static Properties dbProperties = new Properties();
    private static final String CONFIG_FILE = "dbconfig.properties";

    private static void loadConnection() {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config\\" + CONFIG_FILE)) {
            dbProperties.load(fis);
            String host = dbProperties.getProperty("db.host");
            String port = dbProperties.getProperty("db.port");
            String dbName = dbProperties.getProperty("db.name");
            String user = dbProperties.getProperty("db.user");
            String password = dbProperties.getProperty("db.password");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
//            connection = DriverManager.getConnection(url, user, password);
            setCon(DriverManager.getConnection(url, user, password));

        } catch (IOException | SQLException e) {
            con = null;
        }
    }

    // Save database properties to the configuration file
    public static void saveProperties(String host, String port, String dbName, String user, String password) {
        dbProperties.setProperty("db.host", host);
        dbProperties.setProperty("db.port", port);
        dbProperties.setProperty("db.name", dbName);
        dbProperties.setProperty("db.user", user);
        dbProperties.setProperty("db.password", password);

        try (FileOutputStream fos = new FileOutputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\config\\" + CONFIG_FILE)) {
            dbProperties.store(fos, "Database Configuration");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving configuration: " + e.getMessage());
        }
    }

    // Test the connection with the provided parameters
    public static boolean testConnection(String host, String port, String dbName, String user, String password) {
        try {
            String url = "jdbc:mysql://" + host + ":" + port + "/" + dbName;
            Connection testConnection = DriverManager.getConnection(url, user, password);
            testConnection.close();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
