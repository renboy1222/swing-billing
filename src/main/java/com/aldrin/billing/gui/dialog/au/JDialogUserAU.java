/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.billing.gui.dialog.au;

import com.aldrin.billing.Billing;
import com.aldrin.billing.dao.impl.RoleDAOImpl;
import com.aldrin.billing.dao.impl.UserDAOImpl;
import com.aldrin.billing.gui.JFrameApp;
import com.aldrin.billing.model.Role;
import com.aldrin.billing.model.User;
import com.aldrin.billing.util.ComboBoxList;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogUserAU extends javax.swing.JDialog {

    private RoleDAOImpl roleDAOImpl = new RoleDAOImpl();
    private UserDAOImpl studentDAOImpl = new UserDAOImpl();
    private JFrameApp jFrameCafSys;

    /**
     * Creates new form JDialogStudent
     */
    private User user = new User();
    static String title = "";

    public JDialogUserAU(JFrameApp jFrameSariPOS, boolean modal) {
        super(jFrameSariPOS, modal);
        initComponents();
        this.jFrameCafSys = jFrameSariPOS;
        setTitle("New user account");
        this.title = "New";
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "USERNAME");
        jPasswordFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PASSWORD");
        comboBoxUserAccount();
        jCheckBoxActive.setSelected(true);
        jButton1.setIcon(new FlatSVGIcon("svg/save.svg", 24, 24));
//        setUndecorated(true);
//        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 15, 15));

    }

    public JDialogUserAU(JFrameApp jFrameCafSys, boolean modal, User userAccount, String title) {
        super(jFrameCafSys, modal);
        initComponents();
        setTitle("Update user account");
        this.user = userAccount;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First name");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Surname");
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Username");
        jPasswordFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Password");
        comboBoxUserAccount();
        jTextFieldFirstname.setText(userAccount.getFirstname());
        jTextFieldSurname.setText(userAccount.getSurname());
        jTextFieldUsername.setText(userAccount.getUsername());
        jPasswordFieldPassword.setText(userAccount.getPassword());
        if (userAccount.getInActiveAt() == null) {
            jCheckBoxActive.setSelected(true);
        } else {
            jCheckBoxActive.setSelected(false);
        }

        for (ComboBoxList a : this.roleDAOImpl.getList()) {
            a.setSelectedId(roleDAOImpl.getList(), String.valueOf(userAccount.getRole().getId()), jComboBoxRole);
        }
        displayPicture(userAccount);
        jButton1.setIcon(new FlatSVGIcon("svg/edit.svg", 24, 24));
