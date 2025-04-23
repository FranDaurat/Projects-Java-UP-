import java.util.ArrayList;
import java.util.List;

public class Comercio {
    private String nombre = "sancor";
    private List<Cliente> clientes = new ArrayList<>();

    public void agregar_cliente(String nombre, String apellido, String telefono, Vivienda vivienda){
        Cliente cliente = new Cliente(nombre, apellido, telefono, vivienda);
        clientes.add(cliente);
    }

    public int calorias_a_cubrir(String telefono){
        int calorias = 0;
        for (Cliente cliente : clientes){
            if(cliente.getTelefono().equals(telefono)){
                calorias = cliente.getVivienda().calorias_necesarias();
            }
        }
        return calorias;
    }

    public Cliente consultar_cliente(String telefono){
        Cliente cliente=null;
        for (Cliente clientito : clientes){
            if (clientito.equals(telefono)){
                cliente=clientito;
            }
        }
        return cliente;
    }

    public int calorias_totales_necesarias(){
        int total = 0;
        for (Cliente cliente : clientes){
            total += cliente.getVivienda().calorias_necesarias();
        }
        return total;
    }

}
