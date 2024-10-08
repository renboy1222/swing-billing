/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.billing.gui;

import com.aldrin.billing.dao.impl.UserDAOImpl;
import com.aldrin.billing.model.User;
import com.aldrin.billing.util.LoginUser;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Font;
import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogChangePassword extends javax.swing.JDialog {

    /**
     * Creates new form JDialogChangePassword
     */
    private JFrameApp jFrameApp;
    private static boolean currentPassword = false;
    private static boolean reTypePassword = false;

    public JDialogChangePassword(JFrameApp jFrameApp, boolean modal) {
        super(jFrameApp, modal);
        initComponents();
        this.jFrameApp = jFrameApp;
        try {
            File fontStyle = new File("src/main/resources/fonts/TitanOne-Regular.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, fontStyle);
            jLabelTitle.setFont(font.deriveFont(24f));
//            jButtonLogin.setFont(font.deriveFont(16f));
        } catch (Exception e) {
            e.printStackTrace();
        }
        jButtonLogin.setIcon(new FlatSVGIcon("svg/save.svg", 20, 20));
        //placeHolder
        jPasswordFieldCurrentPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Current password");
        jPasswordFieldNewPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "New password");
        jPasswordFieldConfirmNewPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Confirm new password");
        //reveal button
        jPasswordFieldCurrentPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true;" + "showCapsLock:true");
        jPasswordFieldNewPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true;" + "showCapsLock:true");
        jPasswordFieldConfirmNewPassword.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true;" + "showCapsLock:true");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabelTitle = new javax.swing.JLabel();
        jLabelErrorMessage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonLogin = new javax.swing.JButton();
        jPasswordFieldConfirmNewPassword = new javax.swing.JPasswordField();
        jPasswordFieldCurrentPassword = new javax.swing.JPasswordField();
        jPasswordFieldNewPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Password");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("CURRENT PASSWORD");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 80, 320, -1));

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelTitle.setForeground(new java.awt.Color(0, 102, 153));
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("Change Password");
        jLabelTitle.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        getContentPane().add(jLabelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 0, 320, 40));

        jLabelErrorMessage.setForeground(new java.awt.Color(204, 0, 0));
        jLabelErrorMessage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabelErrorMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 50, 320, 20));

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("NEW PASSWORD");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 130, 320, -1));

        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("CONFIRM NEW PASSWORD");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 180, 320, -1));

        jButtonLogin.setForeground(new java.awt.Color(102, 102, 102));
        jButtonLogin.setText("Save");
        jButtonLogin.setPreferredSize(new java.awt.Dimension(71, 32));
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 240, 320, -1));

        jPasswordFieldConfirmNewPassword.setPreferredSize(new java.awt.Dimension(320, 28));
        jPasswordFieldConfirmNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldConfirmNewPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(jPasswordFieldConfirmNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 195, -1, 30));

        jPasswordFieldCurrentPassword.setPreferredSize(new java.awt.Dimension(320, 28));
        jPasswordFieldCurrentPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordFieldCurrentPasswordKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldCurrentPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(jPasswordFieldCurrentPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 95, -1, 30));

        jPasswordFieldNewPassword.setPreferredSize(new java.awt.Dimension(320, 28));
        jPasswordFieldNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jPasswordFieldNewPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(jPasswordFieldNewPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 145, -1, 30));

        setSize(new java.awt.Dimension(348, 350));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        changePassword();
    }//GEN-LAST:event_jButtonLoginActionPerformed

    private void jPasswordFieldCurrentPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldCurrentPasswordKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordFieldCurrentPasswordKeyPressed

    private void jPasswordFieldCurrentPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldCurrentPasswordKeyReleased
        User u = new User();
        u.setPassword(jPasswordFieldCurrentPassword.getText());
        System.out.println("user:" + u.getPassword());
        System.out.println("login:" + loginUser.getPassword());
        if (u.getPassword().equals(loginUser.getPassword())) {
            jPasswordFieldCurrentPassword.putClientProperty("JComponent.outline", null);
            setCurrentPassword(true);
            validateFields();
            jLabelErrorMessage.setText("");
        } else {
            setCurrentPassword(false);
            validateFields();
            jLabelErrorMessage.setText("Current password did not match.");
            jPasswordFieldCurrentPassword.putClientProperty("JComponent.outline", "error");
        }
    }//GEN-LAST:event_jPasswordFieldCurrentPasswordKeyReleased

    private void jPasswordFieldNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldNewPasswordKeyReleased
        if (!jPasswordFieldNewPassword.getText().toString().equals(jPasswordFieldCurrentPassword.getText().toString())) {
            jPasswordFieldNewPassword.putClientProperty("JComponent.outline", null);
            setReTypePassword(true);
            validateFields();
            jLabelErrorMessage.setText("");
        } else {
            setReTypePassword(false);
            validateFields();
            jPasswordFieldNewPassword.putClientProperty("JComponent.outline", "error");
            jLabelErrorMessage.setText("Current password is not allowed.");

        }
    }//GEN-LAST:event_jPasswordFieldNewPasswordKeyReleased

    private void jPasswordFieldConfirmNewPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordFieldConfirmNewPasswordKeyReleased
        if (jPasswordFieldNewPassword.getText().toString().equals(jPasswordFieldConfirmNewPassword.getText().toString())) {
            jPasswordFieldConfirmNewPassword.putClientProperty("JComponent.outline", null);
            setReTypePassword(true);
            validateFields();
            jLabelErrorMessage.setText("");
        } else {
            setReTypePassword(false);
            validateFields();
            jPasswordFieldConfirmNewPassword.putClientProperty("JComponent.outline", "error");
            jLabelErrorMessage.setText("Error input please try again.");

        }
    }//GEN-LAST:event_jPasswordFieldConfirmNewPasswordKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelErrorMessage;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPasswordField jPasswordFieldConfirmNewPassword;
    private javax.swing.JPasswordField jPasswordFieldCurrentPassword;
    private javax.swing.JPasswordField jPasswordFieldNewPassword;
    // End of variables declaration//GEN-END:variables
private LoginUser loginUser = new LoginUser();

    private void changePassword() {
        UserDAOImpl userDAOImpl = new UserDAOImpl();
        User user = new User();
        user.setId(loginUser.getUser().getId());
        user.setPassword(jPasswordFieldConfirmNewPassword.getText());
        int response = JOptionPane.showConfirmDialog(this, "Are you sure to change your password?", "Change password confirmation", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION) {
            if (userDAOImpl.changePassword(user) == true) {
                JOptionPane.showMessageDialog(jFrameApp, "Password is successfully change.", "Message", JOptionPane.PLAIN_MESSAGE);
                this.dispose();
            }
        }
    }

    /**
     * @return the currentPassword
     */
    public static boolean isCurrentPassword() {
        return currentPassword;
    }

    /**
     * @param aCurrentPassword the currentPassword to set
     */
    public static void setCurrentPassword(boolean aCurrentPassword) {
        currentPassword = aCurrentPassword;
    }

    private void validateFields() {
        if (isCurrentPassword() == true && isReTypePassword() == true) {
            jButtonLogin.setEnabled(true);
        } else {
            jButtonLogin.setEnabled(false);
        }
    }

    /**
     * @return the reTypePassword
     */
    public static boolean isReTypePassword() {
        return reTypePassword;
    }

    /**
     * @param aReTypePassword the reTypePassword to set
     */
    public static void setReTypePassword(boolean aReTypePassword) {
        reTypePassword = aReTypePassword;
    }

}
