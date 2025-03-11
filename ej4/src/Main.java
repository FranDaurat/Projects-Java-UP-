import java.util.Scanner;

public class Main {

    public int suma_tres_enteros(int a, int b, int c){
        return a+b+c;
    }

    public long producto_long(int a, int b){
        long result;
        result = a*b;
        return result;
    }

    public long calcular(int a, int b){
        return producto_long(suma_tres_enteros((int)producto_long(a,b),(int)producto_long(b,5),2), suma_tres_enteros(a,b,1));
    }

    public static void main(String[] args) {
        Scanner lector;
        lector = new Scanner(System.in);
        Main m = new Main();
        long result;
        int num1,num2;

        System.out.println("Ingresa un numero: ");
        num1=lector.nextInt();

        System.out.println("Ingresa un numero: ");
        num2=lector.nextInt();

        result = m.calcular(num1, num2);
        System.out.println(result);
    }
}