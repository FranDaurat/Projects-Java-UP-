import java.util.Scanner;

public class Main {

    public static String obtenerIniciales(String nombre, String apellido) {
        char inicialNombre = nombre.toUpperCase().charAt(0);
        char inicialApellido = apellido.toUpperCase().charAt(0);

        return "" + inicialNombre + inicialApellido;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Ingresa el apellido: ");
        String apellido = sc.nextLine();

        String iniciales = obtenerIniciales(nombre, apellido);

        System.out.println("Las iniciales de " + nombre + " " + apellido + " son: " + iniciales);

        sc.close();
    }
}
