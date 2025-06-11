import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private String nombre = "Siempre en forma";
    private List<Socio> socios = new ArrayList<>();

    public void agregar_socio(int numero, String nombre, double cuota, List<Actividad> actividad){
        Socio socio = new Socio(numero, nombre, cuota, actividad);
        socios.add(socio);
    }


    public Socio consultar_actividad(int numero){
        Socio sociecito = null;
        for (Socio socio : socios){
            if (socio.getNumero_socio() == numero){
                sociecito = socio;
            }
        }

        return sociecito;
    }

    public double importe_socio(Socio socio){
        return  socio.getCuota_mensual();
    }

    public double ingreso_total_por_pago_cuotas(){
        double total = 0;
        for (Socio so : socios){
            total += so.getCuota_mensual();
        }
        return total;
    }

    public List<Socio> getSocios() {
        return socios;
    }
}
