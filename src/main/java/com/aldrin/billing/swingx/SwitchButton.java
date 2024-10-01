/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.swingx;

import static com.aldrin.billing.gui.JFrameApp.switchButtonThemeMode;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JComponent;

/**
 *
 * @author Java Programming with Aldrin
 */
public class SwitchButton extends JComponent {

    private boolean darkMode;
    private int slidePosition = 0;
    private int w = 60;
    private int h = 30;

    private Color ovalDarkColor;
    private Color ovalLightColor;
    private Color circleDarkColor;
    private Color circleLightColor;

    public SwitchButton() {
        this.slidePosition = 0;
//        this.updateColor(circleLightColor, circleLightColor, ovalLightColor, ovalLightColor);
        this.setPreferredSize(new Dimension(getW(), getH()));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toggle();
                if (isDarkMode()) {
                    setBackground(Color.DARK_GRAY);
                } else {
                    setBackground(Color.WHITE);

                }
            }
        });
        toggle();
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void toggle() {
        darkMode = !darkMode;
        new Thread(() -> animateToggle()).start();
    }

    private void animateToggle() {
        Color ovalDarkColor = new java.awt.Color(128, 128, 128);
        Color ovalLightColor = new java.awt.Color(204, 204, 204);
        Color circleDarkColor = new java.awt.Color(51, 51, 51);
        Color circleLightColor = new java.awt.Color(255, 255, 255);
        int start = darkMode ? 0 : getWidth() - getHeight();
        int end = darkMode ? getWidth() - getHeight() : 0;
        if (isDarkMode() == true) {
            for (int i = 20; i >= 20; i--) {
                slidePosition = start + (end - start) * i / 20;
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            switchButtonThemeMode.updateColor(circleDarkColor, circleDarkColor, ovalDarkColor, ovalDarkColor);
        } else {
            for (int i = 0; i <= 20; i++) {
                slidePosition = start + (end - start) * i / 20;
                repaint();
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            switchButtonThemeMode.updateColor(circleLightColor, circleLightColor, ovalLightColor, ovalLightColor);

        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Enable antialiasing for smoother graphics
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw the background of the toggle
//        g2d.setColor(isDarkMode() ? getOvalLightColor() : getOvalDarkColor());
        g2d.setColor(isDarkMode() ?  getOvalDarkColor(): getOvalLightColor());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight()); // no gatter

        // Draw the sliding button
        if (isDarkMode()) {
//            g2d.setColor(getCircleLightColor());
            g2d.setColor(getCircleDarkColor());
        } else {
//            g2d.setColor(getCircleDarkColor());
            g2d.setColor(getCircleLightColor());

        }
        // Draw the sliding button
        g2d.fillOval(slidePosition + 5, 5, getHeight() - 10, getHeight() - 10);

    }

    /**
     * @return the w
     */
    public int getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(int w) {
        this.w = w;
    }

    /**
     * @return the h
     */
    public int getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(int h) {
        this.h = h;
    }

    /**
     * @param darkMode the darkMode to set
     */
    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }

    /**
     * @return the ovalDarkColor
     */
    public Color getOvalDarkColor() {
        return ovalDarkColor;
    }

    /**
     * @param ovalDarkColor the ovalDarkColor to set
     */
    public void setOvalDarkColor(Color ovalDarkColor) {
        this.ovalDarkColor = ovalDarkColor;
    }

    /**
     * @return the ovalLightColor
     */
    public Color getOvalLightColor() {
        return ovalLightColor;
    }

    /**
     * @param ovalLightColor the ovalLightColor to set
     */
    public void setOvalLightColor(Color ovalLightColor) {
        this.ovalLightColor = ovalLightColor;
    }

    /**
     * @return the circleDarkColor
     */
    public Color getCircleDarkColor() {
        return circleDarkColor;
    }

    /**
     * @param circleDarkColor the circleDarkColor to set
     */
    public void setCircleDarkColor(Color circleDarkColor) {
        this.circleDarkColor = circleDarkColor;
    }

    /**
     * @return the circleLightColor
     */
    public Color getCircleLightColor() {
        return circleLightColor;
    }

    /**
     * @param circleLightColor the circleLightColor to set
     */
    public void setCircleLightColor(Color circleLightColor) {
        this.circleLightColor = circleLightColor;
    }

    public void updateColor(Color circleDarkColor, Color circleLightColor, Color ovalDarkColor, Color ovalLightColor) {
        this.circleDarkColor = circleDarkColor;
        this.circleLightColor = circleLightColor;
        this.ovalDarkColor = ovalDarkColor;
        this.ovalLightColor = ovalLightColor;
        repaint(); // Call repaint to trigger paintComponent and update the UI
    }

}
