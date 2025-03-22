import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Hora hora1 = new Hora(3,30,45);
        Hora hora2 = new Hora(2,30,50);

        System.out.println("Estado inicial de la hora 1: " + hora1);
        System.out.println("Estado inicial de la hora 2: " + hora2);

        hora1.incrementar(30);
        hora2.incrementar(30);

        System.out.println("Estado final de la hora 1: " + hora1);
        System.out.println("Estado final de la hora 2: " + hora2);

    }
}
