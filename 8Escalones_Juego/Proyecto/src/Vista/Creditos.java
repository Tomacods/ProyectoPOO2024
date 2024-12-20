/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Maria
 */
public class Creditos extends javax.swing.JFrame {
    /**
     * Creates new form gameplay
     */
    public Creditos() {
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "Proyecto/src/imagenes/plantilla.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelExit, "Proyecto/src/imagenes/back.png");
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
        jLabelExit = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jLabelN1 = new javax.swing.JLabel();
        jLabelN2 = new javax.swing.JLabel();
        jLabelN3 = new javax.swing.JLabel();
        jLabelN4 = new javax.swing.JLabel();
        jLabeln5 = new javax.swing.JLabel();
        jLabelN6 = new javax.swing.JLabel();
        jLabelN7 = new javax.swing.JLabel();
        jLabelN8 = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 20));

        jButtonExit.setBackground(new java.awt.Color(51, 204, 0));
        jButtonExit.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabelN1.setFont(new java.awt.Font("Roboto Medium", 0, 50)); // NOI18N
        jLabelN1.setText("Cesar");
        jPanel1.add(jLabelN1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 390, 140, 70));

        jLabelN2.setFont(new java.awt.Font("Roboto Medium", 0, 50)); // NOI18N
        jLabelN2.setText("Javier");
        jPanel1.add(jLabelN2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 130, 150, 70));

        jLabelN3.setFont(new java.awt.Font("Roboto Medium", 0, 50)); // NOI18N
        jLabelN3.setText("Tomas");
        jPanel1.add(jLabelN3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 160, 70));

        jLabelN4.setFont(new java.awt.Font("Roboto Medium", 0, 50)); // NOI18N
        jLabelN4.setText("Tomas");
        jPanel1.add(jLabelN4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 40, 160, 70));

        jLabeln5.setFont(new java.awt.Font("Roboto Medium", 0, 50)); // NOI18N
        jLabeln5.setText("Mariano");
        jPanel1.add(jLabeln5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 190, 70));

        jLabelN6.setFont(new java.awt.Font("Roboto Medium", 0, 50)); // NOI18N
        jLabelN6.setText("Mora");
        jPanel1.add(jLabelN6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 120, 70));

        jLabelN7.setFont(new java.awt.Font("Roboto Medium", 0, 50)); // NOI18N
        jLabelN7.setText("Federica");
        jPanel1.add(jLabelN7, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 200, 70));

        jLabelN8.setFont(new java.awt.Font("Roboto Medium", 0, 50)); // NOI18N
        jLabelN8.setText("Lucas");
        jPanel1.add(jLabelN8, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 140, 70));

        jLabelFondo.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 600));

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
            java.util.logging.Logger.getLogger(Creditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Creditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Creditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Creditos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Creditos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonExit;
    public javax.swing.JLabel jLabelExit;
    public javax.swing.JLabel jLabelFondo;
    public javax.swing.JLabel jLabelN1;
    public javax.swing.JLabel jLabelN2;
    public javax.swing.JLabel jLabelN3;
    public javax.swing.JLabel jLabelN4;
    public javax.swing.JLabel jLabelN6;
    public javax.swing.JLabel jLabelN7;
    public javax.swing.JLabel jLabelN8;
    public javax.swing.JLabel jLabeln5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
