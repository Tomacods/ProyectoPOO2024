package controlador;

import Vista.Creditos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ControladorCreditos es el controlador encargado de gestionar la ventana de créditos del juego.
 * 
 * <p>Al instanciarse, crea y muestra la ventana de créditos. Además, gestiona el evento del botón
 * de salida (jButtonExit), cerrando la ventana de créditos y abriendo el controlador de opciones generales
 * cuando el usuario hace clic en dicho botón.</p>
 * 
 * Dependencias:
 * <ul>
 *   <li>Creditos: Vista de la ventana de créditos.</li>
 *   <li>ControladorOpcionesGenerales: Controlador de la ventana de opciones generales.</li>
 * </ul>
 */
public class ControladorCreditos {
    private Creditos creditos;

    public ControladorCreditos() {
        this.creditos = new Creditos();
        this.creditos.setVisible(true);

        this.creditos.jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditos.dispose();
                new ControladorOpcionesGenerales();
            }
        });
    }
}