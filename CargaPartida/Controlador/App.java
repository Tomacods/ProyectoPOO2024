package Controlador;

import java.awt.EventQueue;

import Vista.PantallaCarga;

public class App {
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable(){
            public void run() {
                try {
                    new ControladorCargaPantalla();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
