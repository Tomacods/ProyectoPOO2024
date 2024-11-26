package controlador;

import Vista.Ayuda;

public class ControladorAyuda {
    private Ayuda ayuda;

    public ControladorAyuda() {
        this.ayuda = new Ayuda();
        this.ayuda.setVisible(true);
        
        this.ayuda.jButtonBack.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ayuda.dispose();
                new MenuPrincipalController();
            }
        });
    }
}