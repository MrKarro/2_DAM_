/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.practicamenus;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 6002755
 */
public class VentanaTabla extends javax.swing.JFrame {

    /**
     * Creates new form VentanaTabla
     */
    public VentanaTabla() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemNuevo = new javax.swing.JMenuItem();
        jMenuItemEliminar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemColorTabla = new javax.swing.JMenuItem();
        jMenuItemColorTexto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tabla de clientes");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellidos", "Fecha", "Provincia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("Clientes");

        jMenuItemNuevo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemNuevo.setText("Nuevo cliente");
        jMenuItemNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemNuevo);

        jMenuItemEliminar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItemEliminar.setText("Eliminar cliente");
        jMenuItemEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemEliminarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemEliminar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Colores");

        jMenuItemColorTabla.setText("Color tabla");
        jMenuItemColorTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemColorTablaActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemColorTabla);

        jMenuItemColorTexto.setText("Color texto");
        jMenuItemColorTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemColorTextoActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemColorTexto);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Lanzamos el nuevo formulario para crear clientes y añadirlos a la tabla.
    private void jMenuItemNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemNuevoActionPerformed
        // TODO add your handling code here:
        FormularioCliente f = new FormularioCliente(this, true);
        f.setVisible(true);
        
    }//GEN-LAST:event_jMenuItemNuevoActionPerformed

    //Con este método recogemos la fila seleccionada de la tabla y eliminamos la entrada de la tabla.
    private void jMenuItemEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemEliminarActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        int borrar = jTable1.getSelectedRow();
        
        
        if (borrar < 0)
            JOptionPane.showMessageDialog(null, "Debe seleccionar una fila de la tabla");
        else {
            int confirmar = JOptionPane.showConfirmDialog(null, "¿Está seguro de que quiere eliminar la fila?");
            if (JOptionPane.OK_OPTION == confirmar)
                modelo.removeRow(borrar);
        }
    }//GEN-LAST:event_jMenuItemEliminarActionPerformed
    //Con este método mostramos una selección de color para el fondo de la tabla.
    private void jMenuItemColorTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemColorTablaActionPerformed
        // TODO add your handling code here:
        Color f = JColorChooser.showDialog(this, "Color de fondo", Color.yellow);
        jTable1.setBackground(f);
    }//GEN-LAST:event_jMenuItemColorTablaActionPerformed

    //Con este método mostramos una selección de color para el texto de la tabla.
    private void jMenuItemColorTextoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemColorTextoActionPerformed
        // TODO add your handling code here:
        Color f = JColorChooser.showDialog(this, "Color de fondo", Color.yellow);
        jTable1.setForeground(f);
    }//GEN-LAST:event_jMenuItemColorTextoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaTabla.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaTabla().setVisible(true);
            }
        });
    }
    public static void nuevaAlta(Object[] fila){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.addRow(fila);
    }
    public static void nuevaAlta(Cliente c){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.addRow(c.aTabla());
    }
    public void coloreaFondo(Color c){
        setBackground(c);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItemColorTabla;
    private javax.swing.JMenuItem jMenuItemColorTexto;
    private javax.swing.JMenuItem jMenuItemEliminar;
    private javax.swing.JMenuItem jMenuItemNuevo;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
