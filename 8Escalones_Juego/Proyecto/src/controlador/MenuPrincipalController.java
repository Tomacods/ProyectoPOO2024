package controlador;

import Vista.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controlador para el menú principal de la aplicación.
 * 
 * Esta clase gestiona la interacción del usuario con la interfaz gráfica del menú principal,
 * asignando los listeners a los botones y manejando la navegación entre las diferentes
 * pantallas del juego.
 * 
 * Funcionalidades principales:
 * <ul>
 *   <li>Iniciar el juego y seleccionar jugadores.</li>
 *   <li>Abrir las opciones generales del juego.</li>
 *   <li>Gestionar perfiles de jugadores (ABM).</li>
 *   <li>Salir de la aplicación.</li>
 *   <li>Mostrar la ayuda del juego.</li>
 * </ul>
 * 
 * Cada acción de los botones crea el controlador correspondiente y cierra la ventana actual.
 */
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