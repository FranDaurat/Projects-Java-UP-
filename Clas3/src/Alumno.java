public class Alumno {
    private static int ultimoLegajo=1000;
    private int legajo;
    private String nombre;

    public Alumno(String nombre)
    {   this.nombre=nombre;
        legajo=ultimoLegajo;
        aumentarLegajo();
    }
    private static void aumentarLegajo()
    {
        ultimoLegajo++;
    }
    public static int getUltimoLegajo()
    {
        return ultimoLegajo;
    }
    public String toString()
    {
        return "Legajo: " + legajo + " Nombre: " + nombre +"\n" + "Proximo legajo" + getUltimoLegajo() ;
    }
}
