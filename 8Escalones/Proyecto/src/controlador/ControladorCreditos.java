package controlador;

import Vista.Creditos;
import Vista.OpcionesGenerales;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCreditos {
    private Creditos creditos;

    public ControladorCreditos() {
        this.creditos = new Creditos();
        this.creditos.setVisible(true);
        
        this.creditos.jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                creditos.dispose();
                new ControladorOpcionesGenerales();
            }
        });
    }
}