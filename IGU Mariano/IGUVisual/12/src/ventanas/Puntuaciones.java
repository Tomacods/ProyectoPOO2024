/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Maria
 */
public class Puntuaciones extends javax.swing.JFrame {

    /**
     * Creates new form gameplay
     */
    public Puntuaciones() {
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "src/imagenes/rojo.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelPodio, "src/imagenes/podio.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelExit, "src/imagenes/exit.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelConfig, "src/imagenes/config.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconGanador, "src/imagenes/user.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconPodio3, "src/imagenes/user.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconPodio2, "src/imagenes/user.png");
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
        jLabelExit = new javax.swing.JLabel();
        jLabelConfig = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jButtonConfig = new javax.swing.JButton();
        jLabelPuntuaciones = new javax.swing.JLabel();
        jLabelIconGanador = new javax.swing.JLabel();
        jLabelIconPodio2 = new javax.swing.JLabel();
        jLabelIconPodio3 = new javax.swing.JLabel();
        jTextFieldJugadorPodio2 = new javax.swing.JTextField();
        jTextFieldJugadorPodio3 = new javax.swing.JTextField();
        jTextFieldJugadorGanador = new javax.swing.JTextField();
        jTextFieldJugadorPodio4 = new javax.swing.JTextField();
        jTextFieldJugadorPodio5 = new javax.swing.JTextField();
        jTextFieldJugadorPodio6 = new javax.swing.JTextField();
        jTextFieldJugadorPodio7 = new javax.swing.JTextField();
        jTextFieldJugadorPodio8 = new javax.swing.JTextField();
        jTextFieldJugadorPodio9 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabelPodio = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 20));
        jPanel1.add(jLabelConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 30, 20));

        jButtonExit.setBackground(new java.awt.Color(255, 0, 0));
        jButtonExit.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jButtonConfig.setBackground(new java.awt.Color(255, 0, 0));
        jButtonConfig.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonConfig.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfigActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 50, 40));

        jLabelPuntuaciones.setFont(new java.awt.Font("Roboto Medium", 3, 30)); // NOI18N
        jLabelPuntuaciones.setForeground(new java.awt.Color(255, 255, 255));
        jLabelPuntuaciones.setText("GANADOR");
        jPanel1.add(jLabelPuntuaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 150, 60));
        jPanel1.add(jLabelIconGanador, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 120, 90));
        jPanel1.add(jLabelIconPodio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 70, 60));
        jPanel1.add(jLabelIconPodio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 180, 70, 60));

        jTextFieldJugadorPodio2.setEditable(false);
        jTextFieldJugadorPodio2.setBackground(new java.awt.Color(255, 0, 0));
        jTextFieldJugadorPodio2.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jTextFieldJugadorPodio2.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadorPodio2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadorPodio2.setText("Jugador N");
        jTextFieldJugadorPodio2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorPodio2ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugadorPodio2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, 30));

        jTextFieldJugadorPodio3.setEditable(false);
        jTextFieldJugadorPodio3.setBackground(new java.awt.Color(255, 0, 0));
        jTextFieldJugadorPodio3.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jTextFieldJugadorPodio3.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadorPodio3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadorPodio3.setText("Jugador N");
        jTextFieldJugadorPodio3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorPodio3ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugadorPodio3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, 30));

        jTextFieldJugadorGanador.setEditable(false);
        jTextFieldJugadorGanador.setBackground(new java.awt.Color(255, 0, 0));
        jTextFieldJugadorGanador.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jTextFieldJugadorGanador.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadorGanador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadorGanador.setText("Jugador N");
        jTextFieldJugadorGanador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorGanadorActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugadorGanador, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, -1, 30));

        jTextFieldJugadorPodio4.setEditable(false);
        jTextFieldJugadorPodio4.setBackground(new java.awt.Color(255, 0, 0));
        jTextFieldJugadorPodio4.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jTextFieldJugadorPodio4.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadorPodio4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadorPodio4.setText("Jugador N");
        jTextFieldJugadorPodio4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorPodio4ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugadorPodio4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 360, -1, 30));

        jTextFieldJugadorPodio5.setEditable(false);
        jTextFieldJugadorPodio5.setBackground(new java.awt.Color(255, 0, 0));
        jTextFieldJugadorPodio5.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jTextFieldJugadorPodio5.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadorPodio5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadorPodio5.setText("Jugador N");
        jTextFieldJugadorPodio5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorPodio5ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugadorPodio5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 400, -1, 30));

        jTextFieldJugadorPodio6.setEditable(false);
        jTextFieldJugadorPodio6.setBackground(new java.awt.Color(255, 0, 0));
        jTextFieldJugadorPodio6.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jTextFieldJugadorPodio6.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadorPodio6.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadorPodio6.setText("Jugador N");
        jTextFieldJugadorPodio6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorPodio6ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugadorPodio6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 440, -1, 30));

        jTextFieldJugadorPodio7.setEditable(false);
        jTextFieldJugadorPodio7.setBackground(new java.awt.Color(255, 0, 0));
        jTextFieldJugadorPodio7.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jTextFieldJugadorPodio7.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadorPodio7.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadorPodio7.setText("Jugador N");
        jTextFieldJugadorPodio7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorPodio7ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugadorPodio7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 480, -1, 30));

        jTextFieldJugadorPodio8.setEditable(false);
        jTextFieldJugadorPodio8.setBackground(new java.awt.Color(255, 0, 0));
        jTextFieldJugadorPodio8.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jTextFieldJugadorPodio8.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadorPodio8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadorPodio8.setText("Jugador N");
        jTextFieldJugadorPodio8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorPodio8ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugadorPodio8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 520, -1, 30));

        jTextFieldJugadorPodio9.setEditable(false);
        jTextFieldJugadorPodio9.setBackground(new java.awt.Color(255, 0, 0));
        jTextFieldJugadorPodio9.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jTextFieldJugadorPodio9.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugadorPodio9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugadorPodio9.setText("Jugador N");
        jTextFieldJugadorPodio9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorPodio9ActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugadorPodio9, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 560, -1, 30));

        jLabel4.setFont(new java.awt.Font("Roboto Medium", 0, 25)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("4.");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 360, 40, 20));

        jLabel5.setFont(new java.awt.Font("Roboto Medium", 0, 25)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("5.");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 400, 40, 20));

        jLabel6.setFont(new java.awt.Font("Roboto Medium", 0, 25)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("6.");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 440, 40, 20));

        jLabel7.setFont(new java.awt.Font("Roboto Medium", 0, 25)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("7.");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 40, 20));

        jLabel8.setFont(new java.awt.Font("Roboto Medium", 0, 25)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("8.");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 520, 40, 20));

        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 25)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("9.");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 560, 40, 20));
        jPanel1.add(jLabelPodio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 350));

        jLabelFondo.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -390, 660, 990));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConfigActionPerformed

    private void jTextFieldJugadorGanadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorGanadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorGanadorActionPerformed

    private void jTextFieldJugadorPodio2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorPodio2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorPodio2ActionPerformed

    private void jTextFieldJugadorPodio3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorPodio3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorPodio3ActionPerformed

    private void jTextFieldJugadorPodio4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorPodio4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorPodio4ActionPerformed

    private void jTextFieldJugadorPodio5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorPodio5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorPodio5ActionPerformed

    private void jTextFieldJugadorPodio6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorPodio6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorPodio6ActionPerformed

    private void jTextFieldJugadorPodio7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorPodio7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorPodio7ActionPerformed

    private void jTextFieldJugadorPodio8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorPodio8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorPodio8ActionPerformed

    private void jTextFieldJugadorPodio9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorPodio9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorPodio9ActionPerformed

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
            java.util.logging.Logger.getLogger(Puntuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Puntuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Puntuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Puntuaciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puntuaciones().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfig;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelConfig;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIconGanador;
    private javax.swing.JLabel jLabelIconPodio2;
    private javax.swing.JLabel jLabelIconPodio3;
    private javax.swing.JLabel jLabelPodio;
    private javax.swing.JLabel jLabelPuntuaciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldJugadorGanador;
    private javax.swing.JTextField jTextFieldJugadorPodio2;
    private javax.swing.JTextField jTextFieldJugadorPodio3;
    private javax.swing.JTextField jTextFieldJugadorPodio4;
    private javax.swing.JTextField jTextFieldJugadorPodio5;
    private javax.swing.JTextField jTextFieldJugadorPodio6;
    private javax.swing.JTextField jTextFieldJugadorPodio7;
    private javax.swing.JTextField jTextFieldJugadorPodio8;
    private javax.swing.JTextField jTextFieldJugadorPodio9;
    // End of variables declaration//GEN-END:variables
}