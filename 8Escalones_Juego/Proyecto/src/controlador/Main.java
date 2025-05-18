package controlador;
import java.sql.SQLException;
/**
 * Entry point for the application.
 * Initializes the main menu controller to start the program.
 *
 * @param args Command-line arguments (not used).
 * @throws SQLException if a database access error occurs.
 */
public class Main {
public static void main(String[] args) throws SQLException {
      new MenuPrincipalController();
  }
}




