public class General extends Actividad {
    private int cant_dias;
    private float costo_dia;

    public General(String codigo, String nombre, int cant_dias, float costo_dia) {
        super(codigo, nombre);
        this.cant_dias = cant_dias;
        this.costo_dia = costo_dia;
    }

    public float valor_actividad() {
        return (float) getCant_dias() * getCosto_dia();
    }

    public int getCant_dias() {
        return cant_dias;
    }

    public float getCosto_dia() {
        return costo_dia;
    }
}
