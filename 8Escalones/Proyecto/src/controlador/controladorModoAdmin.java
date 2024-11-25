package controlador;

import Vista.ABMPreguntas;
import Vista.ABMTematicas;
import Vista.MenuPrincipal;
import Vista.ModoAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorModoAdmin {
    private ModoAdmin vista;

    public ControladorModoAdmin(ModoAdmin vista) {
        this.vista = vista;
        this.vista.getjButtonBack().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose(); // Cierra la ventana actual
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                new MenuPrincipalController(menuPrincipal);
                menuPrincipal.setVisible(true); // Abre la vista MenuPrincipal
            }
        });

        this.vista.getjButtonABMPreguntas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose(); // Cierra la ventana actual
                new ABMPreguntas().setVisible(true); // Abre la vista ABMPreguntas
            }
        });

        this.vista.getjButtonABMTematicas().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista.dispose(); // Cierra la ventana actual
                //new ABMTematicas(new ControladorABMTematica()).setVisible(true); // Abre la vista ABMTematicas
                new ControladorABMTematica();
            }
        });
    }
}