package Modelos;

import java.sql.SQLException;
import java.util.ArrayList;

import DAOs.JugadorDAOImpl;
import DAOs.TematicaDAOImpl;

/**
 * La clase Jugador representa a un jugador en el sistema, almacenando información relevante
 * como su identificador, nombre, puntaje y estado. Proporciona métodos para manipular y acceder
 * a estos datos, así como operaciones estáticas para la gestión de jugadores en la base de datos
 * (insertar, eliminar, actualizar y obtener jugadores).
 * 
 * <p>
 * Métodos principales:
 * <ul>
 *   <li>Constructores para crear instancias de Jugador.</li>
 *   <li>Getters y setters para los atributos del jugador.</li>
 *   <li>Método para incrementar el puntaje del jugador.</li>
 *   <li>Métodos estáticos para operaciones de ABM (Alta, Baja, Modificación) sobre jugadores.</li>
 *   <li>Método para obtener la representación en cadena del jugador.</li>
 * </ul>
 * </p>
 * 
 * <p>
 * Nota: Esta clase depende de la clase JugadorDAOImpl para la interacción con la base de datos.
 * </p>
 * 
 * @author (Tu Nombre)
 * @version 1.0
 */
public class Jugador {
    private int id_jugador;
    private String nombre;
    private int puntaje;
    private String estado;

    // Constructor, getters y setters
    
    public Jugador(int id_jugador, String nombre,  int puntaje, String estado) {
        this.id_jugador = id_jugador;
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.estado = estado;
    }

    public Jugador() {
    }

    public int getId() {
        return id_jugador;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEstado() {
        return estado;
    }

    public int getPuntaje(){
        return puntaje;
    }

    public void setId(int id_jugador) {
        this.id_jugador = id_jugador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public void incrementarPuntaje() {
        puntaje= puntaje + 1;
    }

    //ABM
    public static void insertarJugador (Jugador jugador){
        JugadorDAOImpl dao = new JugadorDAOImpl();
        dao.insertarJugador(jugador);
    }
    public static void eliminarJugador(int id){
        JugadorDAOImpl dao = new JugadorDAOImpl();
        dao.eliminarJugador(id);
    }
    public static void actualizarJugador(Jugador jugador){
        JugadorDAOImpl dao = new JugadorDAOImpl();
        dao.actualizarJugador(jugador);
    }


    public static Jugador obtenerJugador(int id_jugador) throws SQLException{
        JugadorDAOImpl dao = new JugadorDAOImpl();
        Jugador jugador = dao.obtenerJugador(id_jugador);
        return jugador;
    }
    
    public static ArrayList<Jugador> obtenerJugadores(){
        JugadorDAOImpl dao = new JugadorDAOImpl();
        ArrayList<Object[]> arreglo = dao.obtenerJugadores();
        ArrayList<Jugador> jugadores = new ArrayList<>();
        for (Object[] row : arreglo) {
            Jugador jugador = new Jugador((int) row[0], (String) row[1], (int) row[2], (String) row[3]);
            jugadores.add(jugador);
            
        }
        return jugadores;
    }

    @Override
    public String toString() {
        return nombre;
    }

   /*  public void actualizarPuntaje() {
        JugadorDAOImpl dao = new JugadorDAOImpl();
        dao.actualizarPuntaje(this);
    } */

  /*   public static ArrayList<Jugador> obtenerJugadoresConMenorPuntaje() {
        JugadorDAOImpl dao = new JugadorDAOImpl();
        return dao.obtenerJugadoresConMenorPuntaje();
    } */
    
    

}