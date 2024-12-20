/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelos.Jugador;

/**
 *
 * @author Maria
 */
public class ABMJugadores extends javax.swing.JFrame {
    /**
     * Creates new form gameplay
     */
    public ABMJugadores() {
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "Proyecto/src/imagenes/codigo.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconAdmin, "Proyecto/src/imagenes/admin.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconEdit, "Proyecto/src/imagenes/lapiz.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconDelete, "Proyecto/src/imagenes/basura.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondoJugadores, "Proyecto/src/imagenes/verde.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelBack, "Proyecto/src/imagenes/back.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldJugadores = new javax.swing.JTextField();
        jTextFieldJugadores2 = new javax.swing.JTextField();
        jComboBoxJugadores = new javax.swing.JComboBox<>();
        jTextFieldEditarJugador = new javax.swing.JTextField();
        jLabelIconEdit = new javax.swing.JLabel();
        jLabelIconDelete = new javax.swing.JLabel();
        jButtonEliminar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jLabelFondoJugadores = new javax.swing.JLabel();
        jButtonAgregarJugador = new javax.swing.JButton();
        jLabelBack = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabelIconAdmin = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldJugadores.setEditable(false);
        jTextFieldJugadores.setBackground(new java.awt.Color(51, 153, 0));
        jTextFieldJugadores.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
        jTextFieldJugadores.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadores.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadores.setText("JUGADORES");
        jPanel1.add(jTextFieldJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 310, 70));

        jTextFieldJugadores2.setEditable(false);
        jTextFieldJugadores2.setBackground(new java.awt.Color(51, 153, 0));
        jTextFieldJugadores2.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldJugadores2.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadores2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadores2.setText("Jugadores");
        jPanel1.add(jTextFieldJugadores2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 120, 60));

        jComboBoxJugadores.setBackground(new java.awt.Color(51, 153, 0));
        jComboBoxJugadores.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJugadores.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJugadores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJugadoresActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, 160, 60));

        jTextFieldEditarJugador.setBackground(new java.awt.Color(0, 102, 0));
        jTextFieldEditarJugador.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldEditarJugador.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldEditarJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextFieldEditarJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 290, 40));
        jPanel1.add(jLabelIconEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 60, 50));
        jPanel1.add(jLabelIconDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 60, 50));

        jButtonEliminar.setBackground(new java.awt.Color(0, 102, 0));
        jButtonEliminar.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 80, 70));

        jButtonEditar.setBackground(new java.awt.Color(0, 102, 0));
        jButtonEditar.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jButtonEditar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 80, 70));
        jPanel1.add(jLabelFondoJugadores, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 310, 130));

        jButtonAgregarJugador.setBackground(new java.awt.Color(0, 102, 0));
        jButtonAgregarJugador.setFont(new java.awt.Font("Roboto Medium", 0, 70)); // NOI18N
        jButtonAgregarJugador.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarJugador.setText("+");
        jButtonAgregarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarJugadorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 80, 70));
        jPanel1.add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, 30));

        jButtonBack.setBackground(new java.awt.Color(0, 102, 0));
        jButtonBack.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 50));

        jPanel1.add(jLabelIconAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 110, 100));
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonEditarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonAgregarJugadorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonAgregarJugadorActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonAgregarJugadorActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonBackActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonBackActionPerformed

    private void jComboBoxJugadoresActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJugadoresActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJugadoresActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ABMJugadores.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABMJugadores.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABMJugadores.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABMJugadores.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABMJugadores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonAgregarJugador;
    public javax.swing.JButton jButtonBack;
    public javax.swing.JButton jButtonEditar;
    public javax.swing.JButton jButtonEliminar;
    public javax.swing.JComboBox<Jugador> jComboBoxJugadores;
    public javax.swing.JLabel jLabelBack;
    public javax.swing.JLabel jLabelFondo;
    public javax.swing.JLabel jLabelFondoJugadores;
    public javax.swing.JLabel jLabelIconAdmin;
    public javax.swing.JLabel jLabelIconDelete;
    public javax.swing.JLabel jLabelIconEdit;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextFieldEditarJugador;
    public javax.swing.JTextField jTextFieldJugadores;
    public javax.swing.JTextField jTextFieldJugadores2;
    // End of variables declaration//GEN-END:variables
}
