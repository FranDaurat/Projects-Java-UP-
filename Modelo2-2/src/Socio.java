import java.util.ArrayList;
import java.util.List;

public class Socio {
    private int numero_socio;
    private String nombre;
    private double cuota_mensual;
    private List<Actividad> actividades = new ArrayList<>();

    public Socio(int numero_socio, String nombre, double cuota_mensual, List<Actividad> actividades) {
        this.numero_socio = numero_socio;
        this.nombre = nombre;
        this.cuota_mensual = cuota_mensual;
        this.actividades = actividades;
    }

    public void inscribir_actividad(Actividad actividad){

    }

    public float valor_abono_mensual(){
      return 2;
    }

    @Override
    public String toString() {
        return "Socio" +
                "numero_socio=" + numero_socio +
                ", nombre='" + nombre + '\'' +
                ", cuota_mensual=" + cuota_mensual +
                ", actividades=" + actividades +
                '}';
    }

    public int getNumero_socio() {
        return numero_socio;
    }

    public double getCuota_mensual() {
        return cuota_mensual;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}
