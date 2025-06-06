package Vista;

public class Ayuda extends javax.swing.JFrame {
    public Ayuda() {
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "Proyecto/src/imagenes/MenuPrincipal3.png");
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
        textoAyuda = new javax.swing.JTextArea();
        jLabelBack = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoAyuda.setBackground(new java.awt.Color(102, 102, 102));
        textoAyuda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        textoAyuda.setEditable(false);
        textoAyuda.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        textoAyuda.setForeground(new java.awt.Color(255, 255, 0));
        textoAyuda.setMaximumSize(new java.awt.Dimension(5, 5));
        textoAyuda.setMinimumSize(new java.awt.Dimension(10, 10));
        textoAyuda.setPreferredSize(new java.awt.Dimension(10, 10));
        textoAyuda.setText(
                "\\\\\\El juego involucra a 9 jugadores que deben avanzar por 8 escalones///\n \n\n\\\\\\Eliminando a uno en cada subida hasta llegar a una final entre dos jugadores/// \n \n\n\\\\\\Cada escalón tiene una temática elegida al azar y los jugadores \nsolo sabrán cuál les corresponde al avanzar./// \n\n\n\\\\\\Las preguntas son de opción múltiple y se asignan aleatoriamente.///\n\n \n\\\\\\Si hay empate, se realiza una pregunta de aproximación a cada uno,  \nen la que ganan los jugadores que estén más cerca de la respuesta correcta.///  \n\n\n\\\\\\En cada escalón, se hacen dos rondas de preguntas.///");
        textoAyuda.setLineWrap(true);
        textoAyuda.setWrapStyleWord(true);
        jPanel1.add(new javax.swing.JScrollPane(textoAyuda), new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 160, 510, 320));
        jPanel1.add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 20));

        jButtonBack.setBackground(new java.awt.Color(102, 0, 102));
        jButtonBack.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jLabelFondo.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
                                javax.swing.GroupLayout.PREFERRED_SIZE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 600,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonBackActionPerformed
        this.dispose();
    }// GEN-LAST:event_jButtonBackActionPerformed

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
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ayuda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ayuda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtonBack;
    public javax.swing.JLabel jLabelBack;
    public javax.swing.JLabel jLabelFondo;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTextArea textoAyuda;
    // End of variables declaration//GEN-END:variables

}
