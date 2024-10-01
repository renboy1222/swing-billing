/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.swingx;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Java Programming with Aldrin
 */
public class ProfileIcon implements Icon {

    private Icon icon;
    private int borderSize;
    

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
//        super.paintComponent(g);
        if (getIcon() != null) {
            Graphics2D g2d = (Graphics2D) g.create();
            int diameter = Math.min(getIconWidth(), getIconHeight());
            int xx = (getIconWidth() - diameter) / 2;
            int yy = (getIconHeight() - diameter) / 2;
            x=xx;
            y=yy;

            g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            Ellipse2D clip = new Ellipse2D.Double(5, 2, diameter, diameter);
            g2d.setClip(clip);
            g2d.drawImage(((ImageIcon) getIcon()).getImage(), 5, 2, diameter, diameter, null);
            g2d.setClip(null);

            GradientPaint gradient = new GradientPaint(x, y, Color.RED, x + diameter, y + diameter, Color.YELLOW);
            g2d.setPaint(gradient);
            g2d.setStroke(new BasicStroke(getBorderSize()));
            g2d.draw(clip);
            g2d.dispose();
        }
        

    }

    @Override
    public int getIconWidth() {
        return 22;
    }

    @Override
    public int getIconHeight() {
        return 22;
    }

    /**
     * @return the icon
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * @param icon the icon to set
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * @return the borderSize
     */
    public int getBorderSize() {
        return borderSize;
    }

    /**
     * @param borderSize the borderSize to set
     */
    public void setBorderSize(int borderSize) {
        this.borderSize = borderSize;
    }

}
