import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        Estufa estufa1 = new Estufa(3);
        List<Estufa> estufas1 = new ArrayList<>();
        estufas1.add(estufa1);

        Estufa estufa2 = new Estufa(2);
        List<Estufa> estufas2 = new ArrayList<>();

        Estufa estufa3 = new Estufa(4);
        estufas2.add(estufa2);
        estufas2.add(estufa3);

        Vivienda vivienda1 = new Casa(123.2,3,0.2,estufas1);
        Cliente cliente1 = new Cliente("carlos","fernandez","1122334455",vivienda1);

        Vivienda vivienda2 = new Departamento(200,4,0.3);
        Cliente cliente2 = new Cliente("gimenez","gutierrez","1122355466",vivienda2);


        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        Comercio comercio = new Comercio("sancor", clientes);

        for (Cliente cliente : clientes) {
            double caloriasNecesarias = comercio.calcular_necesidades_cliente(cliente);
            System.out.println("Cliente: " + cliente.getNombre() + " " + cliente.getApellido());
            System.out.println("Calorías necesarias: " + caloriasNecesarias);
        }
        
        double necesidadesTotales = 0;
        for (Cliente cliente : clientes) {
            necesidadesTotales += comercio.calcular_necesidades_cliente(cliente);
        }
        System.out.println("Calorías totales necesarias para todos los clientes: " + necesidadesTotales);
    }
}