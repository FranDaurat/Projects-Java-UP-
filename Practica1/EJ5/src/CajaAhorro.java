public class CajaAhorro {
    private int numero_cuenta;
    private String titular;
    private double saldo;

    public CajaAhorro(int numero_cuenta, String titular, double saldo) {
        this.numero_cuenta = numero_cuenta;
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(int monto) {
        this.saldo+=monto;
    }

    public void extraer(int monto) {
        this.saldo-=monto;
    }

    @Override
    public String toString() {
        return "Cuenta N°" + numero_cuenta + ", Titular: " + titular + ", Saldo: $" + saldo;
    }
}
