import java.util.List;

public class Casa extends Vivienda {
    private List<Estufa> estufas;

    public Casa(double m2, int habitantes, double aislacionTermica, List<Estufa> estufas) {
        super(m2, habitantes, aislacionTermica);
        this.estufas = estufas;
    }

    @Override
    public double calcularCaloriasNecesarias() {
        return (((700 * this.m2) * (1 - aislacionTermica)) - calcularCaloriasCubiertas());
    }

    public double calcularCaloriasCubiertas() {
        double total = 0;
        for (Estufa estufa: estufas){
            total += estufa.getCantidadQuemadores();
        }
        return (300 * total);
    }

}
