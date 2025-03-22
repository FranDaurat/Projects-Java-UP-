public class Auto {
    private String marca;
    private String modelo;
    private int cantidadPuertas;
    private boolean aireAcondicionado;
    private Motor motor;
    private CajaVelocidades caja;
    private Rueda[] ruedas;

    // Constructor
    public Auto(String marca, String modelo, int cantidadPuertas, boolean aireAcondicionado, Motor motor, CajaVelocidades caja, Rueda[] ruedas) {
        this.marca = marca;
        this.modelo = modelo;
        this.cantidadPuertas = cantidadPuertas;
        this.aireAcondicionado = aireAcondicionado;
        this.motor = motor;
        this.caja = caja;
        this.ruedas = ruedas;
    }

    // Métodos
    public void arrancar() {
        motor.arrancar();
        System.out.println("El auto " + marca + " " + modelo + " está en marcha.");
    }

    public void detener() {
        motor.detener();
        System.out.println("El auto " + marca + " " + modelo + " se ha detenido.");
    }

    public void cambiarMarcha(int marcha) {
        caja.setMarchas(marcha);
        System.out.println("El auto ha cambiado a la marcha " + marcha);
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Auto [Marca: ").append(marca)
                .append(", Modelo: ").append(modelo)
                .append(", Puertas: ").append(cantidadPuertas)
                .append(", Aire Acondicionado: ").append(aireAcondicionado ? "Sí" : "No")
                .append(", Motor: ").append(motor)
                .append(", Caja: ").append(caja)
                .append(", Ruedas: ");
        for (Rueda rueda : ruedas) {
            info.append("\n  ").append(rueda);
        }
        return info.toString();
    }
}
