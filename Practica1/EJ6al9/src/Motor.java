public class Motor {
    private String marca;
    private int hp;
    private double cilindrada;

    public Motor(String marca, int hp, double cilindrada) {
        this.marca = marca;
        this.hp = hp;
        this.cilindrada = cilindrada;
    }

    public void detener() {
        System.out.println("Motor parado...");
    }

    public void arrancar() {
        System.out.println("Motor encendido...");
    }

    @Override
    public String toString() {
        return "Motor{" +
                "marca='" + marca + '\'' +
                ", hp=" + hp +
                ", cilindrada=" + cilindrada +
                '}';
    }
}
