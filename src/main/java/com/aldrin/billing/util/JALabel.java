/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JALabel extends JLabel {

    private Icon aPhoto;
    private int aBorderSize;

    public JALabel() {
        setaBorderSize(2);
        setaPhoto(null);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (getaPhoto() != null) {
            Graphics2D g2d = (Graphics2D) g.create();

            // Enable anti-aliasing for smooth edges
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Define the size and position of the circle
            int diameter = Math.min(getWidth(), getHeight());
            int x = (getWidth() - diameter) / 2;
            int y = (getHeight() - diameter) / 2;

            // Draw the circular clipping area
            Ellipse2D.Double clip = new Ellipse2D.Double(x, y, diameter, diameter);
            g2d.setClip(clip);
//
//            // Draw the image inside the circular clipping area
            g2d.drawImage(((ImageIcon) getaPhoto()).getImage(), x, y, diameter, diameter, null);

            // Remove the clipping area
            g2d.setClip(null);

            // Create a gradient for the border
            GradientPaint gradient = new GradientPaint(x, y, Color.RED, x + diameter, y + diameter, Color.YELLOW);
            g2d.setPaint(gradient);

            // Draw the border
            g2d.setStroke(new BasicStroke(aBorderSize)); // Adjust the border thickness
            g2d.draw(clip);

            g2d.dispose();
        }else{
            setaPhoto(null);
        }
    }



    /**
     * @return the aPhoto
     */
    public Icon getaPhoto() {
        return aPhoto;
    }

    /**
     * @param aPhoto the aPhoto to set
     */
    public void setaPhoto(Icon aPhoto) {
        this.aPhoto = aPhoto;
    }

    /**
     * @return the aBorderSize
     */
    public int getaBorderSize() {
        return aBorderSize;
    }

    /**
     * @param aBorderSize the aBorderSize to set
     */
    public void setaBorderSize(int aBorderSize) {
        this.aBorderSize = aBorderSize;
    }

 

};
