import java.util.ArrayList;
import java.util.List;

public class Gimnasio {
    private String nombre = "Siempre en forma";
    private List<Socio> socios = new ArrayList<>();

    public void agregar_socio(Socio socio) {
        this.socios.add(socio);
    }

    public double get_couta_socio(Socio socio) {
        return socio.getCuota();
    }

    public double get_all_cuotas() {
        double total = 0;
        for (Socio s : socios){
            total += s.getCuota();
        }
        return total;
    }
}
