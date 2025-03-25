public class Fecha {
   private int dia;
    private int mes;
    private int anio;

    public Fecha()
    {dia=1;
     mes=1;
     anio=2000;}
    public Fecha(int d, int m, int a)
    {   dia=d;
        mes=m;
        anio=a;
    }
    public int fechaDiferencia(Fecha otra)
    {
        return otra.anio-anio;
    }
    public void fechaSumaDias(int cantidadDias)
    {
        this.dia+=cantidadDias;
        mes+=dia/31;
        anio+=mes/12;
        mes=mes%12;
        dia=dia%31;
    }
    public String toString()
    {
        return dia+"/"+mes+"/"+anio;
    }
    public int getDia()
    {
        return dia;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
}
