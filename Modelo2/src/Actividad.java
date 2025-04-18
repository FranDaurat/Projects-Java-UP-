public abstract class Actividad {
    private int cantidadDias;

    public Actividad(int cantidadDias) {
        this.cantidadDias = cantidadDias;
    }

    public abstract  double getCostoAdicional();
}