//        setUndecorated(true);

    }

    public JDialogUserAU(JFrameApp jFrameCafSys, boolean modal, String title, User userAccount) {
        super(jFrameCafSys, modal);
        initComponents();
        setTitle("Delete user account");
        this.user = userAccount;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        jTextFieldFirstname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "FIRST NAME");
        jTextFieldSurname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "SURNAME");
        jTextFieldUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "USERNAME");
        jPasswordFieldPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "PASSWORD");
        comboBoxUserAccount();
        jTextFieldFirstname.setText(userAccount.getFirstname());
        jTextFieldSurname.setText(userAccount.getSurname());
        jTextFieldUsername.setText(userAccount.getUsername());
        jPasswordFieldPassword.setText(userAccount.getPassword());
        if (userAccount.getInActiveAt() == null) {
            jCheckBoxActive.setSelected(true);
        } else {
            jCheckBoxActive.setSelected(false);
        }
        for (ComboBoxList a : this.roleDAOImpl.getList()) {
            a.setSelectedId(roleDAOImpl.getList(), String.valueOf(userAccount.getRole().getId()), jComboBoxRole);
        }
        displayPicture(userAccount);
        jButton1.setIcon(new FlatSVGIcon("svg/delete.svg", 24, 24));
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
        jComboBoxRole = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jCheckBoxActive = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabelPicture = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jTextFieldUsername = new javax.swing.JTextField();
        jPasswordFieldPassword = new javax.swing.JPasswordField();

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
        jLabel10.setText("ROLE");
        jLabel10.setPreferredSize(new java.awt.Dimension(28, 25));
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 220, 20));

        jComboBoxRole.setPreferredSize(new java.awt.Dimension(72, 32));
        jPanel4.add(jComboBoxRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 128, 220, 25));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("USERNAME");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 220, 20));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("PASSWORD");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 220, 20));

        jCheckBoxActive.setText("ACTIVE");
        jPanel4.add(jCheckBoxActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 220, 30));

        jButton1.setText("Save");
        jButton1.setMargin(new java.awt.Insets(2, 0, 3, 0));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 100, 32));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true), "PHOTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(0, 102, 153))); // NOI18N
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 102, 102), 1, true));
        jPanel2.setLayout(new java.awt.BorderLayout(5, 5));

        jLabelPicture.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelPictureMouseClicked(evt);
            }
        });
        jPanel2.add(jLabelPicture, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(210, 0));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 190, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        jPanel4.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 200, 200));

        jTextFieldUsername.setMinimumSize(new java.awt.Dimension(64, 32));
        jTextFieldUsername.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel4.add(jTextFieldUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 220, -1));

        jPasswordFieldPassword.setPreferredSize(new java.awt.Dimension(64, 25));
        jPanel4.add(jPasswordFieldPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 220, -1));

        jPanel5.add(jPanel4, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(478, 402));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.title.equals("New")) {
            int response = JOptionPane.showConfirmDialog(jFrameCafSys, "Are you sure to save " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.user.setFirstname(jTextFieldFirstname.getText());
                this.user.setSurname(jTextFieldSurname.getText());
                this.user.setUsername(jTextFieldUsername.getText());
                this.user.setPassword(jPasswordFieldPassword.getText());
                if (jCheckBoxActive.isSelected() == true) {
                    user.setInActiveAt(null);
                } else {
                    user.setInActiveAt(new Timestamp(new Date().getTime()));
                }
                ComboBoxList roleId = (ComboBoxList) this.jComboBoxRole.getSelectedItem();
                Role role = new Role();
                role.setId(roleId.getId());
                this.user.setRole(role);
                try {
                    validatePhoto();
                } catch (URISyntaxException ex) {
                    Logger.getLogger(JDialogUserAU.class.getName()).log(Level.SEVERE, null, ex);
                }
                studentDAOImpl.addUser(user);
                
                this.dispose();
            }
        } else if (this.title.equals("Update")) {
            int response = JOptionPane.showConfirmDialog(jFrameCafSys, "Are you sure to update " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                this.user.setFirstname(jTextFieldFirstname.getText());
                this.user.setSurname(jTextFieldSurname.getText());
                this.user.setUsername(jTextFieldUsername.getText());
                this.user.setUpdatePassword(jPasswordFieldPassword.getText());
                if (jCheckBoxActive.isSelected() == true) {
                    user.setInActiveAt(null);
                } else {
                    user.setInActiveAt(new Timestamp(new Date().getTime()));
                }
                ComboBoxList roleId = (ComboBoxList) this.jComboBoxRole.getSelectedItem();
                Role role = new Role();
                role.setId(roleId.getId());
                this.user.setRole(role);
                try {
                    validatePhoto();
                } catch (URISyntaxException ex) {
                    Logger.getLogger(JDialogUserAU.class.getName()).log(Level.SEVERE, null, ex);
                }
                studentDAOImpl.updateUser(user);
                this.dispose();
            }
        } else if (this.title.equals("Delete")) {
            int response = JOptionPane.showConfirmDialog(jFrameCafSys, "Are you sure to delete " + jTextFieldFirstname.getText() + " " + jTextFieldSurname.getText() + " ?", "Save confirmation", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                studentDAOImpl.deleteUser(user);
                this.dispose();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabelPictureMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelPictureMouseClicked

        browse();
    }//GEN-LAST:event_jLabelPictureMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBoxActive;
    private javax.swing.JComboBox<Object> jComboBoxRole;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelPicture;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JTextField jTextFieldFirstname;
    private javax.swing.JTextField jTextFieldSurname;
    private javax.swing.JTextField jTextFieldUsername;
    // End of variables declaration//GEN-END:variables

    private void comboBoxUserAccount() {
        roleDAOImpl.comboBoxRole();
        jComboBoxRole.removeAllItems();
        for (ComboBoxList a : roleDAOImpl.getList()) {
            this.jComboBoxRole.addItem(a);
        }
    }

    private File pictureFile = null;

    private void browse() {
        try {
            int returnVal = jFileChooser1.showOpenDialog(this);
            if (returnVal == javax.swing.JFileChooser.APPROVE_OPTION) {
                pictureFile = jFileChooser1.getSelectedFile();
                uploadPhoto(pictureFile);
                int IMG_WIDTH = jLabelPicture.getWidth();
                int IMG_HEIGHT = jLabelPicture.getHeight();

                try {
                    BufferedImage originalImage = ImageIO.read(pictureFile);
                    int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();

                    BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
                    Graphics2D g = resizedImage.createGraphics();
                    g.drawImage(originalImage, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
                    g.dispose();
                    g.setComposite(AlphaComposite.Src);

                    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
                    g.setRenderingHint(RenderingHints.KEY_RENDERING,
                            RenderingHints.VALUE_RENDER_QUALITY);
                    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

                    jLabelPicture.setIcon(new ImageIcon(resizedImage)); //to eliminate .jpeg from picture filename
                    ImageIO.write(resizedImage, "png", new File(Billing.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "\\images\\model.jpg"));

                } catch (final IOException ex) {

                }

            } else {
                File defaultDirectory = new File(System.getProperty("user.home"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void uploadPhoto(File file) {
        if (file != null) {
            try (FileInputStream fis = new FileInputStream(file)) {
                byte[] imageData = new byte[(int) file.length()];
                fis.read(imageData);
                user.setPhoto(imageData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    int IMG_WIDTH = 200;
    int IMG_HEIGHT = 200;

    private void displayPicture(User userAccount) {
        try {
            byte[] imageData = userAccount.getPhoto();
            ImageIcon imageIcon = new ImageIcon(imageData);

            Image image = imageIcon.getImage();
            int type = BufferedImage.TYPE_INT_ARGB;

            BufferedImage resizedImage = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, type);
            Graphics2D g = resizedImage.createGraphics();
            g.drawImage(image, 0, 0, IMG_WIDTH, IMG_HEIGHT, null);
            g.dispose();
            g.setComposite(AlphaComposite.Src);

            g.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
                    RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            g.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            jLabelPicture.setIcon(new ImageIcon(resizedImage));//image to label

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void validatePhoto() throws URISyntaxException {
        if (user.getPhoto() == null) {
            File targetClassesDir = new File(Billing.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "\\images\\photo.jpg");
            try {
                FileInputStream fis = new FileInputStream(targetClassesDir);
                byte[] imageData = new byte[(int) targetClassesDir.length()];
                fis.read(imageData);
                user.setPhoto(imageData);
            } catch (Exception e) {
                System.out.println("default of no photo is error");
            }
        }
    }

}
