import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Gimnasio gimnasio = new Gimnasio();

        Pileta pileta = new Pileta("123", "piletoide",10000);
        EntrenadorPersonal entrenadero = new EntrenadorPersonal("134","biqueiful",100,5);

        gimnasio.agregar_socio(12345,"carlero", 10000, List.of(pileta, entrenadero));
        System.out.println("el socio hace: " + gimnasio.consultar_actividad(12345));

        gimnasio.importe_socio();
    }
}

/*
relacion de asociacion entre Gimnasio y socio. Un gimnasio puede tener varios socios y varios socios pueden estar en el gimnasio
relacion de asociacion entre Socio y actividad. Un socio puede realizar varias actividades y varias actividades pueden ser realizadas por varios socios.
relacion de herencia entre actividad, pileta, entrenadorPersonal y general. tanto pileta como general como entrenadorPersonal son actividades
por lo que todas van a contar con un nombre y un codigo.
*/