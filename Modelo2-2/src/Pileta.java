public class Pileta extends Actividad {
    private float costo_acceso;

    public Pileta(String codigo, String nombre, float costo_acceso) {
        super(codigo, nombre);
        this.costo_acceso = costo_acceso;
    }

    public float valor_actividad() {
        return getCosto_acceso();
    }

    public float getCosto_acceso() {
        return costo_acceso;
    }
}
