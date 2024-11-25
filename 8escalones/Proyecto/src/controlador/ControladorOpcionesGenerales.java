package controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Vista.OpcionesGenerales;
import java.awt.*;
import javax.swing.*;

public class ControladorOpcionesGenerales {
    private OpcionesGenerales menuOpciones;
    private JButton botonAtras;
    private JButton botonCreditos;
    private JButton botonAdmin;
    
    public ControladorOpcionesGenerales (){
        this.menuOpciones = new OpcionesGenerales();
        this.menuOpciones.jButtonBack.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
            };
        });
        this.menuOpciones.jButtonCreditos.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){};
        });
        this.menuOpciones.jButtonModoAdmin.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){};
        });
    }    
}
