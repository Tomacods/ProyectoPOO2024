package controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Vista.MenuPrincipal;
import Vista.OpcionesGenerales;
import java.awt.*;
import javax.swing.*;

public class ControladorOpcionesGenerales {
    private OpcionesGenerales menuOpciones;
    
    public ControladorOpcionesGenerales (OpcionesGenerales opcionesGenerales){ 
        this.menuOpciones = opcionesGenerales;
        this.menuOpciones.jButtonBack.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                menuOpciones.dispose();
                MenuPrincipal menuPrincipal = new MenuPrincipal();
                new MenuPrincipalController(menuPrincipal);
                menuPrincipal.setVisible(true);
                
            }
        });
        this.menuOpciones.jButtonCreditos.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){};
        });
        this.menuOpciones.jButtonModoAdmin.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                new ControladorAdminContraseña();
                menuOpciones.dispose();
            }
        });
    }    
}
