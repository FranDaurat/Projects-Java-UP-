public class EntrenadorPersonal extends Actividad {
    private float cost_hora;
    private int horas;

    public EntrenadorPersonal(String codigo, String nombre, float cost_hora, int horas) {
        super(codigo, nombre);
        this.cost_hora = cost_hora;
        this.horas = horas;
    }

    public float valor_actividad(){
        return (float) getCost_hora() * getHoras();
    }

    public float getCost_hora() {
        return cost_hora;
    }

    public int getHoras() {
        return horas;
    }
}
