package controlador;
import java.sql.SQLException;

import Vista.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        // ControladorABMTematica con =new ControladorABMTematica();
      //  SeleccionarJugador sele = new SeleccionarJugador();
     // controladorModoAdmin a = new controladorModoAdmin();
      //ControladorABMJugadores c = new ControladorABMJugadores();
      //ventanas.AdminContraseña a = new AdminContraseña(null)
    // ControladorAdminContraseña c = new ControladorAdminContraseña();
          // SeleccionarJugador sele = new SeleccionarJugador();
          // ControladorSeleccionarJugadores c = new ControladorSeleccionarJugadores(sele);
          MenuPrincipal menuPrincipal = new MenuPrincipal();
          new MenuPrincipalController(menuPrincipal);
          menuPrincipal.setVisible(true); // Abre la vista MenuPrincipal
    } 
    //ControladorGameplay c = new ControladorGameplay();
}

