import java.util.List;

public class Departamento extends Vivienda {
    private int cantidad_habitantes;

    public Departamento(int superficie, boolean aislacion, double porcentaje_aislacion, int cantidad_habitantes, List<Estufa> estufas) {
        super(superficie, aislacion, porcentaje_aislacion, estufas);
        this.cantidad_habitantes = cantidad_habitantes;
    }

    @Override
    public int calorias_necesarias() {
        return (int) ((500*this.getSuperficie() + (100*cantidad_habitantes) - calorias_cubiertas() * (1 - getPorcentaje_aislacion() )));
    }

}
