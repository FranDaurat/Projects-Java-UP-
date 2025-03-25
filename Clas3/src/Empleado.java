public class Empleado extends Persona{
    private String legajo;
    private double sueldo;

    public Empleado(String nombre, String dni, Fecha fechaNacimiento, String legajo)
    {

        super(nombre, dni, fechaNacimiento);
        this.legajo=legajo;
        sueldo=500000;
    }
    public double cobrarSueldo()
    {
        return 0;
    }

    @Override
    public String toString() {
        return getFechaNacimiento() + " Empleado{" +
                "legajo='" + legajo + '\'' +
                '}';
    }
}
