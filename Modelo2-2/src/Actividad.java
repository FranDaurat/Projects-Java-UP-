public abstract class Actividad {
    private String codigo;
    private String nombre;

    public Actividad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public abstract float valor_actividad();

    @Override
    public String toString() {
        return "Actividad{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
