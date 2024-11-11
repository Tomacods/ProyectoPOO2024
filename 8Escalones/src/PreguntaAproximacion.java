public class PreguntaAproximacion extends Pregunta {
    private int valorAproximado;

    public PreguntaAproximacion(int idPregunta, String enunciado, int idTematica, int valorAproximado) {
        super(idPregunta, enunciado, idTematica, "aproximación");
        this.valorAproximado = valorAproximado;
    }

    //no se si funciona es q en dao sql solo toma float no big decimal
    public int getValorAproximado() {
        return valorAproximado;
    }
/*   public BigDecimal getValorAproximado() {
        return valorAproximado;
    }*/

    public void setValorAproximado(int valorAproximado) {
        this.valorAproximado = valorAproximado;
    }
}