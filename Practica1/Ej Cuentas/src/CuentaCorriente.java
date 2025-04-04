public class CuentaCorriente extends Cuenta {
    private double limiteDescubierto;

    public CuentaCorriente(String titular, int identificador, double limiteDescubierto) {
        super(titular, identificador);
        this.limiteDescubierto = limiteDescubierto;
    }

    @Override
    public void extraer(double monto) {
        if ((getSaldo() - monto) >= -limiteDescubierto) {
            super.extraer(monto);
        } else {
            System.out.println("Error: límite de descubierto excedido.");
        }
    }


    @Override
    public String toString() {
        return super.toString() + "\nLímite de descubierto: $" + limiteDescubierto;
    }
}
