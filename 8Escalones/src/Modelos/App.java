package Modelos;
import Conex.DatabaseConnection;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        DatabaseConnection bdd = DatabaseConnection.getInstance();
    }
}
