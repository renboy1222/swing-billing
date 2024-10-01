/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.util;

/**
 *
 * @author Java Programming with Aldrin
 */
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.io.*;
import java.util.Properties;
import org.pushingpixels.radiance.theming.api.RadianceThemingCortex;
import org.pushingpixels.radiance.theming.api.skin.AutumnSkin;
import org.pushingpixels.radiance.theming.api.skin.BusinessBlackSteelSkin;
import org.pushingpixels.radiance.theming.api.skin.BusinessBlueSteelSkin;
import org.pushingpixels.radiance.theming.api.skin.BusinessSkin;
import org.pushingpixels.radiance.theming.api.skin.CeruleanSkin;
import org.pushingpixels.radiance.theming.api.skin.CremeSkin;
import org.pushingpixels.radiance.theming.api.skin.GeminiSkin;
import org.pushingpixels.radiance.theming.api.skin.GraphiteAquaSkin;
import org.pushingpixels.radiance.theming.api.skin.GraphiteSkin;
import org.pushingpixels.radiance.theming.api.skin.MagellanSkin;
import org.pushingpixels.radiance.theming.api.skin.ModerateSkin;
import org.pushingpixels.radiance.theming.api.skin.NebulaSkin;
import org.pushingpixels.radiance.theming.api.skin.SaharaSkin;
import org.pushingpixels.radiance.theming.api.skin.TwilightSkin;

public class LookAndFeelManager {

    // Directory where the properties file will be stored (application working directory)
    private static final String PROPERTIES_FILE_NAME = "laf.properties";
    private static final String LAF_KEY = "lookAndFeel";

    // Get the full path of the properties file in the application working directory
    public static String getPropertiesFilePath() {
        String userDir = System.getProperty("user.dir");
        return userDir + "\\src\\main\\resources\\config" + File.separator + PROPERTIES_FILE_NAME;
    }

    // Save the current LookAndFeel to the properties file
    public static void saveLookAndFeel(String lafClassName) {
        Properties properties = new Properties();
        properties.setProperty(LAF_KEY, lafClassName);

        try (FileOutputStream fos = new FileOutputStream(getPropertiesFilePath())) {
            properties.store(fos, "LookAndFeel Settings");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load the LookAndFeel from the properties file
    public static String loadLookAndFeel() {
        Properties properties = new Properties();

        try (FileInputStream fis = new FileInputStream(getPropertiesFilePath())) {
            properties.load(fis);
            return properties.getProperty(LAF_KEY, UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (IOException e) {
            e.printStackTrace();
            return UIManager.getCrossPlatformLookAndFeelClassName();
        }
    }

    // Apply the LookAndFeel
    public static void applyLookAndFeel(String lafClassName, JFrame frame) {

        try {
//                UIManager.setLookAndFeel(lafClassName);
            switch (lafClassName) {
                case "Graphite":
                    RadianceThemingCortex.GlobalScope.setSkin(new GraphiteSkin());
                    break;
                case "Graphite Aqua":
                    RadianceThemingCortex.GlobalScope.setSkin(new GraphiteAquaSkin());
                    break;
                case "Business":
                    RadianceThemingCortex.GlobalScope.setSkin(new BusinessSkin());
                    break;
                case "Business Black Steel":
                    RadianceThemingCortex.GlobalScope.setSkin(new BusinessBlackSteelSkin());
                    break;
                case "Business Blue Steel":
                    RadianceThemingCortex.GlobalScope.setSkin(new BusinessBlueSteelSkin());
                    break;
                case "AutumnSkin":
                    RadianceThemingCortex.GlobalScope.setSkin(new AutumnSkin());
                    break;
                case "CremeSkin":
                    RadianceThemingCortex.GlobalScope.setSkin(new CremeSkin());
                    break;
                case "CeruleanSkin":
                    RadianceThemingCortex.GlobalScope.setSkin(new CeruleanSkin());
                    break;
                case "GeminiSkin":
                    RadianceThemingCortex.GlobalScope.setSkin(new GeminiSkin());
                    break;
                case "MagellanSkin":
                    RadianceThemingCortex.GlobalScope.setSkin(new MagellanSkin());
                    break;
                case "ModerateSkin":
                    RadianceThemingCortex.GlobalScope.setSkin(new ModerateSkin());
                    break;
                case "NebulaSkin":
                    RadianceThemingCortex.GlobalScope.setSkin(new NebulaSkin());
                    break;
                case "SaharaSkin":
                    RadianceThemingCortex.GlobalScope.setSkin(new SaharaSkin());
                    break;
                case "TwilightSkin":
                    RadianceThemingCortex.GlobalScope.setSkin(new TwilightSkin());
                    break;
                case "FlatLightLaf":
                    UIManager.setLookAndFeel(new FlatLightLaf());
                    break;
                case "FlatDarkLaf":
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                    break;
            }
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
