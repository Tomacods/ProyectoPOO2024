import java.math.BigDecimal;

public class PreguntaAproximacion extends Pregunta {
    private BigDecimal valorAproximado;

    public PreguntaAproximacion(int idPregunta, String enunciado, String tipoPregunta, String categoria, BigDecimal valorAproximado) {
        super(idPregunta, enunciado, tipoPregunta, categoria);
        this.valorAproximado = valorAproximado;
    }

    @Override
    public boolean esCorrecta(String respuesta) {
        BigDecimal respuestaDecimal = new BigDecimal(respuesta);
        return respuestaDecimal.compareTo(valorAproximado) == 0;
    }

    public BigDecimal getValorAproximado() {
        return valorAproximado;
    }

    public void setValorAproximado(BigDecimal valorAproximado) {
        this.valorAproximado = valorAproximado;
    }
}