/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.inmobiliaria_davidcarrosalinas;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author 6002755
 */
public class Ventana extends javax.swing.JFrame {

    /**
     * Creates new form Ventana
     */
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private DefaultListModel modelo;
    Info i;
    
    public Ventana() {
        initComponents();
        i = new Info(this, false);
        Image img = new ImageIcon("./imagenes/grabar.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        jMenuItemGrabar.setIcon(img2);
        img = new ImageIcon("./imagenes/borrar.png").getImage();
        img2 = new ImageIcon(img.getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        jMenuItemBorrar.setIcon(img2);
        img = new ImageIcon("./imagenes/exportar.png").getImage();
        img2 = new ImageIcon(img.getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        jMenuItemExportar.setIcon(img2);
        img = new ImageIcon("./imagenes/importar.png").getImage();
        img2 = new ImageIcon(img.getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        jMenuItemImportar.setIcon(img2);
        img = new ImageIcon("./imagenes/estrella.png").getImage();
        img2 = new ImageIcon(img.getScaledInstance(16, 16, Image.SCALE_SMOOTH));
        jMenuItemSalir.setIcon(img2);
        jMenuItemColoPanel.setIcon(img2);
        
        img = new ImageIcon("./imagenes/info.png").getImage();
        img2 = new ImageIcon(img.getScaledInstance(54, 54, Image.SCALE_SMOOTH));
        jToggleButtonInfo.setIcon(img2);
        
        modelo = new DefaultListModel();
        modelo.clear();
        jList1.setModel(modelo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanelPrincipal = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextFieldNombreSucursal = new javax.swing.JTextField();
        jTextFieldRazonSocial = new javax.swing.JTextField();
        jTextFieldNIF = new javax.swing.JTextField();
        jTextFieldComision = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jRadioButtonDia = new javax.swing.JRadioButton();
        jRadioButtonSemana = new javax.swing.JRadioButton();
        jRadioButtonMes = new javax.swing.JRadioButton();
        jRadioButtonOtro = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextFieldPropietario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextFieldInquilino = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextFieldDescuento = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jToggleButtonInfo = new javax.swing.JToggleButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemGrabar = new javax.swing.JMenuItem();
        jMenuItemBorrar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemExportar = new javax.swing.JMenuItem();
        jMenuItemImportar = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemColoPanel = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Examen DavidCarroSalinas");

        jPanelPrincipal.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setText("Sucursal:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Razon social:");

        jLabel4.setText("NIF:");

        jLabel5.setText("Comisión:");

        jTextFieldNombreSucursal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNombreSucursalFocusLost(evt);
            }
        });

        jTextFieldRazonSocial.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldRazonSocialFocusLost(evt);
            }
        });

