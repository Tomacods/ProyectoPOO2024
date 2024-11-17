package Controlador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Timer;

import Vista.PantallaCarga;


public class ControladorCargaPantalla implements ActionListener, MouseListener{
    private PantallaCarga carga;
    private Timer tiempo;

    public ControladorCargaPantalla(){
        super();
        this.carga = new PantallaCarga(this);
        carga.setVisible(true);
        iniciarLoop();
    }

    private void iniciarLoop(){
        tiempo = new Timer(9000, e -> finLoop());
        tiempo.setRepeats(false); //Se ejecuta una sola vez
        tiempo.start();
    }

    private void finLoop(){
        tiempo.stop();
        carga.dispose(); //Cierra la ventana actual
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseClicked'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseEntered'");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseExited'");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
    
}
