/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.aldrin.billing.gui.dialog.au;

/**
 *
 * @author Java Programming with Aldrin
 */
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class CustomColumnRenderer extends DefaultTableCellRenderer {

    private final int targetColumn;
    private final Color selectedForegroundColor;
    private final Color normalForegroundColor;

    public CustomColumnRenderer(int targetColumn, Color selectedForegroundColor, Color normalForegroundColor) {
        this.targetColumn = targetColumn;
        this.selectedForegroundColor = selectedForegroundColor;
        this.normalForegroundColor = normalForegroundColor;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {

        Component cellComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        if (column == targetColumn) {
            cellComponent.setForeground(isSelected ? selectedForegroundColor : normalForegroundColor);
        } else {
            cellComponent.setForeground(normalForegroundColor);
        }

        return cellComponent;
    }
}

