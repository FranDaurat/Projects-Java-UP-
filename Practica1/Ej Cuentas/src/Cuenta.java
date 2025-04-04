public class Cuenta {
    private String titular;
    private int identificador;
    private double saldo;

    public Cuenta(String titular, int identificador) {
        this.titular = titular;
        this.identificador = identificador;
        this.saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void extraer(double saldo){
        if (this.saldo >= saldo) {
            this.saldo -= saldo;
        } else{
            System.out.println("Error, no puedes extraer esa cantidad. Saldo insuficiente.");

        }
    }

    public void depositar(double saldo){
        this.saldo += saldo;
    }

    @Override
    public String toString() {
        return "Titular: " + titular + "\n" +
                "ID: " + identificador + "\n" +
                "Saldo: $" + saldo;
    }
}
