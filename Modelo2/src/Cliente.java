public class Cliente {
    private String nombre;
    private String apellido;
    private String telefono;
    private Vivienda vivienda;
    public Cliente(String nombre, String apellido, String telefono, Vivienda vivienda) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.vivienda = vivienda;
    }

    public String consultar_datos() {
        return  "nombre: " + nombre + "apellido: " + apellido + "teléfono: " + telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public String getTelefono() {
        return telefono;
    }
}
