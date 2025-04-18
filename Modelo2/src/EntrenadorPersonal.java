public class EntrenadorPersonal extends Actividad {
    private double costo_adicional = 100;
    private int cantidadHoras;

    public EntrenadorPersonal(int cantidadDias, double costo_adicional, int cantidadHoras) {
        super(cantidadDias);
        this.costo_adicional = costo_adicional;
        this.cantidadHoras = cantidadHoras;
    }

    public double getCostoAdicional() {
        return (costo_adicional * cantidadHoras);
    }

}
