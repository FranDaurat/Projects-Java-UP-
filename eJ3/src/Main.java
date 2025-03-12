import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce el valor de a: ");
        double a = sc.nextDouble();

        System.out.print("Introduce el valor de b: ");
        double b = sc.nextDouble();

        System.out.print("Introduce el valor de c: ");
        double c = sc.nextDouble();


        double discriminante = b * b - 4 * a * c;

        double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);

        System.out.println("Solución 1 = " + x1);
        System.out.println("Solución 2 = " + x2);

        sc.close();
    }
}
