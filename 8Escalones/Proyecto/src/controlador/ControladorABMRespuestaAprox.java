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

    }

    private void volver() {

    }

    private void salir() {
        
    }
}
