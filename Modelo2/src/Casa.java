import java.util.List;

public class Casa extends Vivienda {

    public Casa(int superficie, boolean aislacion, double porcentaje_aislacion, List<Estufa> estufas) {
        super(superficie, aislacion, porcentaje_aislacion, estufas);
    }

    @Override
    public int calorias_necesarias() {
        return (int) (700*getSuperficie() - calorias_cubiertas() * (1 - getPorcentaje_aislacion()));
    }

}
