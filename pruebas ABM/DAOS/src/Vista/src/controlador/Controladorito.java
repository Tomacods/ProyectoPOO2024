package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Modelito;
import ventanas.MenuPruebas;

public class Controladorito implements ActionListener {
    private MenuPruebas menu_prueba;
    private Modelito modelo; 
    
public Controladorito (MenuPruebas ventana, Modelito modelo){
    this.menu_prueba = menu_prueba;
    this.modelo = modelo;
    this.menu_prueba.jButtonJugar1(this);
    this.menu_prueba.jButtonModoAdmin(this);
    this.menu_prueba.jButtonOpciones(this);
    this.menu_prueba.jButtonSalir(this);
}
//ahora inicio el menu con los datos del modelito (faltan)
//modifique MenuPruebas para que estos botones pasen de private a public
public void iniciar_vista(){
menu_prueba.jButtonJugar1.setAction(a);
menu_prueba.jButtonModoAdmin.setAction(b);;
menu_prueba.jButtonOpciones.setAction(c);
menu_prueba.jButtonSalir.setAction(d);
} 

}
