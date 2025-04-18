public class Pileta extends Actividad {
    private double extra;

    public Pileta(int cantidadDias, double extra) {
        super(cantidadDias);
        this.extra = extra;
    }

    @Override
    public double getCostoAdicional() {
        return extra;
    }
}
