import java.util.ArrayList;
import java.util.List;

public class Socio {
    private double cuota;
    List<Actividad> actividades = new ArrayList<>();

    public Socio(List<Actividad> actividades, double cuota) {
        this.actividades.addAll(actividades);
        this.cuota = cuota;
    }


    public double getCuota() {
        double total= cuota;
        for (Actividad a : actividades){
            total += a.getCostoAdicional();
        }
        return total;
    }

    public List<Actividad> getActividades() {
        return actividades;
    }
}
