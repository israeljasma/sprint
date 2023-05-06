package org.bootcamp.repositories;

import org.bootcamp.models.Capacitacion;
import org.bootcamp.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CapacitacionRepositoryJdbcImpl implements Repository{
    @Override
    public List<Capacitacion> listar() throws SQLException {
        List<Capacitacion> capacitaciones = new ArrayList<>();
        try(Connection connection = DatabaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM capacitaciones");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Capacitacion capacitacion = getCapacitacion(resultSet);

                capacitaciones.add(capacitacion);
            }
        }
        return capacitaciones;
    }

    private static Capacitacion getCapacitacion(ResultSet resultSet) throws SQLException {
        Capacitacion capacitacion = new Capacitacion();
        capacitacion.setId(resultSet.getInt("id"));
        capacitacion.setRutCliente(resultSet.getString("rut_cliente"));
        capacitacion.setDia(resultSet.getDate("dia"));
        capacitacion.setHora(LocalTime.parse(resultSet.getString("hora")));
        capacitacion.setLugar(resultSet.getString("lugar"));
        capacitacion.setDuracion(resultSet.getInt("duracion"));
        capacitacion.setCantidad(resultSet.getInt("cantidad"));
        return capacitacion;
    }
}
