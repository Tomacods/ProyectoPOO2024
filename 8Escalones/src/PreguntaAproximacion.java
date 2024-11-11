import java.math.BigDecimal;

public class PreguntaAproximacion extends Pregunta {
    private BigDecimal valorAproximado;

    public PreguntaAproximacion(int idPregunta, String enunciado, Tematica tematica, BigDecimal valorAproximado) {
        super(idPregunta, enunciado, tematica, "aproximación");
        this.valorAproximado = valorAproximado;
    }

    @Override
    public boolean esCorrecta(String respuesta) {
        BigDecimal respuestaDecimal = new BigDecimal(respuesta);
        return respuestaDecimal.compareTo(valorAproximado) == 0;
    }
    //no se si funciona es q en dao sql solo toma float no big decimal
    public float getValorAproximado() {
        return valorAproximado.floatValue();
    }
/*   public BigDecimal getValorAproximado() {
        return valorAproximado;
    }*/

    public void setValorAproximado(BigDecimal valorAproximado) {
        this.valorAproximado = valorAproximado;
    }
}