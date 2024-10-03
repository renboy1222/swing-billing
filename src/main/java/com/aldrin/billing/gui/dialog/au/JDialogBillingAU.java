/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.aldrin.billing.gui.dialog.au;

import com.aldrin.billing.dao.impl.InvoiceDAOImpl;
import com.aldrin.billing.dao.impl.InvoiceDetailsDAOImpl;
import com.aldrin.billing.dao.impl.PaymentDAOImpl;
import com.aldrin.billing.dao.impl.ProductDAOImpl;
import com.aldrin.billing.gui.JFrameApp;
import com.aldrin.billing.gui.dialog.JDialogPayment;
import com.aldrin.billing.gui.dialog.PrintBilling;
import com.aldrin.billing.model.Customer;
import com.aldrin.billing.model.Invoice;
import com.aldrin.billing.model.InvoiceDetails;
import com.aldrin.billing.model.Payment;
import com.aldrin.billing.model.Product;
import com.aldrin.billing.model.User;
import com.aldrin.billing.util.ComboBoxAutoSearch;
import com.aldrin.billing.util.ComboBoxList;
import com.aldrin.billing.util.LoginUser;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author ALDRIN B. C.
 */
public class JDialogBillingAU extends javax.swing.JDialog implements MouseListener, Printable {

    private ProductDAOImpl productDAOImpl = new ProductDAOImpl();
    private JFrameApp jFrameCafSys;
    private DecimalFormat df = new DecimalFormat("##,##0.00");
    private Product product = new Product();
    static String title = "";
    private JTextComponent editor;
    private Float grandTotal = 0.0F;
    private PaymentDAOImpl paymentDAOImpl = new PaymentDAOImpl();
    private InvoiceDAOImpl invoiceDAOImpl = new InvoiceDAOImpl();

    public JDialogBillingAU(JFrameApp jFrameSariPOS, boolean modal) {
        super(jFrameSariPOS, modal);
        initComponents();
        this.jFrameCafSys = jFrameSariPOS;
        this.title = "New";

        setTable();
        popComboProduct();
        jComboBoxProduct.setEditable(true);
        editor = (JTextComponent) jComboBoxProduct.getEditor().getEditorComponent();
        editor.addKeyListener(new ComboBoxItemKeyListener());
        editor.setDocument(new ComboBoxAutoSearch(jComboBoxProduct));
        addPopupMenu();
        jButtonPay.setEnabled(false);

    }

    public JDialogBillingAU(JFrameApp jFrameCafSys, boolean modal, Product product, String title) {
        super(jFrameCafSys, modal);
        initComponents();
        setTitle("Update product");
        this.product = product;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        setTable();
//        setUndecorated(true);
    }

