package controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import ventanas.OpcionesGenerales;
import java.awt.*;
import javax.swing.*;

public class ControladorOpcionesGenerales {
    protected OpcionesGenerales menuOpciones;
    private JButton botonAtras;
    private JButton botonCreditos;
    private JButton botonAdmin;
    private JTextField textoOpciones;
    
    public ControladorOpcionesGenerales (OpcionesGenerales menuOpciones){
        this.menuOpciones = menuOpciones;
        this.menuOpciones.jButtonBack.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){};
        });
        this.menuOpciones.jButtonCreditos.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){};
        });
        this.menuOpciones.jButtonModoAdmin.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){};
        });
        textoOpciones = new JTextField("OPCIONES");
        menuOpciones = new OpcionesGenerales();
    }
    
    
    
    public void pruebita() {
        this.menuOpciones.setVisible(true);
    }
    
        
}
