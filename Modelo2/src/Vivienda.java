import java.util.List;

public abstract class Vivienda {
    private int superficie;
    private boolean aislacion;
    private double porcentaje_aislacion;
    private List<Estufa> estufas;

    public Vivienda(int superficie, boolean aislacion, double porcentaje_aislacion, List<Estufa> estufas) {
        this.superficie = superficie;
        this.aislacion = aislacion;
        this.porcentaje_aislacion = porcentaje_aislacion;
        this.estufas = estufas;
    }

    public abstract int calorias_necesarias();

    public int calorias_cubiertas(){
        int total = 0;
        for (Estufa estufa : estufas){
            total += estufa.calorias_provistas();
        }
        return total;
    }

    public int getSuperficie() {
        return superficie;
    }

    public boolean isAislacion() {
        return aislacion;
    }

    public double getPorcentaje_aislacion() {
        if (isAislacion()){
            return porcentaje_aislacion;
        }else {
            return 0;
        }
    }

}
