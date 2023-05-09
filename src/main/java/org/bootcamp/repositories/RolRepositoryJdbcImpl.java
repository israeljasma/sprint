package org.bootcamp.repositories;

import org.bootcamp.models.Rol;
import org.bootcamp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RolRepositoryJdbcImpl {
    private Connection conn;

    public RolRepositoryJdbcImpl() {
    }

    public List<Rol> listar() throws SQLException {
        List<Rol> roles = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM roles");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Rol rol = getRol(resultSet);
                roles.add(rol);
            }
        }
        return roles;
    }

    private static Rol getRol(ResultSet resultSet) throws SQLException {
        Rol rol = new Rol();
        rol.setId(resultSet.getInt("id"));
        rol.setNombre(resultSet.getString("nombre"));
        return rol;
    }
}