    public JDialogBillingAU(JFrameApp jFrameCafSys, boolean modal, String title, Product product) {
        super(jFrameCafSys, modal);
        initComponents();
        setTitle("Delete product");
        this.product = product;
        this.title = title;
        getRootPane().putClientProperty(FlatClientProperties.TITLE_BAR_BACKGROUND, new Color(187, 187, 187));
        setTable();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableProduct = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelGrandTotal = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jComboBoxProduct = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jButtonAddProduct = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButtonPay = new javax.swing.JButton(new FlatSVGIcon("svg/pay-cash.svg",32,32));
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Billing");

        jPanel5.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

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

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel10.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jPanel10.setPreferredSize(new java.awt.Dimension(10, 80));
        jPanel10.setRequestFocusEnabled(false);
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("<html><center>GRAND<br><h3 style=\"color:red; padding:0; margin:0;\">TOTAL</h4></center></html>");
        jLabel2.setMinimumSize(new java.awt.Dimension(250, 32));
        jLabel2.setPreferredSize(new java.awt.Dimension(250, 60));
        jPanel11.add(jLabel2);

        jLabelGrandTotal.setFont(new java.awt.Font("Segoe UI", 0, 48)); // NOI18N
        jLabelGrandTotal.setForeground(new java.awt.Color(204, 0, 0));
        jLabelGrandTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabelGrandTotal.setText("0.00");
        jLabelGrandTotal.setPreferredSize(new java.awt.Dimension(200, 60));
        jPanel11.add(jLabelGrandTotal);

        jPanel10.add(jPanel11, java.awt.BorderLayout.EAST);
        jPanel10.add(jPanel12, java.awt.BorderLayout.CENTER);

        jPanel13.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(102, 102, 102)));
        jPanel10.add(jPanel13, java.awt.BorderLayout.PAGE_START);

        jPanel4.add(jPanel10, java.awt.BorderLayout.SOUTH);

        jPanel5.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(10, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 15));
        jPanel1.add(jPanel7);

        jLabel1.setText("PRODUCT");
        jLabel1.setPreferredSize(new java.awt.Dimension(53, 25));
        jPanel1.add(jLabel1);

        jPanel8.setPreferredSize(new java.awt.Dimension(5, 5));
        jPanel1.add(jPanel8);

        jComboBoxProduct.setPreferredSize(new java.awt.Dimension(550, 25));
        jComboBoxProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jComboBoxProductKeyPressed(evt);
            }
        });
        jPanel1.add(jComboBoxProduct);

        jPanel9.setPreferredSize(new java.awt.Dimension(5, 10));
        jPanel1.add(jPanel9);

        jButtonAddProduct.setText("+");
        jButtonAddProduct.setMargin(new java.awt.Insets(2, 0, 3, 0));
        jButtonAddProduct.setPreferredSize(new java.awt.Dimension(25, 25));
        jButtonAddProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddProductActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAddProduct);

        jPanel5.add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setPreferredSize(new java.awt.Dimension(10, 60));
        jPanel2.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 10));

        jButtonPay.setText("<html><center>Pay<br><h4 style=\"color:red; padding:0; margin:0;\">[F5]</h4></center></html>");
        jButtonPay.setFocusable(false);
        jButtonPay.setMargin(new java.awt.Insets(2, 2, 3, 2));
        jButtonPay.setPreferredSize(new java.awt.Dimension(90, 40));
        jButtonPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPayActionPerformed(evt);
            }
        });
        jPanel2.add(jButtonPay);

        jPanel5.add(jPanel2, java.awt.BorderLayout.SOUTH);
        jPanel5.add(jPanel3, java.awt.BorderLayout.WEST);
        jPanel5.add(jPanel6, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanel5, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(817, 499));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    JDialogPayment paymentDialog;
    private void jButtonPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPayActionPerformed
        paymentDialog = new JDialogPayment(jFrameCafSys, true, getGrandTotal());
        paymentDialog.setVisible(true);

        if (paymentDialog.getDispense() == false) {
            //record transactions

        } else {
            InvoiceCollector ic = new InvoiceCollector();
            PaymentCollector pc = new PaymentCollector();
            Customer c = new Customer();

            // add invoice (Customer id,"Total amount",invoice createdat)
            Invoice invoice = new Invoice();
            c.setId(ic.getPaymentCollector().getCustomer().getId());
            invoice.setCustomer(c);
            invoice.setTotalAmount(ic.getPaymentCollector().getTotal());
            invoiceDAOImpl.addInvoice(invoice);

            // add paymentDialog (User id, Invoice Id, amount, paymentDialog method,paymentDialog date)
            Payment payment = new Payment();
            User user = new User();
            Invoice inv = new Invoice();
            user.setId(new LoginUser().getUser().getId());
            payment.setAmount(ic.getPaymentCollector().getTotal());
            payment.setUser(user);
            inv.setInvoiceId(invoiceDAOImpl.getMaxId());
            payment.setInvoice(inv);
            payment.setMethod(ic.getPaymentCollector().getPaymentMethod());
            paymentDAOImpl.addPayment(payment);
            // add invoice details (invoice id, product id, quantity, unit price)
            InvoiceDetails invoiceDetails = new InvoiceDetails();
            Product productl = new Product();
            InvoiceDetailsDAOImpl inDAOImpl = new InvoiceDetailsDAOImpl();
            for (int i = 0; i < jTableProduct.getRowCount(); i++) {
//                "ID", "#", "PRODUCT", "DESCRIPTION", "QTY", "PRICE", "LINE TOTAL", "PRICE UF", "LINE TOTAL UF"
                productl.setProductId(Long.parseLong(jTableProduct.getValueAt(i, 0).toString()));
                invoiceDetails.setInvoice(inv);
                invoiceDetails.setProduct(productl);
                invoiceDetails.setQuantity(Integer.parseInt(jTableProduct.getValueAt(i, 4).toString()));
                invoiceDetails.setUnitPrice(Float.parseFloat(jTableProduct.getValueAt(i, 7).toString()));
                inDAOImpl.addInvoiceDetails(invoiceDetails);

            }
            if (paymentDialog.getPrintReceipt() == true) {
                PrinterJob pj = PrinterJob.getPrinterJob();
                pj.setPrintable(this, getPageFormat(pj));

//      there's dialog
                pj.setPrintable(this);
                boolean ok = pj.printDialog();
                if (ok) {
                    try {
                        pj.print();
                    } catch (PrinterException ex) {
                    }
                }
            }

            tableModel.setRowCount(0);
            jLabelGrandTotal.setText("0.00");
        }


    }//GEN-LAST:event_jButtonPayActionPerformed

    private void jButtonAddProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddProductActionPerformed
        comboBoxAddProductToTable();
        calculateLineTotal();
        if (tableModel.getRowCount() > 0) {
            jButtonPay.setEnabled(true);
        }
    }//GEN-LAST:event_jButtonAddProductActionPerformed

    private void jComboBoxProductKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jComboBoxProductKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.print("ENTER KEY IS PRESSED");
        }
    }//GEN-LAST:event_jComboBoxProductKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddProduct;
    private javax.swing.JButton jButtonPay;
    private javax.swing.JComboBox<Object> jComboBoxProduct;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelGrandTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableProduct;
    // End of variables declaration//GEN-END:variables

    public DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"ID", "#", "PRODUCT", "DESCRIPTION", "QTY", "PRICE", "LINE TOTAL", "PRICE UF", "LINE TOTAL UF"}, 0) {
        public Class getColumnClass(int columnIndex) {
            if (columnIndex == 0) {
                return String.class;
            }
            switch (columnIndex) {
                case 1:
                    return String.class;
                case 2:
                    return String.class;
                case 3:
                    return String.class;
                case 4:
                    return Integer.class;
                case 5:
                    return Integer.class;
                case 6:
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

        int targetColumn = 6;
        Color selectedForegroundColor = Color.RED;
        Color normalForegroundColor = new Color(204, 0, 0);

        jTableProduct.setCellSelectionEnabled(true);
        jTableProduct = new JTable(tableModel);
        jScrollPane1.setViewportView(jTableProduct);
        jTableProduct.addMouseListener(this);
        jTableProduct.setRowSorter(sorter);
        TableColumn[] column = new TableColumn[100];

        column[0] = jTableProduct.getColumnModel().getColumn(0);
        column[0].setPreferredWidth(60);

        column[1] = jTableProduct.getColumnModel().getColumn(1);
        column[1].setPreferredWidth(30);

        column[2] = jTableProduct.getColumnModel().getColumn(2);
        column[2].setPreferredWidth(50);

        column[3] = jTableProduct.getColumnModel().getColumn(3);
        column[3].setPreferredWidth(180);

        column[4] = jTableProduct.getColumnModel().getColumn(4);
        column[4].setPreferredWidth(80);

        column[5] = jTableProduct.getColumnModel().getColumn(5);
        column[5].setPreferredWidth(80);

        TableColumn hide0 = jTableProduct.getColumnModel().getColumn(0);
        hide0.setMinWidth(0);
        hide0.setMaxWidth(0);
        hide0.setPreferredWidth(0);

        TableColumn hide1 = jTableProduct.getColumnModel().getColumn(7);
        hide1.setMinWidth(0);
        hide1.setMaxWidth(0);
        hide1.setPreferredWidth(0);

        TableColumn hide2 = jTableProduct.getColumnModel().getColumn(8);
        hide2.setMinWidth(0);
        hide2.setMaxWidth(0);
        hide2.setPreferredWidth(0);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == jTableProduct) {
            if (e.getButton() == MouseEvent.BUTTON1) {
                if (e.getClickCount() == 1) {
                    int row = jTableProduct.getSelectedRow();
                    if (!jTableProduct.getValueAt(row, 1).equals(" ")) {
                        if (row != -1) {

                            //"ID", #,"PRODUCT","DESCRIPTION","QTY","PRICE","LINE TOTAL"
                            Long id = Long.parseLong(jTableProduct.getValueAt(row, 0).toString());
                            String product = jTableProduct.getValueAt(row, 2).toString();
                            String description = jTableProduct.getValueAt(row, 3).toString();
                            String priceString = jTableProduct.getValueAt(row, 5).toString();
                            Float price = null;
                            if (!priceString.isEmpty()) {
                                price = Float.parseFloat(jTableProduct.getValueAt(row, 5).toString());
                            }

                            Product p = new Product();
                            p.setProductId(id);
                            p.setProduct(product);
                            p.setDescription(description);
                            p.setPrice(price);
                            this.product = p;
                        }
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

    private void popComboProduct() {
        this.jComboBoxProduct.removeAllItems();
        productDAOImpl.comboBoxProduct();
        for (ComboBoxList a : productDAOImpl.getList()) {
            this.jComboBoxProduct.addItem(a);
        }
    }

    class ComboBoxItemKeyListener extends KeyAdapter {

        public void keyPressed(KeyEvent evt) {
            if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                comboBoxAddProductToTable();
                calculateLineTotal();
                if (tableModel.getRowCount() > 0) {
                    jButtonPay.setEnabled(true);
                }

            } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_A) {
            } else if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_D) {
            }
        }
    }

    private void comboBoxAddProductToTable() {
        boolean multipleProduct = false;
//        StockInEntryDAOImpl productDAOImpl = new StockInEntryDAOImpl();
//        StockInEntry se = new StockInEntry();
        ProductDAOImpl productDAOImpl = new ProductDAOImpl();
        Product p = new Product();
        if (jComboBoxProduct.getSelectedItem().toString().isEmpty()) {
            return;
        }
        ComboBoxList pId = (ComboBoxList) this.jComboBoxProduct.getSelectedItem();
        p.setProductId(pId.getId());
//        se.setProduct(p);
        p = productDAOImpl.findProductById(p);

        if (p == null) {
            JOptionPane.showConfirmDialog(this, "No selected product or services selected!", "Warning message!!", JOptionPane.WARNING_MESSAGE);

            return;
        } else {
            int qty = 0;
//            "ID","#", "PRODUCT", "DESCRIPTION", "QTY", "PRICE", "LINE TOTAL","PRICE UF","SUB TOTAL UF"
            if (jTableProduct.getRowCount() == 0) {
                tableModel.addRow(new Object[]{p.getProductId(), jTableProduct.getRowCount() + 1, p.getProduct(), p.getDescription(), "1", df.format(p.getPrice()), df.format(p.getPrice()), p.getPrice(), p.getPrice()});
                return;
            } else {
////          edit quantity  if duplicate product id               
                itemCounter:
                for (int i = 0; i < jTableProduct.getRowCount(); i++) {
                    Long productId = Long.parseLong(jTableProduct.getValueAt(i, 0).toString());
                    int previousQty = Integer.parseInt(jTableProduct.getValueAt(i, 4).toString());
                    float total = Float.parseFloat(jTableProduct.getValueAt(i, 8).toString());
                    qty = 1 + previousQty;
                    if (p.getProductId() == productId) {
                        jTableProduct.setValueAt(qty, i, 4);
                        multipleProduct = false;
                        break itemCounter;
                    } else {
                        multipleProduct = true;
                    }
                }
                if (multipleProduct == true) {
                    tableModel.addRow(new Object[]{p.getProductId(), jTableProduct.getRowCount() + 1, p.getProduct(), p.getDescription(), "1", df.format(p.getPrice()), df.format(p.getPrice()), p.getPrice(), (qty * p.getPrice())});
                }
            }

//            se = null;
//            jTextFieldBarcode.setText("");
        }
        calculateLineTotal();

    }

    private void calculateLineTotal() {
        try {
            float grandTotal = 0.0F;
            for (int i = 0; i < jTableProduct.getRowCount(); i++) {
                Float lineTotal = 0.0F;
                Integer qty = Integer.parseInt(jTableProduct.getValueAt(i, 4).toString());
                Float unitPrice = Float.parseFloat(jTableProduct.getValueAt(i, 7).toString());
                lineTotal = qty * unitPrice;
                grandTotal = grandTotal + lineTotal;
                jTableProduct.setValueAt(df.format(lineTotal), i, 6);
                jTableProduct.setValueAt(lineTotal, i, 8);

            }
            jLabelGrandTotal.setText(df.format(grandTotal));
            setGrandTotal(grandTotal);
            columnRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Create a custom cell renderer for Integer columns
    DefaultTableCellRenderer columnRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Check if the column contains Integer values (Age or Score)
            if (table.getColumnClass(column) == Integer.class) {
                setForeground(new Color(204, 0, 0)); // Set the foreground color for the entire column
            } else {
                setForeground(Color.BLACK); // Default color for non-Integer columns
            }
            // Check if this is the last row
            if (row == table.getRowCount() - 1) {
                c.setFont(new Font("Serif", Font.BOLD | Font.PLAIN, 16)); // Customize font style and size
                c.setForeground(new Color(204, 0, 0)); // Optional: change text color
            } else {
                c.setFont(table.getFont()); // Use default font for other rows
                c.setForeground(Color.BLACK); // Optional: reset text color
            }

            return c;
        }
    };

    // Create popup menu
    JPopupMenu popupMenu = new JPopupMenu();

    // Create menu items
    JMenuItem editItem = new JMenuItem("Edit");
    JMenuItem deleteItem = new JMenuItem("Delete");

    public void addPopupMenu() {
        editItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTableProduct.getSelectedRow();
                if (selectedRow != -1) {
                    String name = (String) jTableProduct.getValueAt(selectedRow, 2);
                    JOptionPane.showMessageDialog(jFrameCafSys, "Editing " + name);
                }
            }
        });

        deleteItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTableProduct.getSelectedRow();
                if (selectedRow != -1) {
                    DefaultTableModel model = (DefaultTableModel) jTableProduct.getModel();
                    model.removeRow(selectedRow);
//                    String product = jTableProduct.getValueAt(0, 2).toString();
                    if (tableModel.getRowCount() == 0) {
                        jButtonPay.setEnabled(false);
                        jLabelGrandTotal.setText("0.00");
                        return;
                    }
                    if (product.toString().equals(" ") || product.toString().trim() == "") {
                        tableModel.setRowCount(0);

                    }
                }
                if (tableModel.getRowCount() == 0) {
                    jButtonPay.setEnabled(false);
                }
            }
        });

        // Add menu items to the popup menu
        popupMenu.add(editItem);
        popupMenu.add(deleteItem);

        // Add action listeners to the menu items
        // Add mouse listener to the table
        jTableProduct.addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }

            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    showPopup(e);
                }
            }

            private void showPopup(MouseEvent e) {
                int row = jTableProduct.rowAtPoint(e.getPoint());
                int column = jTableProduct.columnAtPoint(e.getPoint());
                if (!jTableProduct.isRowSelected(row)) {
                    jTableProduct.changeSelection(row, column, false, false);
                }
                String product = jTableProduct.getValueAt(row, column).toString();
                if (product.toString().equals(" ") || product.toString().equals("Grand Total")) {
                    return;
                } else {
                    popupMenu.show(e.getComponent(), e.getX(), e.getY());
                }

            }
        });
    }

    private void payment() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the grandTotal
     */
    public Float getGrandTotal() {
        return grandTotal;
    }

    /**
     * @param grandTotal the grandTotal to set
     */
    public void setGrandTotal(Float grandTotal) {
        this.grandTotal = grandTotal;
    }

    private PrintBilling printBilling = new PrintBilling();

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        Float totalAmount = 0.0F;
        Float change = 0.0F;
        String readFile = System.getProperty("user.dir") + "/src/main/resources/images/logo.png";
        ImageIcon icon = new ImageIcon(readFile);
        int result = NO_SUCH_PAGE;
        if (pageIndex == 0) {

            Graphics2D g2d = (Graphics2D) graphics;
            double width = pageFormat.getImageableWidth();
            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            FontMetrics metrics = g2d.getFontMetrics(new Font("Arial", Font.BOLD, 7));
            try {
                int y = 15;
                int yShift = 10;
                int headerRectHeight = 15;
                g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());
                double wh = pageFormat.getImageableWidth();
                double ht = pageFormat.getImageableHeight();
                g2d.drawImage(null, 0, 0, (int) wh, (int) ht, null);

                g2d.setFont(new Font("Monospaced", Font.PLAIN, 9));
                g2d.drawImage(icon.getImage(), 75, 20, 30, 30, rootPane);
                y += yShift + 30;
                g2d.drawString("------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Java Programming with Aldrin", 10, y);
                y += yShift;
                g2d.drawString("  Rufino St.,Legaspi Village ", 10, y);
                y += yShift;
                g2d.drawString("   Makati City, Metro Manila ", 10, y);
                y += yShift;
                y += yShift;
                y += yShift;
                g2d.drawString("------------------------------", 10, y);
                y += headerRectHeight;

                g2d.drawString(" Product               Price  ", 10, y);
                y += yShift;
                g2d.drawString("------------------------------", 10, y);
                y += headerRectHeight;
                PrintBilling pb = new PrintBilling();
                String user = "";
                String invoiceNum = "";
                String dateTime = "";
                for (PrintBilling item : pb.printBillingReceipt(invoiceDAOImpl.getMaxId())) {
                    g2d.drawString(" " + item.getProductName() + "                    ", 10, y);
                    y += yShift;
                    g2d.drawString("     " + item.getQuantity() + " x " + item.getUnitPrice(), 5, y);
                    g2d.drawString(String.valueOf(df.format(item.getQuantity() * item.getUnitPrice())), 130, y);
                    y += yShift;
                    totalAmount = totalAmount + (item.getQuantity() * item.getUnitPrice());
                    user = item.getUserSurname() + ", " + item.getUserFirstname().substring(0, 1)+".";
                    invoiceNum = item.getInvoiceId();
                    dateTime = item.getInvoiceDate();
                }
                Float cash = paymentDialog.getPrintBillingCash();
                String csh = String.valueOf(df.format(cash));

                g2d.drawString("------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Total   :            " + String.valueOf(df.format(totalAmount)) + "   ", 10, y);
                y += yShift;
                g2d.drawString("------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Cash    :            " + csh + "   ", 10, y);
                y += yShift;
                g2d.drawString("------------------------------", 10, y);
                y += yShift;
                g2d.drawString(" Change  :            " + String.valueOf(df.format(paymentDialog.getPrintBillingCash() - totalAmount)) + "   ", 10, y);
                y += yShift;
                y += yShift;
                y += yShift;

                g2d.drawString("User:    " + user, 10, y);
                y += yShift;
                g2d.drawString("INVOICE #:" + invoiceNum, 10, y);
                y += yShift;
                g2d.drawString("DATE/TIME:" + dateTime, 10, y);
                y += yShift;
                g2d.drawString("******************************", 10, y);
                y += yShift;
                g2d.drawString("    THANK YOU, COME AGAIN!!    ", 10, y);
                y += yShift;
                g2d.drawString("******************************", 10, y);
                y += yShift;

            } catch (Exception e) {
                e.printStackTrace();
            }
            result = PAGE_EXISTS;
        }
        return result;
    }

    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double width = pf.getImageableWidth();
        double height = pf.getImageableHeight();
        paper.setSize(width, height);
        paper.setImageableArea(0, 10, width, height - cm_to_pp(1));
        pf.setOrientation(PageFormat.PORTRAIT);
        pf.setPaper(paper);
        return pf;
    }

    protected static double cm_to_pp(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 58d;
    }

}
