public class Estufa {
    private int cantidad_quemadores;

    public Estufa(int cantidad_quemadores) {
        this.cantidad_quemadores = cantidad_quemadores;
    }

    public int calorias_provistas(){
        return (300*cantidad_quemadores);
    }
}
