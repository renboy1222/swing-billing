/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.aldrin.billing;

import com.aldrin.billing.dao.impl.DBConnection;
import com.aldrin.billing.gui.JFrameApp;
import com.aldrin.billing.util.LookAndFeelManager;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

/**
 *
 * @author Java Programming with Aldrin
 */
public class Billing {

    public static void main(String[] args) {
//        JFrame.setDefaultLookAndFeelDecorated(true);
//        JDialog.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(() -> {
            boolean light;
            LookAndFeelManager lafManager = new LookAndFeelManager();
            if (lafManager.loadLookAndFeel().equals("FlatDarkLaf")) {
                FlatDarkLaf.setup();
                light = true;
            } else {
                FlatLightLaf.setup();
                light = false;
            }
            UIManager.put("ProgressBar.arc", 999);//JProgressBar
            UIManager.put("TextComponent.arc", 8);//JTextField,JPasswordField,JFormattedTextField
            UIManager.put("CheckBox", 999);//JCheckBox
            UIManager.put("Component.arc", 8);//JComboBox,JSpinner
            System.setProperty("flatlaf.menuBarEmbedded", "false");
            Font fontSize16 = UIManager.getFont("medium.font");
            Font newFont = fontSize16.deriveFont(12);
            UIManager.put("defaultFont", newFont);
            // Set custom grid color
            UIManager.put("Table.gridColor", new Color(0, 153, 153));

            DBConnection db = new DBConnection();
            db.getDBConn();
            
            JFrameApp app = new JFrameApp();
            app.switchButtonThemeMode.setDarkMode(light);

            SwingUtilities.updateComponentTreeUI(app);
            app.setVisible(true);
        });
    }

}
