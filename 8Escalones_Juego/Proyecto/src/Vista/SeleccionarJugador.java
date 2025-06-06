/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import java.awt.event.ActionListener;

/**
 *
 * @author Maria
 */
public class SeleccionarJugador extends javax.swing.JFrame {

    /**
     * Creates new form gameplay
     */
    public SeleccionarJugador() {
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "Proyecto/src/imagenes/violeta.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo2, "Proyecto/src/imagenes/violeta.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelBack, "Proyecto/src/imagenes/back.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelJugar, "Proyecto/src/imagenes/derecha.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUser1, "Proyecto/src/imagenes/IconUser1.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUser2, "Proyecto/src/imagenes/IconUser2.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUser3, "Proyecto/src/imagenes/IconUser3.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUser4, "Proyecto/src/imagenes/IconUser4.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUser5, "Proyecto/src/imagenes/IconUser5.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUser6, "Proyecto/src/imagenes/IconUser6.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUser7, "Proyecto/src/imagenes/IconUser7.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUser8, "Proyecto/src/imagenes/IconUser8.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelUser9, "Proyecto/src/imagenes/IconUser9.png");
        // new ControladorSeleccionarJugadores(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jLabelJugar = new javax.swing.JLabel();
        jLabelBack = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jButtonJugar = new javax.swing.JButton();
        jButtonBack = new javax.swing.JButton();
        jLabelUser1 = new javax.swing.JLabel();
        jLabelUser2 = new javax.swing.JLabel();
        jLabelUser3 = new javax.swing.JLabel();
        jLabelUser4 = new javax.swing.JLabel();
        jLabelUser5 = new javax.swing.JLabel();
        jLabelUser6 = new javax.swing.JLabel();
        jLabelUser7 = new javax.swing.JLabel();
        jLabelUser8 = new javax.swing.JLabel();
        jLabelUser9 = new javax.swing.JLabel();
        jTextFieldSeleccionarJugador = new javax.swing.JTextField();
        jComboBoxJ1 = new javax.swing.JComboBox<>();
        jComboBoxJ2 = new javax.swing.JComboBox<>();
        jComboBoxJ3 = new javax.swing.JComboBox<>();
        jComboBoxJ4 = new javax.swing.JComboBox<>();
        jComboBoxJ5 = new javax.swing.JComboBox<>();
        jComboBoxJ6 = new javax.swing.JComboBox<>();
        jComboBoxJ7 = new javax.swing.JComboBox<>();
        jComboBoxJ8 = new javax.swing.JComboBox<>();
        jComboBoxJ9 = new javax.swing.JComboBox<>();
        jLabelFondo2 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 30, 20));
        jPanel1.add(jLabelJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 30, 20));
        jPanel1.add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 20));

        jButtonExit.setBackground(new java.awt.Color(102, 0, 102));
        jButtonExit.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 50, 40));

        jButtonJugar.setBackground(new java.awt.Color(102, 0, 102));
        jButtonJugar.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonJugar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonJugarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 50, 40));

        jButtonBack.setBackground(new java.awt.Color(102, 0, 102));
        jButtonBack.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));
        jPanel1.add(jLabelUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 120, 120));
        jPanel1.add(jLabelUser2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 120, 120));
        jPanel1.add(jLabelUser3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 120, 120));
        jPanel1.add(jLabelUser4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 120, 110));
        jPanel1.add(jLabelUser5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 120, 110));
        jPanel1.add(jLabelUser6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 280, 120, 110));
        jPanel1.add(jLabelUser7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 450, 120, 110));
        jPanel1.add(jLabelUser8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 120, 110));
        jPanel1.add(jLabelUser9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 450, 120, 110));

        jTextFieldSeleccionarJugador.setEditable(false);
        jTextFieldSeleccionarJugador.setBackground(new java.awt.Color(102, 0, 102));
        jTextFieldSeleccionarJugador.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldSeleccionarJugador.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldSeleccionarJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldSeleccionarJugador.setText("SELECCIONAR JUGADORES");
        jTextFieldSeleccionarJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSeleccionarJugadorActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldSeleccionarJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 270, 40));

        jComboBoxJ1.setBackground(new java.awt.Color(102, 0, 102));
        jComboBoxJ1.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJ1.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJ1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJ2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 120, -1));

        jComboBoxJ2.setBackground(new java.awt.Color(102, 0, 102));
        jComboBoxJ2.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJ2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJ2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJ2ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 120, -1));

        jComboBoxJ3.setBackground(new java.awt.Color(102, 0, 102));
        jComboBoxJ3.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJ3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJ3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJ3ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJ3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 120, -1));

        jComboBoxJ4.setBackground(new java.awt.Color(102, 0, 102));
        jComboBoxJ4.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJ4.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJ4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJ4ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJ4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 120, -1));

        jComboBoxJ5.setBackground(new java.awt.Color(102, 0, 102));
        jComboBoxJ5.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJ5.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJ5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJ5ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJ5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 250, 120, -1));

        jComboBoxJ6.setBackground(new java.awt.Color(102, 0, 102));
        jComboBoxJ6.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJ6.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJ6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJ6ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJ6, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 250, 120, -1));

        jComboBoxJ7.setBackground(new java.awt.Color(102, 0, 102));
        jComboBoxJ7.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJ7.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJ7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJ7ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJ7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 120, -1));

        jComboBoxJ8.setBackground(new java.awt.Color(102, 0, 102));
        jComboBoxJ8.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJ8.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJ8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJ8ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJ8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 120, -1));

        jComboBoxJ9.setBackground(new java.awt.Color(102, 0, 102));
        jComboBoxJ9.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxJ9.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxJ9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxJ9ActionPerformed(evt);
            }
        });
        jPanel1.add(jComboBoxJ9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 420, 120, -1));
        jPanel1.add(jLabelFondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 540, 520));

        jLabelFondo.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 590));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
                                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonExitActionPerformed
    }// GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonJugarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonJugarActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButtonJugarActionPerformed

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonBackActionPerformed
    }// GEN-LAST:event_jButtonBackActionPerformed

    private void jTextFieldSeleccionarJugadorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jTextFieldSeleccionarJugadorActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jTextFieldSeleccionarJugadorActionPerformed

    private void jComboBoxJ1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJ1ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJ1ActionPerformed

    private void jComboBoxJ2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJ2ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJ2ActionPerformed

    private void jComboBoxJ3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJ3ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJ3ActionPerformed

    private void jComboBoxJ4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJ4ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJ4ActionPerformed

    private void jComboBoxJ5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJ5ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJ5ActionPerformed

    private void jComboBoxJ6ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJ6ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJ6ActionPerformed

    private void jComboBoxJ7ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJ7ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJ7ActionPerformed

    private void jComboBoxJ8ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJ8ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJ8ActionPerformed

    private void jComboBoxJ9ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboBoxJ9ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboBoxJ9ActionPerformed

    public void listenerJ1(ActionListener listener) {
        jComboBoxJ1.addActionListener(listener);
    }

    public void listenerJ2(ActionListener listener) {
        jComboBoxJ2.addActionListener(listener);
    }

    public void listenerJ3(ActionListener listener) {
        jComboBoxJ3.addActionListener(listener);
    }

    public void listenerJ4(ActionListener listener) {
        jComboBoxJ4.addActionListener(listener);
    }

    public void listenerJ5(ActionListener listener) {
        jComboBoxJ5.addActionListener(listener);
    }

    public void listenerJ6(ActionListener listener) {
        jComboBoxJ6.addActionListener(listener);
    }

    public void listenerJ7(ActionListener listener) {
        jComboBoxJ7.addActionListener(listener);
    }

    public void listenerJ8(ActionListener listener) {
        jComboBoxJ8.addActionListener(listener);
    }

    public void listenerJ9(ActionListener listener) {
        jComboBoxJ9.addActionListener(listener);
    }

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
            java.util.logging.Logger.getLogger(SeleccionarJugador.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionarJugador.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionarJugador.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionarJugador.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
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
                new SeleccionarJugador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonBack;
    public javax.swing.JButton jButtonExit;
    public javax.swing.JButton jButtonJugar;
    public javax.swing.JComboBox<String> jComboBoxJ1;
    public javax.swing.JComboBox<String> jComboBoxJ2;
    public javax.swing.JComboBox<String> jComboBoxJ3;
    public javax.swing.JComboBox<String> jComboBoxJ4;
    public javax.swing.JComboBox<String> jComboBoxJ5;
    public javax.swing.JComboBox<String> jComboBoxJ6;
    public javax.swing.JComboBox<String> jComboBoxJ7;
    public javax.swing.JComboBox<String> jComboBoxJ8;
    public javax.swing.JComboBox<String> jComboBoxJ9;
    public javax.swing.JLabel jLabelBack;
    public javax.swing.JLabel jLabelExit;
    public javax.swing.JLabel jLabelFondo;
    public javax.swing.JLabel jLabelFondo2;
    public javax.swing.JLabel jLabelJugar;
    public javax.swing.JLabel jLabelUser1;
    public javax.swing.JLabel jLabelUser2;
    public javax.swing.JLabel jLabelUser3;
    public javax.swing.JLabel jLabelUser4;
    public javax.swing.JLabel jLabelUser5;
    public javax.swing.JLabel jLabelUser6;
    public javax.swing.JLabel jLabelUser7;
    public javax.swing.JLabel jLabelUser8;
    public javax.swing.JLabel jLabelUser9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextFieldSeleccionarJugador;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JComboBox<String> getComboBoxJ1() {
        return jComboBoxJ1;
    }

    public javax.swing.JComboBox<String> getComboBoxJ2() {
        return jComboBoxJ2;
    }

    public javax.swing.JComboBox<String> getComboBoxJ3() {
        return jComboBoxJ3;
    }

    public javax.swing.JComboBox<String> getComboBoxJ4() {
        return jComboBoxJ4;
    }

    public javax.swing.JComboBox<String> getComboBoxJ5() {
        return jComboBoxJ5;
    }

    public javax.swing.JComboBox<String> getComboBoxJ6() {
        return jComboBoxJ6;
    }

    public javax.swing.JComboBox<String> getComboBoxJ7() {
        return jComboBoxJ7;
    }

    public javax.swing.JComboBox<String> getComboBoxJ8() {
        return jComboBoxJ8;
    }

    public javax.swing.JComboBox<String> getComboBoxJ9() {
        return jComboBoxJ9;
    }
}
