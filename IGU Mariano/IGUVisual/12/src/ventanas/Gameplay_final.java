/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ventanas;

import javax.swing.Timer; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;


/**
 *
 * @author Maria
 */
public class Gameplay_final extends javax.swing.JFrame {
    private Timer timer; 
    private int tiempo;
    /**
     * Creates new form gameplay_aproximacion
     */
    public Gameplay_final() {
        initComponents();
        iniciarCronometro();
        this.setLocationRelativeTo(null);
        jLabelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/dorado.png")));
        jLabelExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/exit.png")));
        jLabelConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/config.png")));
        jLabelIconUser2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png")));
        jLabelIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/user.png")));
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
        jLabelTiempo = new javax.swing.JLabel();
        jProgressBarTiempo = new javax.swing.JProgressBar();
        jTextFieldPregunta = new javax.swing.JTextField();
        jLabelExit = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jLabelConfig = new javax.swing.JLabel();
        jButtonConfig = new javax.swing.JButton();
        jLabelIconUser = new javax.swing.JLabel();
        jLabelIconUser2 = new javax.swing.JLabel();
        jLabelUser = new javax.swing.JLabel();
        jLabelUser2 = new javax.swing.JLabel();
        jLabelRtaA = new javax.swing.JLabel();
        jLabelRtaB = new javax.swing.JLabel();
        jLabelRtaC = new javax.swing.JLabel();
        jLabelRtaD = new javax.swing.JLabel();
        jButtonRtaA = new javax.swing.JButton();
        jButtonRtaB = new javax.swing.JButton();
        jButtonRtaC = new javax.swing.JButton();
        jButtonRtaD = new javax.swing.JButton();
        jLabelEscalonFinal = new javax.swing.JLabel();
        jLabelVersus = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabelTiempo.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelTiempo.setText("30");
        jPanel1.add(jLabelTiempo, new java.awt.GridBagConstraints());

        /*
        jLabelTiempo.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jLabelTiempo.setText("30");
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(350, 300, 0, 0);
        jPanel1.add(jLabelTiempo, gridBagConstraints); */

        jProgressBarTiempo.setMaximum(30);
        jProgressBarTiempo.setValue(30);
        java.awt.GridBagConstraints gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
        jPanel1.add(jProgressBarTiempo, gridBagConstraints);

        jTextFieldPregunta.setEditable(false);
        jTextFieldPregunta.setBackground(new java.awt.Color(255, 204, 51));
        jTextFieldPregunta.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldPregunta.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPregunta.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPregunta.setText("Pregunta");
        jTextFieldPregunta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldPreguntaActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldPregunta, new java.awt.GridBagConstraints());
        jPanel1.add(jLabelExit, new java.awt.GridBagConstraints());

