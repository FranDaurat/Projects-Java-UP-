public class CajaDeAhorro extends Cuenta {
    private double interesMensual;

    public CajaDeAhorro(String titular, int identificador, double interesMensual) {
        super(titular, identificador);
        this.interesMensual = interesMensual;
    }

    public void acreditarInteres() {
        double interes = getSaldo() * interesMensual;
        depositar(interes);
    }

    @Override
    public String toString() {
        return super.toString() + "\nInterés mensual: " + interesMensual;
    }
}
