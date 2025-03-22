public class Rueda {
    private double radio;
    private String color;
    private String material;

    public Rueda(double radio, String color, String material) {
        this.radio = radio;
        this.color = color;
        this.material = material;
    }

    public void girar() {
        System.out.println("La rueda de " + material + " está girando.");
    }

    @Override
    public String toString() {
        return "Rueda [Radio: " + radio + " Color: " + color + ", Material: " + material + "]";
    }

}

