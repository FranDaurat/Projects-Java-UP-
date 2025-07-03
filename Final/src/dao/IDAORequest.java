package dao;
import modelo.Request;
import modelo.Usuario;
import java.util.List;

public interface IDAORequest {
    void insertar(Request request) throws DAOException;
    void actualizar(Request request) throws DAOException;
    void eliminar(int id) throws DAOException;
    Request obtenerPorId(int id) throws DAOException;
    List<Request> obtenerTodos() throws DAOException;
    List<Request> obtenerFavoritos(int userId) throws DAOException;
    Usuario login(String username, String password) throws DAOException;
    boolean registrar(String username, String password) throws DAOException;
}
