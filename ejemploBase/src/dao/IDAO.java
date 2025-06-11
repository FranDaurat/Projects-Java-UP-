package dao;

import java.util.ArrayList;

public interface IDAO<T> {
    public void insertar(T elemento) throws DAOException;
    public void eliminar(T id) throws DAOException;
    public void modificar(T elemento) throws DAOException;
    public T buscar(int id) throws DAOException;
    public ArrayList<T> buscarTodos() throws DAOException;
}
