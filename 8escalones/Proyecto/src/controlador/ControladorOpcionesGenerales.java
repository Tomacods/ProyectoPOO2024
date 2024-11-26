package controlador;
import java.awt.event.ActionListener;


import Vista.OpcionesGenerales;


public class ControladorOpcionesGenerales {
    private OpcionesGenerales menuOpciones;
    
    public ControladorOpcionesGenerales (){ 
        this.menuOpciones = new OpcionesGenerales();
        this.menuOpciones.setVisible(true);
        this.menuOpciones.jButtonBack.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                menuOpciones.dispose();
                new MenuPrincipalController();
                
            }
        });
        this.menuOpciones.jButtonCreditos.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                new ControladorCreditos();
                menuOpciones.dispose();
            }
        });
        this.menuOpciones.jButtonModoAdmin.addActionListener(new ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                new ControladorAdminContraseña();
                menuOpciones.dispose();
                
            }
        });
    }    
}