        jButtonExit.setBackground(new java.awt.Color(255, 204, 51));
        jButtonExit.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExit, new java.awt.GridBagConstraints());
        jPanel1.add(jLabelConfig, new java.awt.GridBagConstraints());

        jButtonConfig.setBackground(new java.awt.Color(255, 204, 51));
        jButtonConfig.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonConfig.setForeground(new java.awt.Color(255, 255, 255));
        jButtonConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfigActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonConfig, new java.awt.GridBagConstraints());
        jPanel1.add(jLabelIconUser, new java.awt.GridBagConstraints());
        jPanel1.add(jLabelIconUser2, new java.awt.GridBagConstraints());

        jLabelUser.setFont(new java.awt.Font("Roboto Medium", 3, 30)); // NOI18N
        jLabelUser.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUser.setText("USER 1");
        jPanel1.add(jLabelUser, new java.awt.GridBagConstraints());

        jLabelUser2.setFont(new java.awt.Font("Roboto Medium", 3, 30)); // NOI18N
        jLabelUser2.setForeground(new java.awt.Color(255, 255, 255));
        jLabelUser2.setText("USER 2");
        jPanel1.add(jLabelUser2, new java.awt.GridBagConstraints());

        jLabelRtaA.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabelRtaA.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRtaA.setText("A.");
        jPanel1.add(jLabelRtaA, new java.awt.GridBagConstraints());

        jLabelRtaB.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabelRtaB.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRtaB.setText("B.");
        jPanel1.add(jLabelRtaB, new java.awt.GridBagConstraints());

        jLabelRtaC.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabelRtaC.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRtaC.setText("C.");
        jPanel1.add(jLabelRtaC, new java.awt.GridBagConstraints());

        jLabelRtaD.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        jLabelRtaD.setForeground(new java.awt.Color(255, 255, 255));
        jLabelRtaD.setText("D.");
        jPanel1.add(jLabelRtaD, new java.awt.GridBagConstraints());

        jButtonRtaA.setBackground(new java.awt.Color(255, 204, 51));
        jButtonRtaA.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jButtonRtaA.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRtaA.setText("Respuesta");
        jButtonRtaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRtaAActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRtaA, new java.awt.GridBagConstraints());

        jButtonRtaB.setBackground(new java.awt.Color(255, 204, 51));
        jButtonRtaB.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jButtonRtaB.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRtaB.setText("Respuesta");
        jButtonRtaB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRtaBActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRtaB, new java.awt.GridBagConstraints());

        jButtonRtaC.setBackground(new java.awt.Color(255, 204, 51));
        jButtonRtaC.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jButtonRtaC.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRtaC.setText("Respuesta");
        jButtonRtaC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRtaCActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRtaC, new java.awt.GridBagConstraints());

        jButtonRtaD.setBackground(new java.awt.Color(255, 204, 51));
        jButtonRtaD.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
        jButtonRtaD.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRtaD.setText("Respuesta");
        jButtonRtaD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRtaDActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRtaD, new java.awt.GridBagConstraints());

        jLabelEscalonFinal.setFont(new java.awt.Font("Roboto Medium", 3, 30)); // NOI18N
        jLabelEscalonFinal.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEscalonFinal.setText("¡ESCALON FINAL!");
        jPanel1.add(jLabelEscalonFinal, new java.awt.GridBagConstraints());

        jLabelVersus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/versus.gif"))); // NOI18N
        jLabelVersus.setText("ESCALON FINAL");
        jPanel1.add(jLabelVersus, new java.awt.GridBagConstraints());
        jPanel1.add(jLabelFondo, new java.awt.GridBagConstraints());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jButtonConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfigActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonConfigActionPerformed

    private void jTextFieldPreguntaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldPreguntaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldPreguntaActionPerformed

    private void jButtonRtaBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRtaBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRtaBActionPerformed

    private void jButtonRtaCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRtaCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRtaCActionPerformed

    private void jButtonRtaDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRtaDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRtaDActionPerformed

    private void jButtonRtaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRtaAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonRtaAActionPerformed

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
            java.util.logging.Logger.getLogger(Gameplay_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gameplay_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gameplay_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gameplay_final.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gameplay_final().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfig;
    private javax.swing.JButton jButtonExit;
    private javax.swing.JButton jButtonRtaA;
    private javax.swing.JButton jButtonRtaB;
    private javax.swing.JButton jButtonRtaC;
    private javax.swing.JButton jButtonRtaD;
    private javax.swing.JLabel jLabelConfig;
    private javax.swing.JLabel jLabelEscalonFinal;
    private javax.swing.JLabel jLabelExit;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIconUser;
    private javax.swing.JLabel jLabelIconUser2;
    private javax.swing.JLabel jLabelRtaA;
    private javax.swing.JLabel jLabelRtaB;
    private javax.swing.JLabel jLabelRtaC;
    private javax.swing.JLabel jLabelRtaD;
    private javax.swing.JLabel jLabelTiempo;
    private javax.swing.JLabel jLabelUser;
    private javax.swing.JLabel jLabelUser2;
    private javax.swing.JLabel jLabelVersus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBarTiempo;
    private javax.swing.JTextField jTextFieldPregunta;
    // End of variables declaration//GEN-END:variables
    
    private void iniciarCronometro(){
    tiempo=30;
    Puntuaciones ganador = new Puntuaciones();
    timer = new Timer(1000, new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) { 
            tiempo--;
            jLabelTiempo.setText(String.valueOf(tiempo)); 
            jProgressBarTiempo.setValue(tiempo); 
            if (tiempo <= 0) { 
                timer.stop();
                ganador.setVisible(true);
            }
        }
    });
    timer.start();
    }
}