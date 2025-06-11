package dao;

import modelo.Alumno;

import java.sql.*;
import java.util.ArrayList;

public class DAOAlumno implements IDAO<Alumno> {
    private String DB_JDBC_DRIVER="org.h2.Driver";
    private String DB_URL="jdbc:h2:~/test";
    private String DB_USER="sa";
    private String DB_PASSOWRD="";

    @Override
    public void insertar(Alumno elemento) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSOWRD);
            preparedStatement = connection.prepareStatement("INSERT INTO TEST VALUES(?,?,?,?)");
            preparedStatement.setInt(1,elemento.getId());
            preparedStatement.setString(2,elemento.getNombre());
            preparedStatement.setString(3,elemento.getApellido());
            preparedStatement.setInt(4,elemento.getNota());
            int resultado = preparedStatement.executeUpdate();
            System.out.println("Se agrego " + resultado);
        }

        catch (ClassNotFoundException | SQLException e){
            throw new DAOException("No se pudo insertar: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(Alumno alumno) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSOWRD);
            preparedStatement = connection.prepareStatement("DELETE FROM ALUMNO WHERE ID=(?)");
            preparedStatement.setInt(1,alumno.getId());
            int resultado = preparedStatement.executeUpdate();
            System.out.println("Se agrego " + resultado);
        }

        catch (ClassNotFoundException | SQLException e){
            throw new DAOException("No se pudo insertar: " + e.getMessage());
        }
    }

    @Override
    public void modificar(Alumno elemento) {

    }

    @Override
    public Alumno buscar(int id) throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Alumno alumno = null;
        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSOWRD);
            preparedStatement = connection.prepareStatement("SELECT * FROM ALUMNO WHERE ID=(?)");
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                alumno=new Alumno();
                alumno.setId(rs.getInt("ID"));
                alumno.setApellido(rs.getString("APELLIDO"));
                alumno.setNombre(rs.getString("NOMBRE"));
            }
        }

        catch (ClassNotFoundException | SQLException e){
            throw new DAOException("No se pudo insertar: " + e.getMessage());
        }

        finally {
            try {
                preparedStatement.close();
            }
            catch (SQLException s){
                throw new DAOException("No se pudo conectar " + s.getMessage());
            }
        }

        return  alumno;
    }

    @Override
    public ArrayList<Alumno> buscarTodos() throws DAOException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        Alumno alumno = null;
        ArrayList<Alumno> alumnos = new ArrayList<>();

        try {
            Class.forName(DB_JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSOWRD);
            preparedStatement = connection.prepareStatement("SELECT * FROM ALUMNO");
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                alumno=new Alumno();
                alumno.setId(rs.getInt("ID"));
                alumno.setApellido(rs.getString("APELLIDO"));
                alumno.setNombre(rs.getString("NOMBRE"));
            }
        }
        catch (ClassNotFoundException | SQLException e){
            throw new DAOException("Ocurrio un error en la base de datos " + e.getMessage());
        }
        return alumnos;
    }
}
