/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.billing.gui.dialog.au;

import com.aldrin.billing.dao.impl.CustomerDAOImpl;
import com.aldrin.billing.gui.JFrameApp;
import com.aldrin.billing.model.Customer;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogCustomerAU extends javax.swing.JDialog {

    private CustomerDAOImpl customerDAOImpl = new CustomerDAOImpl();
    private JFrameApp jFrameCafSys;

    /**
     * Creates new form JDialogStudent
     */
    private Customer customer = new Customer();
    static String title = "";

    public JDialogCustomerAU(JFrameApp jFrameSariPOS, boolean modal) {
        super(jFrameSariPOS, modal);
        initComponents();
        this.jFrameCafSys =jFrameSariPOS;
        setTitle("Add customer");
        this.title = "New";
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
        jTextFieldEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "EMAIL");
        jTextFieldPhoneNumber.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PHONE NUMBER");
        jTextFieldAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ADDRESS");
        jTextFieldCity.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "CITY/TOWN");
        jTextFieldStateProvince.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "STATE/PROVINCE");
        jTextFieldZipcode.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ZIPCODE");
        jButton1.setIcon(new FlatSVGIcon("svg/save.svg",24,24));
//        setUndecorated(true);
//        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));
                

        

    }

    public JDialogCustomerAU(JFrameApp jFrameCafSys, boolean modal, Customer customer, String title) {
        super(jFrameCafSys, modal);
        initComponents();
        setTitle("Update customer");
        this.customer = customer;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
        jTextFieldEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "EMAIL");
        jTextFieldPhoneNumber.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PHONE NUMBER");
        jTextFieldAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ADDRESS");
        jTextFieldCity.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "CITY/TOWN");
        jTextFieldStateProvince.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "STATE/PROVINCE");
        jTextFieldZipcode.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ZIPCODE");
        jTextFieldFirstname.setText(customer.getFirstName());
        jTextFieldSurname.setText(customer.getLastName());
        jTextFieldPhoneNumber.setText(customer.getPhoneNumber());
        jTextFieldEmail.setText(customer.getEmail());
        jTextFieldAddress.setText(customer.getAddesss());
        jTextFieldCity.setText(customer.getCity());
        jTextFieldStateProvince.setText(customer.getState());
        jTextFieldZipcode.setText(String.valueOf(customer.getZipCode()));
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg",24,24));
//        setUndecorated(true);

    }

    public JDialogCustomerAU(JFrameApp jFrameCafSys, boolean modal, String title, Customer customer) {
        super(jFrameCafSys, modal);
        initComponents();
        setTitle("Delete user account");
        this.customer = customer;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
        jTextFieldEmail.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "EMAIL");
        jTextFieldPhoneNumber.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PHONE NUMBER");
        jTextFieldAddress.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ADDRESS");
        jTextFieldCity.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "CITY/TOWN");
        jTextFieldStateProvince.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "STATE/PROVINCE");
        jTextFieldZipcode.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "ZIPCODE");
        jTextFieldFirstname.setText(customer.getFirstName());
        jTextFieldSurname.setText(customer.getLastName());
        jTextFieldPhoneNumber.setText(customer.getPhoneNumber());
        jTextFieldEmail.setText(customer.getEmail());
        jTextFieldAddress.setText(customer.getAddesss());
        jTextFieldCity.setText(customer.getCity());
        jTextFieldStateProvince.setText(customer.getState());
        jTextFieldZipcode.setText(String.valueOf(customer.getZipCode()));
        
        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg",24,24));
//        setUndecorated(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel5 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldFirstname = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldSurname = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldZipcode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jTextFieldEmail = new javax.swing.JTextField();
        jTextFieldPhoneNumber = new javax.swing.JTextField();
        jTextFieldAddress = new javax.swing.JTextField();
        jTextFieldCity = new javax.swing.JTextField();
        jTextFieldStateProvince = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Student");

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("FIRST NAME");
        jLabel1.setPreferredSize(new java.awt.Dimension(65, 25));
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 220, 20));

        jTextFieldFirstname.setPreferredSize(new java.awt.Dimension(64, 30));
        jPanel4.add(jTextFieldFirstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 28, 220, 25));

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("SURNAME");
        jLabel9.setPreferredSize(new java.awt.Dimension(55, 25));
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 220, 20));

        jTextFieldSurname.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel4.add(jTextFieldSurname, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 78, 220, -1));

        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("PHONE NUMBER");
        jLabel10.setPreferredSize(new java.awt.Dimension(28, 25));
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 220, 20));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("EMAIL");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 220, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("ZIPCODE");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 80, 20));

        jTextFieldZipcode.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldZipcode.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel4.add(jTextFieldZipcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 80, -1));

        jButton1.setText("Save");
        jButton1.setMargin(new java.awt.Insets(2, 0, 3, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 100, 32));

        jTextFieldEmail.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldEmail.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel4.add(jTextFieldEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 220, -1));

        jTextFieldPhoneNumber.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel4.add(jTextFieldPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 128, 220, -1));

        jTextFieldAddress.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldAddress.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel4.add(jTextFieldAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 370, -1));

        jTextFieldCity.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldCity.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel4.add(jTextFieldCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 130, -1));

        jTextFieldStateProvince.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldStateProvince.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel4.add(jTextFieldStateProvince, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 140, -1));

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("ADDRESS");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 220, 20));

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("CITY");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 20));

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("STATE/PROVINCE");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 140, 20));

        jPanel5.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(406, 444));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("New")) {
            int response = JOptionPane.showConfirmDialog(jFrameCafSys, "Are you sure to save " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.customer.setFirstName(jTextFieldFirstname.getText());
                this.customer.setLastName(jTextFieldSurname.getText());
                this.customer.setEmail(jTextFieldEmail.getText());
                this.customer.setPhoneNumber(jTextFieldPhoneNumber.getText());
                this.customer.setAddesss(jTextFieldAddress.getText());
                this.customer.setCity(jTextFieldCity.getText());
                this.customer.setState(jTextFieldStateProvince.getText());
                this.customer.setZipCode(Integer.parseInt(jTextFieldZipcode.getText()));
                customerDAOImpl.addCustomer(customer);
                this.dispose();
            }
        } else if (this.title.equals("Update")) {
            int response = JOptionPane.showConfirmDialog(jFrameCafSys, "Are you sure to update " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.customer.setFirstName(jTextFieldFirstname.getText());
                this.customer.setLastName(jTextFieldSurname.getText());
                this.customer.setEmail(jTextFieldEmail.getText());
                this.customer.setPhoneNumber(jTextFieldPhoneNumber.getText());
                this.customer.setAddesss(jTextFieldAddress.getText());
                this.customer.setCity(jTextFieldCity.getText());
                this.customer.setState(jTextFieldStateProvince.getText());
                this.customer.setZipCode(Integer.parseInt(jTextFieldZipcode.getText()));
                customerDAOImpl.updateCustomer(customer);
                this.dispose();
            }
        } else if (this.title.equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(jFrameCafSys, "Are you sure to delete " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                customerDAOImpl.deleteCustomer(customer);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextFieldAddress;
    private javax.swing.JTextField jTextFieldCity;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldFirstname;
    private javax.swing.JTextField jTextFieldPhoneNumber;
    private javax.swing.JTextField jTextFieldStateProvince;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldZipcode;
    // End of variables declaration//GEN-END:variables

  

 
    
    

}
