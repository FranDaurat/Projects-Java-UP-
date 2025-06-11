import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Comercio comercio = new Comercio();

        Estufa estufa1 = new Estufa(3);
        Estufa estufa2 = new Estufa(5);

        Estufa estufa3 = new Estufa(5);
        Estufa estufa4 = new Estufa(7);

        Vivienda vivienda1 = new Casa(250,true,0.3,List.of(estufa1,estufa2));
        Vivienda vivienda2 = new Departamento(100, false,0,3,List.of(estufa3,estufa4));

        comercio.agregar_cliente("carlos","rodriguez","112233445566",vivienda1);
        comercio.agregar_cliente("gimeenz","jirafales","112233213566",vivienda2);

        System.out.println("Las calorias necesarias para el cliente carlos son: " + comercio.calorias_a_cubrir("112233445566"));
        System.out.println("Las calorias necesarias para el cliente gimeenz son: " + comercio.calorias_a_cubrir("112233213566"));
        System.out.println("Las calorias necesarias para todos los clientes son: " + comercio.calorias_totales_necesarias());

    }
}
