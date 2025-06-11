package dao;

import modelo.Request;
import modelo.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAORequest implements IDAORequest {

    private static final String DB_URL = "jdbc:h2:./requestdb;AUTO_SERVER=TRUE";
    private static final String DB_USER = "sa";
    private static final String DB_PASSWORD = "";

    public DAORequest() {
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE TABLE IF NOT EXISTS request (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "method VARCHAR(10), " +
                    "url VARCHAR(1000), " +
                    "headers CLOB, " +
                    "body CLOB, " +
                    "response CLOB, " +
                    "timestamp TIMESTAMP, " +
                    "favorite_name VARCHAR(255), " +
                    "user_id INT)");

            stmt.execute("CREATE TABLE IF NOT EXISTS usuario (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(100) UNIQUE, " +
                    "password VARCHAR(100))");

        } catch (SQLException e) {
            System.err.println("Error al crear la tabla: " + e.getMessage());
        }
    }

    @Override
    public void insertar(Request r) throws DAOException {
        String sql = "INSERT INTO request (method, url, headers, body, response, timestamp, favorite_name, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, r.getMethod());
            ps.setString(2, r.getUrl());
            ps.setString(3, r.getHeaders());
            ps.setString(4, r.getBody());
            ps.setString(5, r.getResponse());
            ps.setTimestamp(6, Timestamp.valueOf(r.getTimestamp()));
            ps.setString(7, r.getFavoriteName());
            ps.setInt(8, r.getUserId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error al insertar request: " + e.getMessage());
        }
    }

    @Override
    public void actualizar(Request r) throws DAOException {
        String sql = "UPDATE request SET method=?, url=?, headers=?, body=?, response=?, timestamp=?, favorite_name=? WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, r.getMethod());
            ps.setString(2, r.getUrl());
            ps.setString(3, r.getHeaders());
            ps.setString(4, r.getBody());
            ps.setString(5, r.getResponse());
            ps.setTimestamp(6, Timestamp.valueOf(r.getTimestamp()));
            ps.setString(7, r.getFavoriteName());
            ps.setInt(8, r.getId());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error al actualizar request: " + e.getMessage());
        }
    }

    @Override
    public void eliminar(int id) throws DAOException {
        String sql = "DELETE FROM request WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new DAOException("Error al eliminar request: " + e.getMessage());
        }
    }

    @Override
    public Request obtenerPorId(int id) throws DAOException {
        String sql = "SELECT * FROM request WHERE id=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()){
                return mapResult(rs);
            }

        } catch (SQLException e) {
            throw new DAOException("Error al obtener request: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<Request> obtenerTodos() throws DAOException {
        List<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM request ORDER BY timestamp DESC";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) list.add(mapResult(rs));

        } catch (SQLException e) {
            throw new DAOException("Error al obtener requests: " + e.getMessage());
        }
        return list;
    }

    @Override
    public List<Request> obtenerFavoritos(int userId) throws DAOException {
        List<Request> list = new ArrayList<>();
        String sql = "SELECT * FROM request WHERE favorite_name IS NOT NULL AND user_id = ? ORDER BY favorite_name";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(mapResult(rs));
            }

        } catch (SQLException e) {
            throw new DAOException("Error al obtener favoritos: " + e.getMessage());
        }
        return list;
    }


    private Request mapResult(ResultSet rs) throws SQLException {
        Request r = new Request();
        r.setId(rs.getInt("id"));
        r.setMethod(rs.getString("method"));
        r.setUrl(rs.getString("url"));
        r.setHeaders(rs.getString("headers"));
        r.setBody(rs.getString("body"));
        r.setResponse(rs.getString("response"));
        r.setUserId(rs.getInt("user_id"));
        Timestamp ts = rs.getTimestamp("timestamp");
        if (ts != null) r.setTimestamp(ts.toLocalDateTime());
        r.setFavoriteName(rs.getString("favorite_name"));
        return r;
    }

    public void eliminarFavoritoPorNombre(String nombre) throws DAOException {
        String sql = "DELETE FROM request WHERE favorite_name = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombre);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error al eliminar favorito: " + e.getMessage());
        }
    }

    public Usuario login(String username, String password) {
        String sql = "SELECT * FROM usuario WHERE username=? AND password=?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                return u;
            }
        } catch (SQLException e) {
            System.err.println("Error en login: " + e.getMessage());
        }
        return null;
    }

    public boolean registrar(String username, String password) {
        String sql = "INSERT INTO usuario (username, password) VALUES (?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

}
