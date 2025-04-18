public class Estufa {
    private int cantidadQuemadores;

    public Estufa(int cantidadQuemadores) {
        this.cantidadQuemadores = cantidadQuemadores;
    }

    public int getCantidadQuemadores() {
        return cantidadQuemadores;
    }

    public double caloriasCubiertas() {
        return cantidadQuemadores * 300;
    }
}
