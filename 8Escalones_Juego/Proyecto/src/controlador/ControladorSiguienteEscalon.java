package controlador;

import javax.swing.Timer; // Asegúrate de importar la clase correcta
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import Modelos.Jugador;
import Modelos.Tematica;
import Vista.SiguienteEscalon;


/**
 * ControladorSiguienteEscalon es el controlador encargado de gestionar la lógica
 * relacionada con la transición al siguiente escalón en el juego. Se encarga de
 * mostrar la vista correspondiente, actualizar los campos con los nombres de los
 * jugadores que siguen en juego y mostrar el jugador eliminado.
 * 
 * Funcionalidades principales:
 * <ul>
 *   <li>Inicializa la vista SiguienteEscalon y la muestra al usuario.</li>
 *   <li>Actualiza los campos de texto con los nombres de los jugadores activos.</li>
 *   <li>Muestra el nombre del jugador eliminado en la vista.</li>
 *   <li>Después de un tiempo determinado, cierra la vista y continúa el flujo del juego.</li>
 * </ul>
 * 
 * @author (Tu Nombre)
 * @version 1.0
 */
public class ControladorSiguienteEscalon {
    private ArrayList<Jugador>jugadores;
    private SiguienteEscalon vista1;
    private Jugador eliminado;

    //jugadores id juego jugador eliminado tematicas 
    public ControladorSiguienteEscalon(int id_juego, ArrayList<Jugador>jugadores, Jugador eliminado, ArrayList<Tematica> tematicas) throws SQLException{
        this.jugadores= jugadores;
        this.eliminado= eliminado;

        this.vista1= new SiguienteEscalon();

      inicializarVista();
        traerJugadoresSiguen();
        traerEliminado();
        //this.vista1.setVisible(true);
        new ControladorGameplay(id_juego+1, jugadores, tematicas);
        
    }

    private void inicializarVista() {

        vista1.setVisible(true);

        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vista1.dispose(); 
                //mostrarMenuPrincipal();
            }
        });
        timer.setRepeats(false); // Solo se ejecuta una vez
        timer.start();
    }
    
    String obtenerNombreJugador(int indice) {
        return indice < jugadores.size() ? jugadores.get(indice).getNombre() : ""; 
    }
    private void traerJugadoresSiguen() {
        // Método para obtener nombre del jugador o un valor vacío si no existe
    
        // Setear los campos con los nombres o vacío si no hay suficientes jugadores
        vista1.getjTextFieldJ1().setText(obtenerNombreJugador(0));
        vista1.getjTextFieldJ2().setText(obtenerNombreJugador(1));
        vista1.getjTextFieldJ3().setText(obtenerNombreJugador(2));
        vista1.getjTextFieldJ4().setText(obtenerNombreJugador(3)); // Este índice estaba incorrecto en tu código
        vista1.getjTextFieldJ5().setText(obtenerNombreJugador(4));
        vista1.getjTextFieldJ6().setText(obtenerNombreJugador(5));
        vista1.getjTextFieldJ7().setText(obtenerNombreJugador(6));
        vista1.getjTextFieldJ8().setText(obtenerNombreJugador(7));
        
    }
    

    private void traerEliminado(){
      //  vista2.getTextFieldEliminado.setText(eliminado.getNombre());
    vista1.getjTextFieldJ9().setText(eliminado.getNombre());
    }
}
