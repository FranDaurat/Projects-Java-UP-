public class Main {
    public static void main(String[] args) {
        Fecha miFecha = new Fecha(10, 5, 2025);
        Alumno nuevo= new Alumno("Juan");
        Alumno nuevo1= new Alumno("Ana");
        Alumno nuevo2= new Alumno("Carlos");

        Fecha fechaNac=new Fecha(10,1,2000);
        Persona nuevaPersona=new Persona("Juan","4444444",new Fecha(10,1,2000));
        System.out.println(nuevaPersona);
        System.out.println("Edad: " +nuevaPersona.edad());

        fechaNac.setAnio(2020);
        Persona hijo=new Persona("Julieta","480000",new Fecha(1,1,2020));
        System.out.println(hijo);
        System.out.println("Edad: " +nuevaPersona.edad());
        System.out.println("Edad: " +hijo.edad());

        Empleado miEmpleado=new Empleado("Jorge","350000",new Fecha(2,5,1999),"100");
        System.out.println(miEmpleado.getNombre());
        System.out.println(miEmpleado.edad());
        System.out.println(miEmpleado.cobrarSueldo());
        /*System.out.println(nuevo);
        System.out.println(Alumno.getUltimoLegajo());
        System.out.println(nuevo1);
        System.out.println(nuevo2);*/

    }
}