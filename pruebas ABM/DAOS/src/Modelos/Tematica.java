package Modelos;

import DAOs.TematicaDAOImpl;
import java.sql.*;

public class Tematica {
    private int id;
    private String nombre;


    public Tematica(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    
    public Tematica(int id){
        TematicaDAOImpl tem  = new TematicaDAOImpl();
    try {
        tem.obtenerTematica(id);
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

    public static void GetTematicas()
    {
        Tematica.GetTematicas()
        var dao = new Dao();
        var arrelo = dao.obtenerTematicas();

        for(int i=0; i < arrelo.size(); i++){
            new Tematica(arrelo[i][0])
        }

        return result;

    }
}