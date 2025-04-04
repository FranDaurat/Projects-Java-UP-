//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CajaDeAhorro caja = new CajaDeAhorro("Fran", 123, 0.02); // 2% mensual
        caja.depositar(10000);
        caja.acreditarInteres();
        System.out.println("Caja de Ahorro:");
        System.out.println(caja);

        System.out.println("--------------------------");

        // ✅ Cuenta Corriente
        CuentaCorriente cc = new CuentaCorriente("Poncio", 456, 500); // puede llegar a -500
        cc.depositar(200);
        cc.extraer(600); // llega a -400 → válido
        cc.extraer(200); // intento de llegar a -600 → NO válido
        System.out.println("Cuenta Corriente:");
        System.out.println(cc);
    }
}