package controlador;

import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalController {
    private MenuPrincipal menuPrincipal;

    public MenuPrincipalController() {
        this.menuPrincipal = new MenuPrincipal();
        this.menuPrincipal.setVisible(true);
        this.menuPrincipal.jButtonJugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirSeleccionarJugador();
            }
        });
        this.menuPrincipal.jButtonOpciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirOpcionesGenerales();
            }
        });
        this.menuPrincipal.jButtonPerfil.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirABMJugadores();
            }
        });
        this.menuPrincipal.jButtonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirDelJuego();
            }
        });
        this.menuPrincipal.jButtonAyuda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirAyuda();
            }
        });
    }

    private void abrirSeleccionarJugador() {
        new ControladorSeleccionarJugadores();
        menuPrincipal.dispose();
    }

    private void abrirOpcionesGenerales() {
        new ControladorOpcionesGenerales();
        menuPrincipal.dispose();

    }

    private void abrirABMJugadores() {
        new ControladorABMJugadores();
        menuPrincipal.dispose();
    }

    private void salirDelJuego() {
        System.exit(0);
    }

    private void abrirAyuda() {
        new ControladorAyuda();
        menuPrincipal.dispose();
    }
}