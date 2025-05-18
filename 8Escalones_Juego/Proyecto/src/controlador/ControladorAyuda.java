package controlador;

import Vista.Ayuda;

/**
 * ControladorAyuda is responsible for managing the help window (Ayuda) in the application.
 * <p>
 * When instantiated, it displays the help window and attaches an action listener to the
 * "Back" button. When the "Back" button is pressed, the help window is closed and the
 * main menu controller (MenuPrincipalController) is launched.
 * </p>
 *
 * Responsibilities:
 * <ul>
 *   <li>Display the help window to the user.</li>
 *   <li>Handle the "Back" button action to close the help window and return to the main menu.</li>
 * </ul>
 */
public class ControladorAyuda {
    private Ayuda ayuda;

    public ControladorAyuda() {
        this.ayuda = new Ayuda();
        this.ayuda.setVisible(true);

        this.ayuda.jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayuda.dispose();
                new MenuPrincipalController();
            }
        });
    }
}