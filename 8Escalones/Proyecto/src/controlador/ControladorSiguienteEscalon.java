package controlador;

import java.util.ArrayList;
import java.util.List;

import Modelos.Jugador;
import Modelos.Tematica;
import Vista.SiguienteEscalon;


public class ControladorSiguienteEscalon {
    private ArrayList<Jugador>jugadores;
    private SiguienteEscalon vista1;
    private Jugador eliminado;

    //jugadores id juego jugador eliminado tematicas 
    public ControladorSiguienteEscalon(int id_juego, ArrayList<Jugador>jugadores, Jugador eliminado, ArrayList<Tematica> tematicas){
        this.jugadores= jugadores;

        this.vista1= new SiguienteEscalon();
        vista1.setVisible(true);
        traerJugadoresSiguen();
        //this.vista2= new VISTAMARIANO;
       // vista2.visible
        this.eliminado= eliminado;



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
        vista1.getjTextFieldJ9().setText(obtenerNombreJugador(8));
    }
    

    private void traerEliminado(){
      //  vista2.getTextFieldEliminado.setText(eliminado.getNombre());
    }

    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = Jugador.obtenerJugadores(); // Obtiene la lista de jugadores

        // Crear un nuevo ArrayList con los primeros 7 elementos o hasta el tamaño de la lista
        ArrayList<Jugador> subListaJugadores = new ArrayList<>(jugadores.subList(0, Math.min(7, jugadores.size())));
        new ControladorSiguienteEscalon(1, subListaJugadores, null, null);
    }
}
