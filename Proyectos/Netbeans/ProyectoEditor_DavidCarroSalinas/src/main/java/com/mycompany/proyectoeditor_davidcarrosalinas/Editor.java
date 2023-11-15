/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.proyectoeditor_davidcarrosalinas;



import java.awt.Image;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author 6002755
 */
public class Editor extends javax.swing.JFrame {

    /**
     * Creates new form Editor
     */
    
    String buffer;
    public Editor() {
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

        jButtonNegrita = new javax.swing.JButton();
        jButtonCursiva = new javax.swing.JButton();
        jButtonSubrayado = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemAbrir = new javax.swing.JMenuItem();
        jMenuItemGuardar = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItemLimpiar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItemCopiar = new javax.swing.JMenuItem();
        jMenuItemCortar = new javax.swing.JMenuItem();
        jMenuItemPegar = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItemMonospaced = new javax.swing.JMenuItem();
        jMenuItemSerif = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem26 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItemSalir = new javax.swing.JMenuItem();
        jMenuItemAutor = new javax.swing.JMenuItem();
        jMenuItemInstituto = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Editor de texto");
        setResizable(false);

        jButtonNegrita.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButtonNegrita.setText("Negrita");
        jButtonNegrita.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 0, 255)));
        jButtonNegrita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNegritaActionPerformed(evt);
            }
        });

        jButtonCursiva.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        jButtonCursiva.setText("Cursiva");
        jButtonCursiva.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 51)));
        jButtonCursiva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCursivaActionPerformed(evt);
            }
        });

        jButtonSubrayado.setText("Subrayado");
        jButtonSubrayado.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(0, 255, 0)));
        jButtonSubrayado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubrayadoActionPerformed(evt);
            }
        });

        jTextPane1.setBackground(new java.awt.Color(255, 255, 204));
        jTextPane1.setContentType("text/html"); // NOI18N
        jScrollPane2.setViewportView(jTextPane1);

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 102));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createCompoundBorder(null, javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1)));

        jMenu1.setText("Archivo");

        jMenuItemAbrir.setIcon(new ImageIcon("./imagenes/abrir.png"));
        jMenuItemAbrir.setText("Abrir archivo");
        jMenuItemAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemAbrir);

        jMenuItemGuardar.setIcon(new ImageIcon("./imagenes/guardar.png"));
        jMenuItemGuardar.setText("Guardar archivo");
        jMenuItemGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGuardar);
        jMenu1.add(jSeparator1);

        jMenuItemLimpiar.setText("Limpiar texto");
        jMenuItemLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemLimpiarActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemLimpiar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edicion");

        jMenuItemCopiar.setIcon(new ImageIcon("./imagenes/copiar.png"));
        jMenuItemCopiar.setText("Copiar");
        jMenuItemCopiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCopiarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCopiar);

        jMenuItemCortar.setIcon(new ImageIcon("./imagenes/cortar.png"));
        jMenuItemCortar.setText("Cortar");
        jMenuItemCortar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemCortarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemCortar);

        jMenuItemPegar.setIcon(new ImageIcon("./imagenes/pegar.png"));
        jMenuItemPegar.setText("Pegar");
        jMenuItemPegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemPegarActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItemPegar);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Fuente");

        jMenuItemMonospaced.setText("Monospaced");
        jMenuItemMonospaced.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemMonospacedActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemMonospaced);

        jMenuItemSerif.setText("Serif");
        jMenuItemSerif.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSerifActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItemSerif);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Tamaño");

        jMenuItem14.setText("14");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem18.setText("18");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem18);

        jMenuItem20.setText("20");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem20);

        jMenuItem26.setText("26");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem26);

        jMenuBar1.add(jMenu4);

        jMenu5.setText("Opciones");

        jMenuItemSalir.setText("Salir del programa");
        jMenuItemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemSalirActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemSalir);

        jMenuItemAutor.setText("Autor");
        jMenuItemAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemAutorActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemAutor);

        jMenuItemInstituto.setText("Instituto");
        jMenuItemInstituto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemInstitutoActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItemInstituto);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 8, Short.MAX_VALUE)
                        .addComponent(jButtonNegrita, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCursiva, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonSubrayado, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNegrita)
                    .addComponent(jButtonCursiva)
                    .addComponent(jButtonSubrayado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 299, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNegritaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNegritaActionPerformed
        
        int selectionStart = jTextPane1.getSelectionStart();
        
        
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setBold(asNew, !StyleConstants.isBold(as));
        doc.setCharacterAttributes(selectionStart, jTextPane1.getSelectedText().length(), asNew, true);
        
    }//GEN-LAST:event_jButtonNegritaActionPerformed

    private void jButtonCursivaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCursivaActionPerformed
        int selectionStart = jTextPane1.getSelectionStart();
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setItalic(asNew, !StyleConstants.isItalic(as));
        doc.setCharacterAttributes(selectionStart, jTextPane1.getSelectedText().length(), asNew, true);
    }//GEN-LAST:event_jButtonCursivaActionPerformed

    private void jButtonSubrayadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubrayadoActionPerformed
        int selectionStart = jTextPane1.getSelectionStart();
        
        
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setUnderline(asNew, !StyleConstants.isUnderline(as));
        doc.setCharacterAttributes(selectionStart, jTextPane1.getSelectedText().length(), asNew, true);
    }//GEN-LAST:event_jButtonSubrayadoActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        int selectionStart = jTextPane1.getSelectionStart();
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setFontSize(asNew, 14);
        doc.setCharacterAttributes(selectionStart, jTextPane1.getSelectedText().length(), asNew, true);
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        int selectionStart = jTextPane1.getSelectionStart();
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setFontSize(asNew, 18);
        doc.setCharacterAttributes(selectionStart, jTextPane1.getSelectedText().length(), asNew, true);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        int selectionStart = jTextPane1.getSelectionStart();
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setFontSize(asNew, 20);
        doc.setCharacterAttributes(selectionStart, jTextPane1.getSelectedText().length(), asNew, true);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        int selectionStart = jTextPane1.getSelectionStart();
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setFontSize(asNew, 26);
        doc.setCharacterAttributes(selectionStart, jTextPane1.getSelectedText().length(), asNew, true);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItemMonospacedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemMonospacedActionPerformed
        int selectionStart = jTextPane1.getSelectionStart();
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setFontFamily(asNew, "monospaced");
        doc.setCharacterAttributes(selectionStart, jTextPane1.getSelectedText().length(), asNew, true);
    }//GEN-LAST:event_jMenuItemMonospacedActionPerformed

    private void jMenuItemSerifActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSerifActionPerformed
        int selectionStart = jTextPane1.getSelectionStart();
        StyledDocument doc = (StyledDocument) jTextPane1.getDocument();
        Element element = doc.getCharacterElement(selectionStart);
        AttributeSet as = element.getAttributes();
        MutableAttributeSet asNew = new SimpleAttributeSet(as.copyAttributes());
        StyleConstants.setFontFamily(asNew, "serif");
        doc.setCharacterAttributes(selectionStart, jTextPane1.getSelectedText().length(), asNew, true);
    }//GEN-LAST:event_jMenuItemSerifActionPerformed

    private void jMenuItemAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAbrirActionPerformed
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
                jTextPane1.setText(cadena);
                lector.close();
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_jMenuItemAbrirActionPerformed

    private void jMenuItemGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGuardarActionPerformed
        JFileChooser fc = new JFileChooser();
        
        int i = fc.showOpenDialog(this);
        if (i == JFileChooser.APPROVE_OPTION) {
            
            File f = fc.getSelectedFile();
            try (FileWriter fw = new FileWriter(f)){
                fw.write(jTextPane1.getText());
            } catch (IOException ex) {
                Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }//GEN-LAST:event_jMenuItemGuardarActionPerformed

    private void jMenuItemLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemLimpiarActionPerformed
        jTextPane1.setText("");
    }//GEN-LAST:event_jMenuItemLimpiarActionPerformed

    private void jMenuItemCopiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCopiarActionPerformed
        jTextPane1.copy();
    }//GEN-LAST:event_jMenuItemCopiarActionPerformed

    private void jMenuItemCortarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemCortarActionPerformed
        jTextPane1.cut();
        
        
    }//GEN-LAST:event_jMenuItemCortarActionPerformed

    private void jMenuItemPegarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemPegarActionPerformed
        jTextPane1.paste();
    }//GEN-LAST:event_jMenuItemPegarActionPerformed

    private void jMenuItemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSalirActionPerformed
        String mensaje = "Gracias por usar esta aplicación, vuelva pronto.";
        JOptionPane.showMessageDialog(this, mensaje);
        System.exit(0);
    }//GEN-LAST:event_jMenuItemSalirActionPerformed

    private void jMenuItemAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemAutorActionPerformed
        String mensaje = "Esta aplicación ha sido creada por\nDavid Carro Salinas\nAlumno del Ciclo Superior de \nDesarrollo de Aplicaciones Multiplataforma";
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_jMenuItemAutorActionPerformed

    private void jMenuItemInstitutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemInstitutoActionPerformed
        String mensaje = "I.E.S. Venancio Blanco\nC/Filipinas, 33, 37003\nSalamanca\nwww.iesvenancioblanco.es";
        JOptionPane.showMessageDialog(this, mensaje);
    }//GEN-LAST:event_jMenuItemInstitutoActionPerformed

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
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Editor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Editor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCursiva;
    private javax.swing.JButton jButtonNegrita;
    private javax.swing.JButton jButtonSubrayado;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItemAbrir;
    private javax.swing.JMenuItem jMenuItemAutor;
    private javax.swing.JMenuItem jMenuItemCopiar;
    private javax.swing.JMenuItem jMenuItemCortar;
    private javax.swing.JMenuItem jMenuItemGuardar;
    private javax.swing.JMenuItem jMenuItemInstituto;
    private javax.swing.JMenuItem jMenuItemLimpiar;
    private javax.swing.JMenuItem jMenuItemMonospaced;
    private javax.swing.JMenuItem jMenuItemPegar;
    private javax.swing.JMenuItem jMenuItemSalir;
    private javax.swing.JMenuItem jMenuItemSerif;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
