import java.util.List;

public abstract class Vivienda {
    protected double m2;
    protected int habitantes;
    protected double aislacionTermica;

    public Vivienda(double m2, int habitantes, double aislacionTermica) {
        this.m2 = m2;
        this.habitantes = habitantes;
        this.aislacionTermica = aislacionTermica;
    }

    public abstract double calcularCaloriasNecesarias();
}
