/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author Maria
 */
public class ABMRespuestaMC extends javax.swing.JFrame {   
    /**
     * Creates new form gameplay
     */
    public ABMRespuestaMC() {
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "Proyecto/src/imagenes/codigo.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconAdmin, "Proyecto/src/imagenes/admin.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondoPregunta, "Proyecto/src/imagenes/verde.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelExit, "Proyecto/src/imagenes/exit.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelSave, "Proyecto/src/imagenes/guardar.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldPreguntaMC = new javax.swing.JTextField();
        jTextFieldPreguntaMC1 = new javax.swing.JTextField();
        jLabelSave = new javax.swing.JLabel();
        jButtonSave = new javax.swing.JButton();
        jLabelExit = new javax.swing.JLabel();
        jButtonExit = new javax.swing.JButton();
        jLabelIconAdmin = new javax.swing.JLabel();
        jTextFieldRtaA = new javax.swing.JTextField();
        jTextFieldRtaB = new javax.swing.JTextField();
        jTextFieldRtaC = new javax.swing.JTextField();
        jTextFieldRtaD = new javax.swing.JTextField();
        jRadioButtonRtaA = new javax.swing.JRadioButton();
        jRadioButtonRtaC = new javax.swing.JRadioButton();
        jRadioButtonRtaB = new javax.swing.JRadioButton();
        jRadioButtonRtaD = new javax.swing.JRadioButton();
        jLabelFondoPregunta = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldPreguntaMC.setEditable(false);
        jTextFieldPreguntaMC.setBackground(new java.awt.Color(51, 153, 0));
        jTextFieldPreguntaMC.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
        jTextFieldPreguntaMC.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPreguntaMC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldPreguntaMC.setText("Pregunta");
        jPanel1.add(jTextFieldPreguntaMC, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 590, 50));

        jTextFieldPreguntaMC1.setBackground(new java.awt.Color(51, 153, 0));
        jTextFieldPreguntaMC1.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
        jTextFieldPreguntaMC1.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldPreguntaMC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextFieldPreguntaMC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 590, 50));
        jPanel1.add(jLabelSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, 30));

        jButtonSave.setBackground(new java.awt.Color(0, 102, 0));
        jButtonSave.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jButtonSave.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 50));
        jPanel1.add(jLabelExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 40, 30));

        jButtonExit.setBackground(new java.awt.Color(0, 102, 0));
        jButtonExit.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jButtonExit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExitActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 60, 50));
        jPanel1.add(jLabelIconAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 110, 100));

        jTextFieldRtaA.setBackground(new java.awt.Color(0, 102, 0));
        jTextFieldRtaA.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldRtaA.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldRtaA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldRtaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldRtaAActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldRtaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 240, 40));

        jTextFieldRtaB.setBackground(new java.awt.Color(0, 102, 0));
        jTextFieldRtaB.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldRtaB.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldRtaB.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextFieldRtaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 240, 40));

        jTextFieldRtaC.setBackground(new java.awt.Color(0, 102, 0));
        jTextFieldRtaC.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldRtaC.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldRtaC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextFieldRtaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 240, 40));

        jTextFieldRtaD.setBackground(new java.awt.Color(0, 102, 0));
        jTextFieldRtaD.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldRtaD.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldRtaD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextFieldRtaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 330, 240, 40));

        buttonGroup1.add(jRadioButtonRtaA);
        jPanel1.add(jRadioButtonRtaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        buttonGroup1.add(jRadioButtonRtaC);
        jPanel1.add(jRadioButtonRtaC, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, -1));

        buttonGroup1.add(jRadioButtonRtaB);
        jPanel1.add(jRadioButtonRtaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 270, -1, -1));

        buttonGroup1.add(jRadioButtonRtaD);
        jPanel1.add(jRadioButtonRtaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, -1, -1));
        jPanel1.add(jLabelFondoPregunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 590, 250));
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 400));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonExitActionPerformed

    private void jTextFieldRtaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldRtaAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldRtaAActionPerformed

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
            java.util.logging.Logger.getLogger(ABMRespuestaMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABMRespuestaMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABMRespuestaMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABMRespuestaMC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ABMRespuestaMC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    public javax.swing.JButton jButtonExit;
    public javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabelExit;
    public javax.swing.JLabel jLabelFondo;
    public javax.swing.JLabel jLabelFondoPregunta;
    public javax.swing.JLabel jLabelIconAdmin;
    public javax.swing.JLabel jLabelSave;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JRadioButton jRadioButtonRtaA;
    public javax.swing.JRadioButton jRadioButtonRtaB;
    public javax.swing.JRadioButton jRadioButtonRtaC;
    public javax.swing.JRadioButton jRadioButtonRtaD;
    public javax.swing.JTextField jTextFieldPreguntaMC;
    public javax.swing.JTextField jTextFieldPreguntaMC1;
    public javax.swing.JTextField jTextFieldRtaA;
    public javax.swing.JTextField jTextFieldRtaB;
    public javax.swing.JTextField jTextFieldRtaC;
    public javax.swing.JTextField jTextFieldRtaD;
    // End of variables declaration//GEN-END:variables
}
