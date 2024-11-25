package Vista;
import controlador.*;


public class AdminContraseña extends javax.swing.JFrame {   

    public AdminContraseña(controladorAdminContraseña controlador) {
        this.controlador = controlador;
        setLookandFeel();
        initComponents();
        this.setLocationRelativeTo(null);
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelFondo, "src/imagenes/codigo.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelBack, "src/imagenes/back.png");
        rsscalelabel.RSScaleLabel.setScaleLabel(jLabelIconAdmin, "src/imagenes/admin.png");
        this.setVisible(true); // Asegúrate de que la ventana sea visible
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        jPanel1 = new javax.swing.JPanel();
        jLabelBack = new javax.swing.JLabel();
        jButtonBack = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextFieldContraseña = new javax.swing.JTextField();
        jLabelIconAdmin = new javax.swing.JLabel();
        jIngresar = new javax.swing.JButton();
        jLabelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jLabelBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 30, 20));

        jButtonBack.setBackground(new java.awt.Color(51, 153, 0));
        jButtonBack.setFont(new java.awt.Font("Roboto Medium", 0, 10)); // NOI18N
        jButtonBack.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBackActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        jPasswordField1.setBackground(new java.awt.Color(51, 153, 0));
        jPasswordField1.setForeground(new java.awt.Color(255, 255, 255));
        jPasswordField1.setEditable(true);
        jPanel1.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 400, 30));

        jTextFieldContraseña.setEditable(false);
        jTextFieldContraseña.setBackground(new java.awt.Color(51, 153, 0));
        jTextFieldContraseña.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jTextFieldContraseña.setForeground(new java.awt.Color(255, 255, 255));
        jTextFieldContraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextFieldContraseña.setText("CONTRASEÑA");
        jPanel1.add(jTextFieldContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 400, -1));
        jPanel1.add(jLabelIconAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 110, 100));

        jIngresar.setBackground(new java.awt.Color(51, 153, 0));
        jIngresar.setFont(new java.awt.Font("Roboto Medium", 0, 20)); // NOI18N
        jIngresar.setForeground(new java.awt.Color(255, 255, 255));
        jIngresar.setText("INGRESAR");
        jPanel1.add(jIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 130, -1));

        jLabelFondo.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        jLabelFondo.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jLabelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 300));

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
    }

    private void jButtonBackActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        MenuPrincipal menuPrincipal = new MenuPrincipal();
        new MenuPrincipalController(menuPrincipal);
        menuPrincipal.setVisible(true);
    }

    private void setLookandFeel() {
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminContraseña(new controladorAdminContraseña("admin")).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jIngresar;
    private javax.swing.JButton jButtonBack;
    private javax.swing.JLabel jLabelBack;
    private javax.swing.JLabel jLabelFondo;
    private javax.swing.JLabel jLabelIconAdmin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextFieldContraseña;
    private controladorAdminContraseña controlador;
    // End of variables declaration

    public controladorAdminContraseña getControlador() {
        return controlador;
    }

    public void setControlador(controladorAdminContraseña controlador) {
        this.controlador = controlador;
    }

    public javax.swing.JPasswordField getjPasswordField1() {
        return jPasswordField1;
    }

    public void setjPasswordField1(javax.swing.JPasswordField jPasswordField1) {
        this.jPasswordField1 = jPasswordField1;
    }

    public javax.swing.JButton getjIngresar() {
        return jIngresar;
    }

    public void setjIngresar(javax.swing.JButton jIngresar) {
        this.jIngresar = jIngresar;
    }

    public javax.swing.JButton getjButtonBack() {
        return jButtonBack;
    }

    public void setjButtonBack(javax.swing.JButton jButtonBack) {
        this.jButtonBack = jButtonBack;
    }
}