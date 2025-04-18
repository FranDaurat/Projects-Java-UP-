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
        return "Nombre: " + this.nombre + ", Apellido: " + this.apellido + ", Teléfono: " + this.telefono;
    }

    public Vivienda getVivienda() {
        return vivienda;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getTelefono() {
        return telefono;
    }
}
