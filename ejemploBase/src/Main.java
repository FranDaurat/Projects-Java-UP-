import dao.DAOAlumno;
import dao.DAOException;
import modelo.Alumno;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DAOAlumno tablaAlumno = new DAOAlumno();
        Alumno nuevo = new Alumno(1,"juan","perez",10);
        try {
            tablaAlumno.insertar(nuevo);
        }
        catch (DAOException e){
            System.err.println(e.getMessage());
        }
    }
}