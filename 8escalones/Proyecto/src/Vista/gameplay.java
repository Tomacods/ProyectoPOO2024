
package Vista;

import java.sql.SQLException;

import controlador.ControladorGameplay;

public class Gameplay extends javax.swing.JFrame {
   // @SuppressWarnings("unused")
    private ControladorGameplay controlador;

        public Gameplay(ControladorGameplay controlador) {
            initComponents();
            this.setLocationRelativeTo(null);
            rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "Proyecto/src/imagenes/MenuPrincipal3.png");
            rsscalelabel.RSScaleLabel.setScaleLabel(jLabelTematica, "Proyecto/src/imagenes/entretenimiento.png");
            rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconUser, "Proyecto/src/imagenes/user.png");
            rsscalelabel.RSScaleLabel.setScaleLabel(jLabelExit, "Proyecto/src/imagenes/exit.png");
            this.controlador = controlador;
    }


    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelExit = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jLabelIconUser = new javax.swing.JLabel();
        jLabelJugador = new javax.swing.JLabel();
        jTextFieldJugador = new javax.swing.JTextField();
        jButtonRtaA = new javax.swing.JButton();
        jButtonRtaB = new javax.swing.JButton();
        jButtonRtaC = new javax.swing.JButton();
        jButtonRtaD = new javax.swing.JButton();
        jLabelRonda = new javax.swing.JLabel();
        jLabelEscalon = new javax.swing.JLabel();
        jLabelRtaA = new javax.swing.JLabel();
        jLabelRtaB = new javax.swing.JLabel();
        jLabelRtaC = new javax.swing.JLabel();
        jLabelRtaD = new javax.swing.JLabel();
        jTextFieldPregunta = new javax.swing.JTextField();
        jTextFieldTurnoActual = new javax.swing.JTextField();
        jLabelTematica = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 20));

        jButtonExit.setBackground(new java.awt.Color(102, 0, 102));
        jButtonExit.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));
        jPanel1.add(jLabelIconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 40, 30));

        jLabelJugador.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jLabelJugador.setForeground(new java.awt.Color(255, 255, 255));
        jLabelJugador.setText("Jugador N");
        jPanel1.add(jLabelJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 100, 30));

        jTextFieldJugador.setEditable(false);
        jTextFieldJugador.setBackground(new java.awt.Color(102, 0, 102));
        jTextFieldJugador.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jTextFieldJugador.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldJugador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldJugador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJugadorActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldJugador, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 60, 170, 50));

        jButtonRtaA.setBackground(new java.awt.Color(102, 0, 102));
        jButtonRtaA.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jButtonRtaA.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRtaA.setText("Respuesta");
        jButtonRtaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRtaAActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRtaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 510, 240, 30));

        jButtonRtaB.setBackground(new java.awt.Color(102, 0, 102));
        jButtonRtaB.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jButtonRtaB.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRtaB.setText("Respuesta");
        jPanel1.add(jButtonRtaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 550, 240, 30));

        jButtonRtaC.setBackground(new java.awt.Color(102, 0, 102));
        jButtonRtaC.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jButtonRtaC.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRtaC.setText("Respuesta");
        jPanel1.add(jButtonRtaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 510, 240, 30));

        jButtonRtaD.setBackground(new java.awt.Color(102, 0, 102));
        jButtonRtaD.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jButtonRtaD.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRtaD.setText("Respuesta");
        jButtonRtaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRtaDActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRtaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 240, 30));

        jLabelRonda.setFont(new java.awt.Font("Roboto Medium", 3, 15)); // NOI18N
        jLabelRonda.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRonda.setText("(1/2)");
        jPanel1.add(jLabelRonda, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, -1, 30));

        jLabelEscalon.setFont(new java.awt.Font("Roboto Medium", 3, 30)); // NOI18N
        jLabelEscalon.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEscalon.setText("ESCALON N");
        jPanel1.add(jLabelEscalon, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 170, 60));

        jLabelRtaA.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabelRtaA.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRtaA.setText("A.");
        jPanel1.add(jLabelRtaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 30, 30));

        jLabelRtaB.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabelRtaB.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRtaB.setText("B.");
        jPanel1.add(jLabelRtaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 30, 30));

        jLabelRtaC.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabelRtaC.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRtaC.setText("C.");
        jPanel1.add(jLabelRtaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 510, 30, -1));

        jLabelRtaD.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabelRtaD.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRtaD.setText("D.");
        jPanel1.add(jLabelRtaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 30, -1));

        jTextFieldPregunta.setEditable(false);
        jTextFieldPregunta.setBackground(new java.awt.Color(102, 0, 102));
        jTextFieldPregunta.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldPregunta.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPregunta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPregunta.setText("Pregunta");
        jTextFieldPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPreguntaActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 580, 70));

        jTextFieldTurnoActual.setEditable(false);
        jTextFieldTurnoActual.setBackground(new java.awt.Color(102, 0, 102));
        jTextFieldTurnoActual.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldTurnoActual.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTurnoActual.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTurnoActual.setText("TURNO ACTUAL"); 
        jTextFieldTurnoActual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTurnoActualActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldTurnoActual, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 170, 40));
        jPanel1.add(jLabelTematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 580, 300));

        jLabelFondo.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, -370, 650, 990));

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
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonRtaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRtaDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRtaDActionPerformed

    private void jTextFieldPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPreguntaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPreguntaActionPerformed

    private void jTextFieldJugadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJugadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJugadorActionPerformed

    private void jButtonRtaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRtaAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRtaAActionPerformed

    private void jTextFieldTurnoActualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTurnoActualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTurnoActualActionPerformed

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
            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gameplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ControladorGameplay c = null;
                try {
                    c = new ControladorGameplay();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                new Gameplay(c).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonExit;
    public javax.swing.JButton jButtonRtaA;
    public javax.swing.JButton jButtonRtaB;
    public javax.swing.JButton jButtonRtaC;
    public javax.swing.JButton jButtonRtaD;
    public javax.swing.JLabel jLabelEscalon;
    public javax.swing.JLabel jLabelExit;
    public javax.swing.JLabel jLabelFondo;
    public javax.swing.JLabel jLabelIconUser;
    public javax.swing.JLabel jLabelJugador;
    public javax.swing.JLabel jLabelRonda;
    public javax.swing.JLabel jLabelRtaA;
    public javax.swing.JLabel jLabelRtaB;
    public javax.swing.JLabel jLabelRtaC;
    public javax.swing.JLabel jLabelRtaD;
    public javax.swing.JLabel jLabelTematica;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextField jTextFieldJugador;
    public javax.swing.JTextField jTextFieldPregunta;
    public javax.swing.JTextField jTextFieldTurnoActual;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getjTextFieldPregunta() {
        return jTextFieldPregunta;
    }


    public javax.swing.JButton getjButtonRtaA() {
        return jButtonRtaA;
    }


    public javax.swing.JButton getjButtonRtaB() {
        return jButtonRtaB;
    }


    public javax.swing.JButton getjButtonRtaC() {
        return jButtonRtaC;
    }


    public javax.swing.JButton getjButtonRtaD() {
        return jButtonRtaD;
    }


    public javax.swing.JTextField getjTextFieldTurnoActual() {
        return jTextFieldTurnoActual;
    }


   
    
}

