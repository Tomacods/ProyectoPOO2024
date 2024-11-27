
package Vista;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ABMTematicas extends javax.swing.JFrame {

    public ABMTematicas() {
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "Proyecto/src/imagenes/codigo.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconAdmin, "Proyecto/src/imagenes/admin.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconEdit, "Proyecto/src/imagenes/lapiz.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconDelete, "Proyecto/src/imagenes/basura.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondoTematica, "Proyecto/src/imagenes/verde.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelBack, "Proyecto/src/imagenes/back.png");
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextFieldABMPreguntas = new javax.swing.JTextField();
        jTextFieldTematica = new javax.swing.JTextField();
        jComboBoxTematica = new javax.swing.JComboBox<>();
        jTextFieldNuevaTematica = new javax.swing.JTextField();
        jLabelIconEdit = new javax.swing.JLabel();
        jLabelIconDelete = new javax.swing.JLabel();
        jButtonEliminarTematica = new javax.swing.JButton();
        jButtonModificarTematica = new javax.swing.JButton();
        jLabelFondoTematica = new javax.swing.JLabel();
        jButtonAgregarTematica = new javax.swing.JButton();
        jLabelBack = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jLabelIconAdmin1 = new javax.swing.JLabel();
        jLabelIconAdmin = new javax.swing.JLabel();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextFieldABMPreguntas.setEditable(false);
        jTextFieldABMPreguntas.setBackground(new java.awt.Color(51, 153, 0));
        jTextFieldABMPreguntas.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
        jTextFieldABMPreguntas.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldABMPreguntas.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldABMPreguntas.setText("TEMATICAS");
        jPanel1.add(jTextFieldABMPreguntas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 310, 70));

        jTextFieldTematica.setEditable(false);
        jTextFieldTematica.setBackground(new java.awt.Color(51, 153, 0));
        jTextFieldTematica.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldTematica.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldTematica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldTematica.setText("Tematica");
        jPanel1.add(jTextFieldTematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 100, 60));

        jComboBoxTematica.setBackground(new java.awt.Color(51, 153, 0));
        jComboBoxTematica.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jComboBoxTematica.setForeground(new java.awt.Color(255, 255, 255));
        jComboBoxTematica.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));

        jComboBoxTematica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selectedTematica = (String) jComboBoxTematica.getSelectedItem();

                if (selectedTematica != null) {
                    // controlador.seleccionarTematica(selectedTematica);
                }
            }
        });

        jPanel1.add(jComboBoxTematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 160, 60));

        jTextFieldNuevaTematica.setBackground(new java.awt.Color(0, 102, 0));
        jTextFieldNuevaTematica.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldNuevaTematica.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldNuevaTematica.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextFieldNuevaTematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 270, 40));
        jPanel1.add(jLabelIconEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, 60, 50));
        jPanel1.add(jLabelIconDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 60, 50));

        jButtonEliminarTematica.setBackground(new java.awt.Color(0, 102, 0));
        jButtonEliminarTematica.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jButtonEliminarTematica.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminarTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Botón ELIMINAR tematica presionado");
            }
        });
        jPanel1.add(jButtonEliminarTematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 80, 70));

        jButtonModificarTematica.setBackground(new java.awt.Color(0, 102, 0));
        jButtonModificarTematica.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jButtonModificarTematica.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificarTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Botón MODIFICAR tematica presionado");
            }
        });
        jPanel1.add(jButtonModificarTematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 80, 70));
        jPanel1.add(jLabelFondoTematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 290, 130));

        jButtonAgregarTematica.setBackground(new java.awt.Color(0, 102, 0));
        jButtonAgregarTematica.setFont(new java.awt.Font("Roboto Medium", 0, 70)); // NOI18N
        jButtonAgregarTematica.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarTematica.setText("+");
        jButtonAgregarTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("Botón Agregar Pregunta presionado");
            }
        });

        jPanel1.add(jButtonAgregarTematica, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 140, 80, 70));
        jPanel1.add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 40, 30));

        jButtonBack.setBackground(new java.awt.Color(0, 102, 0));
        jButtonBack.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                System.out.println("ATRAS presionado");
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, 50));
        jPanel1.add(jLabelIconAdmin1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 110, 100));
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
    }

    public void agregarListenerEliminarTematica(ActionListener listener) {
        jButtonEliminarTematica.addActionListener(listener);
    }

    public void agregarListenerAgregarTematica(ActionListener listener) {
        jButtonAgregarTematica.addActionListener(listener);
    }

    public void listenerModificarTematica(ActionListener listener) {
        jButtonModificarTematica.addActionListener(listener);
    }

    public void listenerAtras(ActionListener listener) {
        jButtonBack.addActionListener(listener);
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ABMTematicas.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ABMTematicas.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ABMTematicas.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ABMTematicas.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // ControladorABMTematica controlador = new ControladorABMTematica();
                new ABMTematicas().setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonAgregarTematica;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JButton jButtonEliminarTematica;

    private javax.swing.JButton jButtonModificarTematica;
    private javax.swing.JComboBox<String> jComboBoxTematica;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelFondoTematica;
    private javax.swing.JLabel jLabelIconAdmin;
    private javax.swing.JLabel jLabelIconAdmin1;
    private javax.swing.JLabel jLabelIconDelete;
    private javax.swing.JLabel jLabelIconEdit;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextFieldABMPreguntas;
    private javax.swing.JTextField jTextFieldNuevaTematica;
    private javax.swing.JTextField jTextFieldTematica;

    public javax.swing.JComboBox<String> getComboBoxTematica() {
        return jComboBoxTematica;
    }

    public javax.swing.JTextField getTextFieldNuevaTematica() {
        return jTextFieldNuevaTematica;
    }

}
