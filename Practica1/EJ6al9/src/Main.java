public class Main {
    public static void main(String[] args) {
        Rueda rueda1 = new Rueda(17, "Negro", "Aleación");
        Rueda rueda2 = new Rueda(17, "Negro", "Aleación");
        Rueda rueda3 = new Rueda(17, "Negro", "Aleación");
        Rueda rueda4 = new Rueda(17, "Negro", "Aleación");
        Rueda[] ruedas = {rueda1, rueda2, rueda3, rueda4};

        Motor motor = new Motor("Toyota", 150, 1.6);

        CajaVelocidades caja = new CajaVelocidades("Toyota", 5, 'L');

        Auto auto = new Auto("Toyota", "Corolla", 4, true, motor, caja, ruedas);

        System.out.println(auto);

        auto.arrancar();
        auto.cambiarMarcha(3);
        auto.detener();
    }
}