        jTextFieldNIF.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNIFFocusLost(evt);
            }
        });

        jTextFieldComision.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldComisionFocusLost(evt);
            }
        });

        jLabel6.setText("Tipo:");

        buttonGroup1.add(jRadioButtonDia);
        jRadioButtonDia.setText("Día");

        buttonGroup1.add(jRadioButtonSemana);
        jRadioButtonSemana.setText("Semana");

        buttonGroup1.add(jRadioButtonMes);
        jRadioButtonMes.setText("Mes");

        buttonGroup1.add(jRadioButtonOtro);
        jRadioButtonOtro.setText("Otro");

        jLabel7.setText("Descripción:");

        jTextFieldDescripcion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDescripcionFocusLost(evt);
            }
        });

        jLabel8.setText("Propietario:");

        jTextFieldPropietario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPropietarioFocusLost(evt);
            }
        });

        jLabel9.setText("Inquilino:");

        jTextFieldInquilino.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldInquilinoFocusLost(evt);
            }
        });

        jLabel10.setText("Fecha:");

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());

        jLabel11.setText("Precio:");

        jTextFieldPrecio.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPrecioFocusLost(evt);
            }
        });

        jLabel12.setText("Descuento:");

        jTextFieldDescuento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldDescuentoFocusLost(evt);
            }
        });

        jLabel13.setText("Empleado:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "David Carro", "Alberto Rodriguez", "Mía Martín", "Angel De Vega" }));

        jList1.setBackground(new java.awt.Color(255, 255, 204));
        jList1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 204, 204), new java.awt.Color(0, 0, 0), null));
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        jToggleButtonInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButtonInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelPrincipalLayout.createSequentialGroup()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel1))
                        .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                            .addGap(25, 25, 25)
                            .addComponent(jLabel2))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldNombreSucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                    .addComponent(jTextFieldRazonSocial)
                    .addComponent(jTextFieldNIF)
                    .addComponent(jTextFieldComision))
                .addGap(41, 41, 41)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(jTextFieldPropietario)
                                    .addComponent(jTextFieldInquilino)))
                            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jRadioButtonDia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonSemana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonMes)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jRadioButtonOtro)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jToggleButtonInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))))
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 59, Short.MAX_VALUE))
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFieldNombreSucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButtonDia)
                            .addComponent(jRadioButtonSemana)
                            .addComponent(jRadioButtonMes)
                            .addComponent(jRadioButtonOtro))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldRazonSocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE))
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jToggleButtonInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)))
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNIF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldPropietario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldComision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldInquilino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(jTextFieldDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel13)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setBackground(new java.awt.Color(153, 255, 255));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        jMenu1.setForeground(new java.awt.Color(0, 0, 0));
        jMenu1.setText("Opciones");

        jMenuItemGrabar.setText("Grabar");
        jMenuItemGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGrabarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGrabar);

        jMenuItemBorrar.setText("Borrar");
        jMenuItemBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemBorrarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemBorrar);
        jMenu1.add(jSeparator1);

        jMenuItemExportar.setText("Exportar");
        jMenuItemExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemExportarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemExportar);

        jMenuItemImportar.setText("Importar");
        jMenuItemImportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemImportarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemImportar);
        jMenu1.add(jSeparator2);

        jMenuItemSalir.setText("Salir");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setForeground(new java.awt.Color(0, 0, 0));
        jMenu2.setText("Colores");

        jMenuItemColoPanel.setText("Color Panel");
        jMenuItemColoPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemColoPanelActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemColoPanel);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemColoPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemColoPanelActionPerformed
        Color f = JColorChooser.showDialog(this, "Color de fondo", Color.yellow);
        jPanelPrincipal.setBackground(f);
    }//GEN-LAST:event_jMenuItemColoPanelActionPerformed

    private void jMenuItemImportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemImportarActionPerformed
        
        JFileChooser fc = new JFileChooser();
        
        int i = fc.showOpenDialog(this);
        
        if (i == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            try (FileReader lector = new FileReader(f)){
                String cadena ="";
                int valor = lector.read();
                while (valor != -1){
                    
                    cadena += (char)valor;
                    valor = lector.read();
                }
                modelo.addElement(cadena);
                jList1.setModel(modelo);
                lector.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_jMenuItemImportarActionPerformed

    private void jTextFieldComisionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldComisionFocusLost
        //Comprueba que el campo numérico está corecto
        validarCampoNumerico((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldComisionFocusLost

    private void jTextFieldPrecioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecioFocusLost
        //Comprueba que el campo numérico está corecto
        validarCampoNumerico((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldPrecioFocusLost

    private void jTextFieldDescuentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDescuentoFocusLost
        //Comprueba que el campo numérico está corecto
        validarCampoNumerico((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldDescuentoFocusLost

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        //Muestra un panel de despedida
        
        int elec = JOptionPane.showConfirmDialog(this, "¿Seguro que desea salir?");
        if (elec == JOptionPane.OK_OPTION){
            String mensaje = "Gracias por usar esta aplicación, vuelva pronto.";
            JOptionPane.showMessageDialog(this, mensaje);
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGrabarActionPerformed
        //Comprobamos si da algún problema en la creación de una operación nueva y se lo ,mostramos al usuario, de no ser así continúa el programa y lo añade a la lista
        try{
            String nombre = jTextFieldNombreSucursal.getText();
            String razonSocial = jTextFieldRazonSocial.getText();
            String nif = jTextFieldNIF.getText();
            float comision = Float.parseFloat(jTextFieldComision.getText());
            String tipo = "";

            if (jRadioButtonDia.isSelected()){
                tipo = "Dia";
            } else if (jRadioButtonMes.isSelected()){
                 tipo = "Mes";
            } else if (jRadioButtonSemana.isSelected()){
                 tipo = "Semana";
            } else if (jRadioButtonOtro.isSelected()){
                 tipo = "Otro";
            } else {
                tipo = "No seleccionado.";
            }

            String descripcion = jTextFieldDescripcion.getText();
            String empleado = jComboBox1.getItemAt(jComboBox1.getSelectedIndex());
            String propietario = jTextFieldPropietario.getText();
            String inquilino = jTextFieldInquilino.getText();
            String fecha = sdf.format((Date)jSpinner1.getValue());;
            int precio = Integer.parseInt(jTextFieldPrecio.getText());
            float descuento = Float.parseFloat(jTextFieldDescuento.getText());
            Operaciones o = new Operaciones(tipo, descripcion, empleado, propietario, inquilino, fecha, precio, descuento, nombre, razonSocial, nif, comision);
            
            modelo.addElement(o.toString());
            
            
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ha ocurrido un error, revise los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            
        } finally {
            vaciarCampos();
            jList1.setModel(modelo);
        }
    }//GEN-LAST:event_jMenuItemGrabarActionPerformed

    private void jMenuItemBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBorrarActionPerformed
        //Recogemos el numero de fila que está seleccionada y la eliminamos de la lista
        modelo.remove(jList1.getSelectedIndex());
        jList1.setModel(modelo);
    }//GEN-LAST:event_jMenuItemBorrarActionPerformed

    private void jTextFieldNombreSucursalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNombreSucursalFocusLost
        //Comprobamos si el campo está vacío y de no ser así lo mostramos al usuario.
        campoVacio((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldNombreSucursalFocusLost

    private void jTextFieldRazonSocialFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldRazonSocialFocusLost
        //Comprobamos si el campo está vacío y de no ser así lo mostramos al usuario.
        campoVacio((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldRazonSocialFocusLost

    private void jTextFieldNIFFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNIFFocusLost
        //Comprobamos si el campo está vacío y de no ser así lo mostramos al usuario.
        campoVacio((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldNIFFocusLost

    private void jTextFieldDescripcionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldDescripcionFocusLost
        //Comprobamos si el campo está vacío y de no ser así lo mostramos al usuario.
        campoVacio((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldDescripcionFocusLost

    private void jTextFieldPropietarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPropietarioFocusLost
        //Comprobamos si el campo está vacío y de no ser así lo mostramos al usuario.
        campoVacio((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldPropietarioFocusLost

    private void jTextFieldInquilinoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldInquilinoFocusLost
        //Comprobamos si el campo está vacío y de no ser así lo mostramos al usuario.
        campoVacio((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldInquilinoFocusLost

    private void jToggleButtonInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButtonInfoActionPerformed
        //Hacemos visible u ocultamos el jDialog según esté
        if (i.isVisible()){
            i.setVisible(false);
        } else {
            i.setVisible(true);
        }
    }//GEN-LAST:event_jToggleButtonInfoActionPerformed

    private void jMenuItemExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemExportarActionPerformed
        //Exportamos el modelo de la tabla a un archivo aparte
        JFileChooser fc = new JFileChooser();
        
        int i = fc.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            
            File f = fc.getSelectedFile();
            try (FileWriter fw = new FileWriter(f)){
                
                String pasar = "";
                for (int j = 0; j < (int) jList1.getModel().getSize(); j++){
                    pasar += jList1.getModel().getElementAt(j).toString() + "\n";
                }
                
                
                fw.write(pasar);
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
                                           
    }//GEN-LAST:event_jMenuItemExportarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }
    
    private void validarCampoNumerico(JTextField campo) {
        //Con este método comprobamos que lo campos númericos están correctos
        boolean correcto = true;
        try {
            Double.parseDouble(campo.getText());
            
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Error: Debe ingresar un número.", "Error", JOptionPane.ERROR_MESSAGE);
            campo.setText("");
            campo.setBackground(Color.RED);
            campo.requestFocus();
            correcto = false;
        }
        
        if (correcto){
            campo.setBackground(Color.white);
        }
        
    }
    private void campoVacio(JTextField campo){
        //Con este método comprobamos que no se dejan los campos vacíos
        if (campo.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Error: No puede dejar un campo vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            campo.setText("");
            campo.setBackground(Color.RED);
            campo.requestFocus();
            
        }
            
    }
    public void vaciarCampos(){
        //Vaciamos todos los campos
        jTextFieldComision.setText("");
        jTextFieldDescripcion.setText("");
        jTextFieldDescuento.setText("");
        jTextFieldInquilino.setText("");
        jTextFieldNIF.setText("");
        jTextFieldNombreSucursal.setText("");
        jTextFieldPrecio.setText("");
        jTextFieldPropietario.setText("");
        jTextFieldRazonSocial.setText("");
        buttonGroup1.clearSelection();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemBorrar;
    private javax.swing.JMenuItem jMenuItemColoPanel;
    private javax.swing.JMenuItem jMenuItemExportar;
    private javax.swing.JMenuItem jMenuItemGrabar;
    private javax.swing.JMenuItem jMenuItemImportar;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JRadioButton jRadioButtonDia;
    private javax.swing.JRadioButton jRadioButtonMes;
    private javax.swing.JRadioButton jRadioButtonOtro;
    private javax.swing.JRadioButton jRadioButtonSemana;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextFieldComision;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldDescuento;
    private javax.swing.JTextField jTextFieldInquilino;
    private javax.swing.JTextField jTextFieldNIF;
    private javax.swing.JTextField jTextFieldNombreSucursal;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldPropietario;
    private javax.swing.JTextField jTextFieldRazonSocial;
    private javax.swing.JToggleButton jToggleButtonInfo;
    // End of variables declaration//GEN-END:variables
}
