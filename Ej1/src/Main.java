import java.util.Scanner;

public class Main {
    public double celsius_to_fahrenheit(double celsius) {
        double fahrenheit = (celsius * 9.0 / 5.0) + 32;
        return fahrenheit;
    }

    public double fahrenheit_to_celsius(double fahrenheit) {
        double celsius = (fahrenheit - 32.0) * 5.0 / 9.0;
        return celsius;
    }


    public static void main(String[] args) {
        Scanner lector;
        lector = new Scanner(System.in);
        Main m = new Main();
        double celsius,fahrenheit,celsius_convert,fahrenheit_convert;

        System.out.println("Ingresa una temperatura en celsius: ");
        celsius=lector.nextInt();

        System.out.println("Ingresa una temperatura en fahrenheit: ");
        fahrenheit=lector.nextInt();

        celsius_convert = m.celsius_to_fahrenheit(celsius);
        fahrenheit_convert = m.fahrenheit_to_celsius(fahrenheit);

        System.out.println("La conversion de los grados celsius ingresados es de: " + celsius_convert + "°");
        System.out.println("La conversion de los grados fahrenheit ingresados es de: " + fahrenheit_convert + "°");

    }
}