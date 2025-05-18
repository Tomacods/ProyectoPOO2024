package controlador;

import Vista.ModoAdmin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControladorModoAdmin acts as the controller for the administrator mode in the application.
 * It manages the interactions between the admin view (ModoAdmin) and the application's logic.
 * 
 * <p>
 * Upon instantiation, this controller:
 * <ul>
 *   <li>Initializes and displays the admin mode view.</li>
 *   <li>Sets up action listeners for navigation buttons:
 *     <ul>
 *       <li><b>Back Button:</b> Returns to the main menu and closes the current window.</li>
 *       <li><b>ABM Preguntas Button:</b> Opens the question management view and closes the current window.</li>
 *       <li><b>ABM Tematicas Button:</b> Opens the topic management view and closes the current window.</li>
 *     </ul>
 *   </li>
 * </ul>
 * </p>
 * 
 * <p>
 * This controller assumes the existence of the following classes:
 * <ul>
 *   <li>ModoAdmin (the admin view)</li>
 *   <li>MenuPrincipalController (main menu controller)</li>
 *   <li>ControladorABMPreguntas (question management controller)</li>
 *   <li>ControladorABMTematica (topic management controller)</li>
 * </ul>
 * </p>
 */
public class ControladorModoAdmin {
    private ModoAdmin vista;

    public ControladorModoAdmin() {
        this.vista = new ModoAdmin();
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