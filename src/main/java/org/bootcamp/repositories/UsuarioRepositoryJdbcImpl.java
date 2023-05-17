package org.bootcamp.repositories;

import org.bootcamp.models.Usuario;
import org.bootcamp.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositoryJdbcImpl implements Repository{
    private Connection conn;

    public UsuarioRepositoryJdbcImpl() {
    }

    public Usuario loginUser(String username, String password) throws SQLException {
        try(Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios WHERE username = ? AND password = ?");
            statement.setString(1, username);
            statement.setString(2, password);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                Usuario usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setUsername(resultSet.getString("username"));
                usuario.setNombres(resultSet.getString("nombres"));
                usuario.setApellidos(resultSet.getString("apellidos"));
                usuario.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
                usuario.setRut(resultSet.getString("rut"));
                usuario.setRol(resultSet.getInt("rol"));
                return usuario;
            } else {
                return null;
            }
        }
    }

    public Usuario getById(int id){
        String sql = "SELECT * FROM usuarios WHERE id = ?";
        Usuario usuario = null;
        try(Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()){
                usuario = new Usuario();
                usuario.setId(resultSet.getInt("id"));
                usuario.setUsername(resultSet.getString("username"));
                usuario.setNombres(resultSet.getString("nombres"));
                usuario.setApellidos(resultSet.getString("apellidos"));
                usuario.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
                usuario.setRut(resultSet.getString("rut"));
                usuario.setRol(resultSet.getInt("rol"));
                usuario.setPassword(resultSet.getString("password"));
                return usuario;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardar(Usuario usuario) throws SQLException{
        String sql;
        if (usuario.getId() != 0 && usuario.getId() > 0){
            sql = "UPDATE usuarios SET username = ?, " +
                    "nombres = ?, " +
                    "apellidos = ?, " +
                    "fecha_nacimiento = ?, " +
                    "rut = ?, " +
                    "rol = ?, " +
                    "password = ? " +
                    "WHERE id = ?;";
        }else {
            sql = "INSERT INTO usuarios (username, nombres, apellidos, fecha_nacimiento, rut, rol, password) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
        }

        try(Connection connection = DatabaseConnection.getConnection()) {
            java.sql.Date sqlFechaNacimiento = new java.sql.Date(usuario.getFechaNacimiento().getTime());
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getUsername());
            statement.setString(2, usuario.getNombres());
            statement.setString(3, usuario.getApellidos());
            statement.setDate(4, sqlFechaNacimiento);
            statement.setString(5, usuario.getRut());
            statement.setInt(6, usuario.getRol());
            statement.setString(7, usuario.getPassword());

            if (usuario.getId() != 0 && usuario.getId() > 0){
                statement.setInt(8, usuario.getId());
            }
            statement.executeUpdate();
        }
    }

    public List<Usuario> listar() throws SQLException{
        List<Usuario> usuarios = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Usuario usuario = getUsuario(resultSet);

                usuarios.add(usuario);
            }
        }
        return usuarios;
    }

    public void delete(int id) throws SQLException{
        String sql = "delete from usuarios where id=?";
        try(Connection connection = DatabaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,id);
            statement.executeUpdate();
        }
    }

    private static Usuario getUsuario(ResultSet resultSet) throws SQLException {
        Usuario usuario = new Usuario();
        usuario.setId(resultSet.getInt("id"));
        usuario.setUsername(resultSet.getString("username"));
        usuario.setRut(resultSet.getString("rut"));
        usuario.setNombres(resultSet.getString("nombres"));
        usuario.setApellidos(resultSet.getString("apellidos"));
        usuario.setFechaNacimiento(resultSet.getDate("fecha_nacimiento"));
        return usuario;
    }
}
