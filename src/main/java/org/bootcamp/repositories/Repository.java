package org.bootcamp.repositories;

import org.bootcamp.models.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface Repository<T> {
    List<T> listar() throws SQLException;
    void delete(int id) throws SQLException;
}
