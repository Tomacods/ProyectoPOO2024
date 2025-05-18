package controlador;

import java.awt.event.ActionListener;

import Vista.OpcionesGenerales;

/**
 * ControladorOpcionesGenerales es el controlador encargado de gestionar las acciones
 * del menú de opciones generales de la aplicación. Inicializa la vista OpcionesGenerales
 * y asigna los listeners a los botones para manejar la navegación entre pantallas:
 * 
 * <ul>
 *   <li><b>jButtonBack:</b> Cierra el menú de opciones y abre el menú principal.</li>
 *   <li><b>jButtonCreditos:</b> Abre la pantalla de créditos y cierra el menú de opciones.</li>
 *   <li><b>jButtonModoAdmin:</b> Abre la pantalla de autenticación de administrador y cierra el menú de opciones.</li>
 * </ul>
 * 
 * Este controlador sigue el patrón MVC, actuando como intermediario entre la vista
 * OpcionesGenerales y el resto de la aplicación.
 */
public class ControladorOpcionesGenerales {
    private OpcionesGenerales menuOpciones;

    public ControladorOpcionesGenerales() {
        this.menuOpciones = new OpcionesGenerales();
        this.menuOpciones.setVisible(true);
        this.menuOpciones.jButtonBack.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuOpciones.dispose();
                new MenuPrincipalController();

            }
        });
        this.menuOpciones.jButtonCreditos.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new ControladorCreditos();
                menuOpciones.dispose();
            }
        });
        this.menuOpciones.jButtonModoAdmin.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                new ControladorAdminContraseña();
                menuOpciones.dispose();

            }
        });
    }
}
