package Modelos;

import java.sql.SQLException;
import java.util.ArrayList;

import DAOs.TematicaDAOImpl;

public class Tematica {
    private int id;
    private String nombre;


    public Tematica(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Tematica(int id) { //creo q esto no va. soy mora
        TematicaDAOImpl tematicaDAO = new TematicaDAOImpl();
        try {
            Tematica tematica = tematicaDAO.obtenerTematica(id);
            if (tematica != null) {
                this.id = tematica.getId();
                this.nombre = tematica.getNombre();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    } 

    //select MAX (id_tematica) from tematica

    // public static void GetTematicas()
    // {
    //     Tematica.GetTematicas()
    //     var dao = new Dao();
    //     var arrelo = dao.obtenerTematicas();

    //     for(int i=0; i < arrelo.size(); i++){
    //         new Tematica(arrelo[i][0])
    //     }
    //     return result;

    // }
    public static ArrayList<Tematica> obtenerTematicas() {
        TematicaDAOImpl dao = new TematicaDAOImpl();
        ArrayList<Object[]> arreglo = dao.obtenerTematicas();
        ArrayList <Tematica> tematicas = new ArrayList<>();

        for (Object[] row : arreglo) {
            Tematica tematica = new Tematica((int) row[0], (String) row[1]);
            tematicas.add(tematica);
        }
        return tematicas;
    }

    public static Tematica obtenerTematica(int id_tematica){
        TematicaDAOImpl dao = new TematicaDAOImpl();
        Tematica tematica = null; 
        try {
            tematica = dao.obtenerTematica(id_tematica);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return tematica;
    }
}