import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Actividad> actividades = new ArrayList<>();
        actividades.add(new EntrenadorPersonal(3, 100, 5));
        actividades.add(new Pileta(3, 200));

        Socio socio = new Socio(actividades, 1000);
        System.out.println("Cuota total del socio: " + socio.getCuota());

        List<Actividad> actividades2 = new ArrayList<>();
        actividades2.add(new EntrenadorPersonal(3, 100, 5));
        actividades2.add(new Pileta(3, 200));

        Socio socio2 = new Socio(actividades2, 2000);

        Gimnasio gimnasio = new Gimnasio();
        gimnasio.agregar_socio(socio);
        gimnasio.agregar_socio(socio2);
        System.out.println("Cuota total del gimnasio: " + gimnasio.get_all_cuotas());
    }
}
