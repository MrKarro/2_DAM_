/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.pruebatabla;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 6002755
 */
public class Tabla extends javax.swing.JFrame {

    /**
     * Creates new form Tabla
     */
    public Tabla() {
        initComponents();
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
        jLabel_Nombre = new javax.swing.JLabel();
        jTextField_Nombre = new javax.swing.JTextField();
        jLabel_Apellidos = new javax.swing.JLabel();
        jTextField_Apellidos = new javax.swing.JTextField();
        jLabel_Telefono = new javax.swing.JLabel();
        jTextField_Telefono = new javax.swing.JTextField();
        jLabel_Edad = new javax.swing.JLabel();
        jTextField_Edad = new javax.swing.JTextField();
        jLabel_Matriculado = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton_anadir = new javax.swing.JButton();
        jButton_borrar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton_sup = new javax.swing.JButton();
        jButton_tab = new javax.swing.JButton();
        jButton_inf = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Alumnos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_Nombre.setText("Nombre:");

        jTextField_Nombre.setToolTipText("");

        jLabel_Apellidos.setText("Apellidos:");

        jLabel_Telefono.setText("Teléfono:");

        jTextField_Telefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_TelefonoActionPerformed(evt);
            }
        });

        jLabel_Edad.setText("Edad:");

        jLabel_Matriculado.setText("Matriculado:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Si", "No" }));

        jButton_anadir.setText("Añadir");
        jButton_anadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_anadirActionPerformed(evt);
            }
        });

        jButton_borrar.setText("Borrar");
        jButton_borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_borrarActionPerformed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton_sup.setText("Superior");
        jButton_sup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_supActionPerformed(evt);
            }
        });

        jButton_tab.setText("Tabla");
        jButton_tab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_tabActionPerformed(evt);
            }
        });

        jButton_inf.setText("Inferior");
        jButton_inf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_infActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel_Nombre)
                                .addGap(95, 95, 95)
                                .addComponent(jLabel_Apellidos)
                                .addGap(138, 138, 138)
                                .addComponent(jLabel_Telefono)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel_Edad)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel_Matriculado)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton_anadir)
                        .addGap(18, 18, 18)
                        .addComponent(jButton_borrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_sup)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_tab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_inf)
                        .addGap(66, 66, 66)
                        .addComponent(jButton1)
                        .addGap(23, 23, 23))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel_Nombre)
                    .addComponent(jLabel_Apellidos)
                    .addComponent(jLabel_Telefono)
                    .addComponent(jLabel_Edad)
                    .addComponent(jLabel_Matriculado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField_Edad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_anadir)
                    .addComponent(jButton_borrar)
                    .addComponent(jButton1)
                    .addComponent(jButton_sup)
                    .addComponent(jButton_tab)
                    .addComponent(jButton_inf))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTable_Alumnos.setAutoCreateRowSorter(true);
        jTable_Alumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NOMBRE", "APELLIDOS", "TELÉFONO", "EDAD", "MATRICULADO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable_Alumnos);
        if (jTable_Alumnos.getColumnModel().getColumnCount() > 0) {
            jTable_Alumnos.getColumnModel().getColumn(0).setResizable(false);
            jTable_Alumnos.getColumnModel().getColumn(1).setResizable(false);
            jTable_Alumnos.getColumnModel().getColumn(2).setResizable(false);
            jTable_Alumnos.getColumnModel().getColumn(3).setResizable(false);
            jTable_Alumnos.getColumnModel().getColumn(4).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("jFrame1");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_TelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_TelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_TelefonoActionPerformed

    private void jButton_anadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_anadirActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable_Alumnos.getModel();
        if (!jTextField_Nombre.getText().isEmpty() || !jTextField_Apellidos.getText().isEmpty() || !jTextField_Telefono.getText().isEmpty() || !jTextField_Edad.getText().isEmpty()){
        Object[] fila = new Object[5];
        fila[0] = jTextField_Nombre.getText();
        fila[1] = jTextField_Apellidos.getText();
        fila[2] = jTextField_Telefono.getText();
        fila[3] = jTextField_Edad.getText();
        fila[4] = jComboBox1.getSelectedItem();
        modelo.addRow(fila);
        }
    }//GEN-LAST:event_jButton_anadirActionPerformed

    private void jButton_borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_borrarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable_Alumnos.getModel();
        int borrar = jTable_Alumnos.getSelectedRow();
        
        
        if (borrar < 0)
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        else {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar la fila?");
            if (JOptionPane.OK_OPTION == confirmar)
                modelo.removeRow(borrar);
        }
        
    }//GEN-LAST:event_jButton_borrarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_supActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_supActionPerformed
        // TODO add your handling code here:
        Color f = JColorChooser.showDialog(this, "Color de fondo", Color.yellow);
        jPanel1.setBackground(f);
        
       
               
    }//GEN-LAST:event_jButton_supActionPerformed

    private void jButton_tabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_tabActionPerformed
        // TODO add your handling code here:
        Color f = JColorChooser.showDialog(this, "Color de fondo", Color.yellow);
        jTable_Alumnos.setBackground(f);
    }//GEN-LAST:event_jButton_tabActionPerformed

    private void jButton_infActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_infActionPerformed
        // TODO add your handling code here:
        Color f = JColorChooser.showDialog(this, "Color de fondo", Color.yellow);
        jPanel2.setBackground(f);
    }//GEN-LAST:event_jButton_infActionPerformed

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
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tabla().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_anadir;
    private javax.swing.JButton jButton_borrar;
    private javax.swing.JButton jButton_inf;
    private javax.swing.JButton jButton_sup;
    private javax.swing.JButton jButton_tab;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel_Apellidos;
    private javax.swing.JLabel jLabel_Edad;
    private javax.swing.JLabel jLabel_Matriculado;
    private javax.swing.JLabel jLabel_Nombre;
    private javax.swing.JLabel jLabel_Telefono;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_Alumnos;
    private javax.swing.JTextField jTextField_Apellidos;
    private javax.swing.JTextField jTextField_Edad;
    private javax.swing.JTextField jTextField_Nombre;
    private javax.swing.JTextField jTextField_Telefono;
    // End of variables declaration//GEN-END:variables
}
