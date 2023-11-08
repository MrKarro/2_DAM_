/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.ejercicio07_herencia_jtable;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author 6002755
 */
public class Formulario extends javax.swing.JDialog {

    /**
     * Creates new form Formulario
     */
    public Formulario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        jButtonEnviar.setIcon(new ImageIcon("guardar.png"));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelProyecto = new javax.swing.JLabel();
        jLabelCodigo = new javax.swing.JLabel();
        jLabelDescripcion = new javax.swing.JLabel();
        jLabelNumHoras = new javax.swing.JLabel();
        jTextFieldCodigo = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jTextFieldNumHoras = new javax.swing.JTextField();
        jLabelEmpleado = new javax.swing.JLabel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelPrecioHora = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldPrecioHora = new javax.swing.JTextField();
        jButtonEnviar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Añadir empleado");

        jLabelProyecto.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabelProyecto.setText("Proyecto:");

        jLabelCodigo.setText("Código:");

        jLabelDescripcion.setText("Descripción:");

        jLabelNumHoras.setText("Número de horas:");

        jTextFieldNumHoras.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldNumHorasFocusLost(evt);
            }
        });

        jLabelEmpleado.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabelEmpleado.setText("Empleado:");

        jLabelNombre.setText("Nombre:");

        jLabelPrecioHora.setText("Precio por hora:");

        jTextFieldPrecioHora.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextFieldPrecioHoraFocusLost(evt);
            }
        });

        jButtonEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabelCodigo))
                    .addComponent(jLabelProyecto)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabelNumHoras)
                        .addComponent(jLabelDescripcion)
                        .addComponent(jLabelPrecioHora)
                        .addComponent(jLabelNombre))
                    .addComponent(jLabelEmpleado))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldCodigo)
                    .addComponent(jTextFieldDescripcion)
                    .addComponent(jTextFieldNumHoras)
                    .addComponent(jTextFieldNombre)
                    .addComponent(jTextFieldPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelProyecto)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCodigo)
                    .addComponent(jTextFieldCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDescripcion)
                    .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelNumHoras)
                    .addComponent(jTextFieldNumHoras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabelEmpleado)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelNombre)
                            .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPrecioHora)
                            .addComponent(jTextFieldPrecioHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEnviarActionPerformed
        try{
        String nombre = jTextFieldNombre.getText();
        float precioHora = Float.parseFloat(jTextFieldPrecioHora.getText());
        String codigo = jTextFieldCodigo.getText();
        String descr = jTextFieldDescripcion.getText();
        int numHoras = Integer.parseInt(jTextFieldNumHoras.getText());
        if (jTextFieldNombre.getText().isEmpty() || jTextFieldCodigo.getText().isEmpty() || jTextFieldDescripcion.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Ha habido un error de entrada de datos.");
            return;
        }
        
        
        Empleado e = new Empleado(nombre, precioHora, codigo, descr, numHoras);
        Ventana.anadeEmpleado(e);
        
        
        this.setVisible(false);
        } catch (Exception e){
            JOptionPane.showMessageDialog(this, "Ha habido un error de entrada de datos.");
            return;
        }
        
        
    }//GEN-LAST:event_jButtonEnviarActionPerformed

    private void jTextFieldNumHorasFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldNumHorasFocusLost
        validarCampoNumerico((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldNumHorasFocusLost

    private void jTextFieldPrecioHoraFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextFieldPrecioHoraFocusLost
        validarCampoNumerico((JTextField)evt.getComponent());
    }//GEN-LAST:event_jTextFieldPrecioHoraFocusLost

    
    private void validarCampoNumerico(JTextField campo) {
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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Formulario dialog = new Formulario(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonEnviar;
    private javax.swing.JLabel jLabelCodigo;
    private javax.swing.JLabel jLabelDescripcion;
    private javax.swing.JLabel jLabelEmpleado;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumHoras;
    private javax.swing.JLabel jLabelPrecioHora;
    private javax.swing.JLabel jLabelProyecto;
    private javax.swing.JTextField jTextFieldCodigo;
    private javax.swing.JTextField jTextFieldDescripcion;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumHoras;
    private javax.swing.JTextField jTextFieldPrecioHora;
    // End of variables declaration//GEN-END:variables
}
