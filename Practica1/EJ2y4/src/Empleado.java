public class Empleado {
    private String nombre;
    private String apellido;
    private int legajo;
    private static int contadorLegajo = 99;

    public Empleado(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        contadorLegajo+=1;
        this.legajo=contadorLegajo;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", legajo=" + legajo +
                '}';
    }
}
