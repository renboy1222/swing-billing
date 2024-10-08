/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.billing.gui.dialog.au;

import com.aldrin.billing.dao.impl.BillingDataDAOImpl;
import com.aldrin.billing.gui.panel.BillingData;
import com.aldrin.billing.model.Product;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Java Programming with Aldrin
 */
public class JDialogViewBillingDetails extends javax.swing.JDialog implements MouseListener {

    /**
     * Creates new form JDialogViewBillingDetails
     */
    private DecimalFormat df = new DecimalFormat("##,##0.00");

    public JDialogViewBillingDetails(java.awt.Frame parent, boolean modal, Long invoiceId, BillingData bd) {
        super(parent, modal);
        initComponents();
        setTable();
        setTitle("INVOICE ID:" + invoiceId);
        selectBillingData(invoiceId);
        calculateLineTotal();
        jLabelCustomer.setText("<html><u>" + bd.getCustomer().getLastName() + "</u></html>");
        jLabelUser.setText("<html><u>" + bd.getUser().getSurname() + "</u></html>");
        jLabelDateTime.setText("<html><u>" + bd.getFormattedDate() + "</u></html>");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabelUser = new javax.swing.JLabel();
        jLabelDateTime = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelCustomer = new javax.swing.JLabel();
        jAPanel1 = new com.aldrin.billing.util.JAPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelGrandTotal = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(940, 40));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabelUser.setPreferredSize(new java.awt.Dimension(0, 16));
        jPanel4.add(jLabelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, -1));

        jLabelDateTime.setPreferredSize(new java.awt.Dimension(0, 16));
        jPanel4.add(jLabelDateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, 180, -1));

        jLabel5.setText("USER:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, -1));

        jLabel6.setText("DATE/TIME");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 70, -1));

        jLabel7.setText("CUSTOMER:");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 70, -1));

        jLabelCustomer.setPreferredSize(new java.awt.Dimension(0, 16));
        jPanel4.add(jLabelCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 180, -1));

        jPanel1.add(jPanel4, java.awt.BorderLayout.NORTH);

        jAPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jTableProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTableProduct);

        jPanel5.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(5, 425));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel6, java.awt.BorderLayout.WEST);

        jPanel7.setOpaque(false);
        jPanel7.setPreferredSize(new java.awt.Dimension(5, 425));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 5, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 322, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel7, java.awt.BorderLayout.EAST);

        jPanel8.setOpaque(false);
        jPanel8.setPreferredSize(new java.awt.Dimension(886, 50));
        jPanel8.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 7, 5));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("TOTAL");
        jLabel1.setMinimumSize(new java.awt.Dimension(150, 20));
        jLabel1.setPreferredSize(new java.awt.Dimension(150, 30));
        jPanel8.add(jLabel1);

        jLabelGrandTotal.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabelGrandTotal.setForeground(new java.awt.Color(204, 0, 0));
        jLabelGrandTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGrandTotal.setText("0.00");
        jLabelGrandTotal.setPreferredSize(new java.awt.Dimension(100, 30));
        jPanel8.add(jLabelGrandTotal);

        jPanel2.add(jPanel8, java.awt.BorderLayout.SOUTH);

        jAPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel1.add(jAPanel1, java.awt.BorderLayout.CENTER);

        jPanel12.setOpaque(false);
        jPanel12.setPreferredSize(new java.awt.Dimension(2, 10));
        jPanel1.add(jPanel12, java.awt.BorderLayout.EAST);

        jPanel13.setOpaque(false);
        jPanel13.setPreferredSize(new java.awt.Dimension(2, 10));
        jPanel1.add(jPanel13, java.awt.BorderLayout.LINE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(790, 420));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.aldrin.billing.util.JAPanel jAPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCustomer;
    private javax.swing.JLabel jLabelDateTime;
    private javax.swing.JLabel jLabelGrandTotal;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduct;
    // End of variables declaration//GEN-END:variables
    public DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"INVOICE ID", "PRODUCT", "QUANTITY", "UNIT PRICE", "SUBTOTAL", "UNIT PPRICE UF", "SUB TOTAL UF"}, 0) {
        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return Integer.class;
            }
            switch (columnIndex) {
                case 1:
                    return String.class;
                case 2:
                    return Integer.class;
                case 3:
                    return Integer.class;
                case 4:
                    return Integer.class;
                case 5:
                    return Integer.class;
                default:
                    return String.class;
            }
        }

        public boolean isCellEditable(int row, int col) {
            if (col < 10) {
                return false;

            } else {
                return true;
            }
        }
    };
    private TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tableModel);

    private void setTable() {
        jTableProduct = new JTable(tableModel) {
            @Override
            public Component prepareRenderer(TableCellRenderer renderer,
                    int row, int col) {

                Component c = super.prepareRenderer(renderer, row, col);
                if (col == 3) {
                    String priceSell = (String) getValueAt(row, 3);
                    String adjustedPrice = (String) getValueAt(row, 3);
                    c.setForeground(adjustedPrice(Float.parseFloat(priceSell), Float.parseFloat(adjustedPrice)));
                } else if (col == 3) {
                    String loss = (String) getValueAt(row, 3);
                    c.setForeground(negativeColor(Float.parseFloat(loss)));
                } else if (col == 3) {
                    String intValue = (String) getValueAt(row, 3);
                    c.setForeground(expiredColor(intValue));
                } else {
                    c.setForeground(getForeground());
                }
                return c;
            }

            private Color getColor(String intValue) {
                Color color = null;
                if (!intValue.trim().isEmpty()) {
                    color = new Color(0, 102, 0);
                } else if (intValue.trim().isEmpty()) {
                    color = Color.RED;
                } else {
                    color = getForeground();
                }
                return color;
            }

            private Color expiredColor(String intValue) {
                Color color = null;
                if (intValue.trim().equals("EXPIRED")) {
                    color = Color.RED;
                } else if (intValue.trim().isEmpty()) {
                    color = new Color(0, 102, 0);
                } else {
                    color = getForeground();
                }
                return color;
            }

            private Color negativeColor(float intValue) {
                Color color = null;
                if (intValue < 0) {
                    color = Color.RED;
                } else if (intValue > 0) {
                    color = new Color(0, 102, 0);
                } else {
                    color = getForeground();
                }
                return color;
            }

            private Color adjustedPrice(float priceSell, float addjustedPrice) {
                Color color = null;
                if (priceSell != addjustedPrice) {
                    color = Color.RED;
                } else {
                    color = getForeground();
                }
                return color;
            }
        };
        jTableProduct.setCellSelectionEnabled(true);
        jTableProduct = new JTable(tableModel);
        jScrollPane1.setViewportView(jTableProduct);
        jTableProduct.addMouseListener(this);
        jTableProduct.setRowSorter(sorter);
        TableColumn[] column = new TableColumn[100];

        column[0] = jTableProduct.getColumnModel().getColumn(0);
        column[0].setPreferredWidth(60);

        column[1] = jTableProduct.getColumnModel().getColumn(1);
        column[1].setPreferredWidth(100);

        column[2] = jTableProduct.getColumnModel().getColumn(2);
        column[2].setPreferredWidth(100);

        column[3] = jTableProduct.getColumnModel().getColumn(3);
        column[3].setPreferredWidth(100);
        TableColumn hide0 = jTableProduct.getColumnModel().getColumn(0);
        hide0.setMinWidth(0);
        hide0.setMaxWidth(0);
        hide0.setPreferredWidth(0);

        TableColumn hide1 = jTableProduct.getColumnModel().getColumn(5);
        hide1.setMinWidth(0);
        hide1.setMaxWidth(0);
        hide1.setPreferredWidth(0);

        TableColumn hide6 = jTableProduct.getColumnModel().getColumn(6);
        hide6.setMinWidth(0);
        hide6.setMaxWidth(0);
        hide6.setPreferredWidth(0);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTableProduct) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 1) {
                    int row = jTableProduct.getSelectedRow();

                    if (row != -1) {
                        //"ID", "PRODUCT","DESCRIPTION","PRICE"
                        Long id = Long.parseLong(jTableProduct.getValueAt(row, 0).toString());
                        String product = jTableProduct.getValueAt(row, 1).toString();
                        String description = jTableProduct.getValueAt(row, 2).toString();
                        Product p = new Product();
                        p.setProductId(id);
                        p.setProduct(product);
                        p.setDescription(description);

//                        this.product = p;
                    }

                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    private BillingDataDAOImpl billingDataDAOImpl = new BillingDataDAOImpl();
    private ArrayList<BillingData> billingDataList;
//    String pattern = "MMM. dd, yyyy";
    String pattern = "MMM. dd, yyyy hh:mm a";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//    "INVOICE ID", "PRODUCT", "QUANTITY", "UNIT PRICE", "SUBTOTAL", "UNIT PPRICE UF", "SUB TOTAL UF"

    private void selectBillingData(Long invoiceID) {
        tableModel.setRowCount(0);
        billingDataList = billingDataDAOImpl.selectBillingDataDetails(invoiceID);
        tableModel.setRowCount(0);
        for (BillingData c : billingDataList) {
            tableModel.addRow(new Object[]{c.getInvoice().getInvoiceId(), c.getProduct().getProduct(), c.getInvoiceDetails().getQuantity(), df.format(c.getInvoiceDetails().getUnitPrice()), df.format(c.getInvoiceDetails().getQuantity() * c.getInvoiceDetails().getUnitPrice()), c.getInvoiceDetails().getUnitPrice(), c.getInvoiceDetails().getQuantity() * c.getInvoiceDetails().getUnitPrice()});
        }

    }

    private void calculateLineTotal() {
//        "INVOICE ID", "PRODUCT", "QUANTITY", "UNIT PRICE", "SUBTOTAL", "UNIT PPRICE UF"
        try {
            float grandTotal = 0.0F;
            for (int i = 0; i < jTableProduct.getRowCount(); i++) {
                Float lineTotal = 0.0F;
                Integer qty = Integer.parseInt(jTableProduct.getValueAt(i, 2).toString());
                Float unitPrice = Float.parseFloat(jTableProduct.getValueAt(i, 5).toString());
                lineTotal = qty * unitPrice;
                grandTotal = grandTotal + lineTotal;
                jTableProduct.setValueAt(df.format(lineTotal), i, 5);
                jTableProduct.setValueAt(lineTotal, i, 6);

            }
            jLabelGrandTotal.setText(df.format(grandTotal));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
