import java.util.List;

public class Comercio {
    private String nombre;
    private List<Cliente> clientes;

    public Comercio(String nombre, List<Cliente> clientes) {
        this.nombre = nombre;
        this.clientes = clientes;
    }

    public void agregar_cliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public double calcular_necesidades_cliente(Cliente cliente) {
        return cliente.getVivienda().calcularCaloriasNecesarias();
    }

    public void mostrar_estado_cliente(Cliente cliente) {

    }
}
