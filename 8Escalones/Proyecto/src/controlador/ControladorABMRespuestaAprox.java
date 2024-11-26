package controlador;

import Modelos.PreguntaAproximacion;
import Vista.ABMRespuestaAprox;

public class ControladorABMRespuestaAprox {
    private ABMRespuestaAprox vista;
    private PreguntaAproximacion preguntaActual;
    
    public ControladorABMRespuestaAprox(PreguntaAproximacion pregunta) {
        this.vista = new ABMRespuestaAprox();
        this.preguntaActual = pregunta;
        iniciarVista();
    }

    private void iniciarVista() {
        this.vista.jTextFieldPreguntaAprox.setText(this.preguntaActual.getEnunciado());

        this.vista.jButtonBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                volver();
            }
        });

        this.vista.jButtonExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                salir();
            }
        });

        this.vista.jTextFieldEditarPreguntaAprox.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                preguntaActual.setValorAproximado(vista.jTextFieldEditarPreguntaAprox.getText());
            }
        });
    }

    private PreguntaAproximacion volver() {
        this.vista.dispose();
        return this.preguntaActual;
    }

    private void salir() {
        this.vista.dispose();
    }
}
