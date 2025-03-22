//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        CajaAhorro cuenta1 = new CajaAhorro(1000, "juan", 10000);
        CajaAhorro cuenta2 = cuenta1;

        cuenta1.depositar(1000);
        cuenta1.extraer(5000);

        System.out.println(cuenta1);
        System.out.println(cuenta2);

    }
}