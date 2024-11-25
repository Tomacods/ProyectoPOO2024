package controlador;

import Vista.MenuPrincipal;
import Vista.SeleccionarJugador;
import Vista.OpcionesGenerales;
import Vista.ABMJugadores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalController {
    private MenuPrincipal menuPrincipal;

    public MenuPrincipalController(MenuPrincipal menuPrincipal) {
        this.menuPrincipal = menuPrincipal;
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
              //  abrirABMJugadores();
            }
        });
        this.menuPrincipal.jButtonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salirDelJuego();
            }
        });
    }

    private void abrirSeleccionarJugador() {
        SeleccionarJugador seleccionarJugador = new SeleccionarJugador();
        seleccionarJugador.setVisible(true);
        menuPrincipal.dispose();
    }

    private void abrirOpcionesGenerales() {
        OpcionesGenerales opcionesGenerales = new OpcionesGenerales();
        opcionesGenerales.setVisible(true);
        menuPrincipal.dispose();
    }

    private void abrirABMJugadores() {
        ABMJugadores abmJugadores = new ABMJugadores();
        abmJugadores.setVisible(true);
        menuPrincipal.dispose();
    }

    private void salirDelJuego() {
        System.exit(0);
    }
}