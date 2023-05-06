package org.bootcamp.repositories;

import org.bootcamp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContactoRepositoryJdbcImpl {
    private Connection conn;

    public ContactoRepositoryJdbcImpl() {
    }

    public int createContacto(String nombre, int telefono, String email, String mensaje) throws SQLException{
        try(Connection connection = DatabaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO contacto (nombre, telefono, email, mensaje) VALUES (?, ?, ?, ?)");
            statement.setString(1, nombre);
            statement.setInt(2, telefono);
            statement.setString(3, email);
            statement.setString(4, mensaje);

            return statement.executeUpdate();
        }
    }
}
