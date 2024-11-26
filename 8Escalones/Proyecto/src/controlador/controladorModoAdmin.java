package controlador;

import Vista.ModoAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorModoAdmin {
    private ModoAdmin vista;

    public ControladorModoAdmin() {
        this.vista =  new ModoAdmin();
        this.vista.setVisible(true);

        this.vista.getjButtonBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuPrincipalController();
                vista.dispose(); // Cierra la ventana actual
            }
        });

        this.vista.getjButtonABMPreguntas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose(); // Cierra la ventana actual
                new ControladorABMPreguntas(); // Abre la vista ABMPreguntas
            }
        });

        this.vista.getjButtonABMTematicas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose(); // Cierra la ventana actual
                new ControladorABMTematica(); // Abre la vista ABMTematicas
            }
        });
    }
}