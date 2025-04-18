public class Departamento extends Vivienda {

    public Departamento(double m2, int habitantes, double aislacionTermica) {
        super(m2, habitantes, aislacionTermica);
    }

    @Override
    public double calcularCaloriasNecesarias() {
        return ( ((500 * m2) + (100 * habitantes)) * (1 - aislacionTermica) );
    }
}
