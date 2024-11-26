package controlador;

import Vista.AdminContraseña;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAdminContraseña {
    private AdminContraseña vista;

    public ControladorAdminContraseña() {
        this.vista = new AdminContraseña();
        this.vista.setVisible(true);
        this.vista.jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose(); // Cierra la ventana actual
                new ControladorOpcionesGenerales(); // Abre la vista OpcionesGenerales
            }
        });

        this.vista.jButtonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(vista.jPasswordField.getPassword());
                if ("admin".equals(password)) { // acá se puede cambiar la contraseña de admin, para futaas
                                                // implementaciones podemos guardar la contraseña en la base de datos y
                                                // en la vista admin agregar una ventana para cambiar la contraseña
                    vista.dispose(); // Cierra la ventana actual
                    new ControladorModoAdmin();
                } else {
                    // Mostrar mensaje de error o realizar alguna acción
                    System.out.println("Contraseña incorrecta");
                    javax.swing.JOptionPane.showMessageDialog(vista, "Contraseña incorrecta", "Error",
                            javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}