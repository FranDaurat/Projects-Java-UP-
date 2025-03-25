import java.time.LocalDate;

public class Persona {
    private String nombre;
    private String dni;
    private Fecha fechaNacimiento;

    public Persona() {
    }

    public Persona(String nombre, String dni, Fecha fechaNacimiento) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int edad()
    {
        LocalDate fechaHoy=LocalDate.now();
        Fecha hoy=new Fecha(fechaHoy.getDayOfMonth(),fechaHoy.getMonthValue(),fechaHoy.getYear());
        return fechaNacimiento.fechaDiferencia(hoy);
    }
    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\n' +
                ", dni='" + dni + '\n' +
                ", fecha nacimiento " + fechaNacimiento + '\n' +
                ", edad" + this.edad()  +'}';
    }

    public String getNombre() {
        return nombre;
    }

    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }
}
