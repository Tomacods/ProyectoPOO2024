package controlador;

import Vista.AdminContraseña;
import Vista.ModoAdmin;
import Vista.OpcionesGenerales;

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
                OpcionesGenerales opcionesGenerales = new OpcionesGenerales();
                opcionesGenerales.setVisible(true); // Abre la vista OpcionesGenerales
                vista.dispose(); // Cierra la ventana actual
            }
        });

        this.vista.jButtonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(vista.jPasswordField.getPassword());
                if ("admin".equals(password)) {
                    vista.dispose(); // Cierra la ventana actual
                    vista.dispose(); // Cierra la ventana actual
                    new ControladorModoAdmin();
                } else {
                    // Mostrar mensaje de error o realizar alguna acción
                    System.out.println("Contraseña incorrecta");
                javax.swing.JOptionPane.showMessageDialog(vista, "Contraseña incorrecta", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}