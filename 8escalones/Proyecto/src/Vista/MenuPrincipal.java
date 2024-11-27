package Vista;

import java.awt.Toolkit;
public class MenuPrincipal extends javax.swing.JFrame {

        public MenuPrincipal() {
                initComponents();
                this.setLocationRelativeTo(null);
                rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "Proyecto/src/imagenes/MenuPrincipal3.png");
                rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconJugar, "Proyecto/src/imagenes/Joystick.png");
                setIconImage(Toolkit.getDefaultToolkit().getImage("Proyecto/src/imagenes/icon.png"));
        }

        private void initComponents() {
                jPanel1 = new javax.swing.JPanel();
                jLabelIconJugar = new javax.swing.JLabel();
                jLabelJugar = new javax.swing.JLabel();
                jButtonJugar = new javax.swing.JButton();
                jButtonPerfil = new javax.swing.JButton();
                jButtonAyuda = new javax.swing.JButton();
                jButtonSalir = new javax.swing.JButton();
                jButtonOpciones = new javax.swing.JButton();
                jLabelFondo = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setUndecorated(true);

                jPanel1.setBackground(new java.awt.Color(0, 0, 51));
                jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                jLabelJugar.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
                jLabelJugar.setForeground(new java.awt.Color(255, 255, 255));
                jLabelJugar.setText("JUGAR");
                jPanel1.add(jLabelJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 110, 70));
                jPanel1.add(jLabelIconJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 160, 110));
                

                jButtonJugar.setBackground(new java.awt.Color(102, 0, 102));
                jButtonJugar.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
                jButtonJugar.setForeground(new java.awt.Color(255, 255, 255));
                jPanel1.add(jButtonJugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 370, 220, 190));

                jButtonPerfil.setBackground(new java.awt.Color(102, 0, 102));
                jButtonPerfil.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
                jButtonPerfil.setForeground(new java.awt.Color(255, 255, 255));
                jButtonPerfil.setText("PERFIL");
                jPanel1.add(jButtonPerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 370, 200, 40));

                jButtonAyuda.setBackground(new java.awt.Color(102, 0, 102));
                jButtonAyuda.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
                jButtonAyuda.setForeground(new java.awt.Color(255, 255, 255));
                jButtonAyuda.setText("AYUDA");
                jPanel1.add(jButtonAyuda, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 470, 200, 40));

                jButtonSalir.setBackground(new java.awt.Color(102, 0, 102));
                jButtonSalir.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
                jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
                jButtonSalir.setText("SALIR");
                jPanel1.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, 200, 40));

                jButtonOpciones.setBackground(new java.awt.Color(102, 0, 102));
                jButtonOpciones.setFont(new java.awt.Font("Roboto Medium", 0, 15)); // NOI18N
                jButtonOpciones.setForeground(new java.awt.Color(255, 255, 255));
                jButtonOpciones.setText("OPCIONES");
                jPanel1.add(jButtonOpciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 420, 200, 40));

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
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                600,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE)));
                pack();
        }

        // Variables declaration - do not modify
        public javax.swing.JButton jButtonAyuda;
        public javax.swing.JButton jButtonJugar;
        public javax.swing.JButton jButtonOpciones;
        public javax.swing.JButton jButtonPerfil;
        public javax.swing.JButton jButtonSalir;
        public javax.swing.JLabel jLabelFondo;
        public javax.swing.JLabel jLabelIconJugar;
        public javax.swing.JLabel jLabelJugar;
        public javax.swing.JPanel jPanel1;
        // End of variables declaration
}