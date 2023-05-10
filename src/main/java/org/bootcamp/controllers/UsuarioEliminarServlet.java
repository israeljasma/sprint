package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bootcamp.repositories.UsuarioRepositoryJdbcImpl;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/usuarios/eliminar")
public class UsuarioEliminarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioRepositoryJdbcImpl repository = new UsuarioRepositoryJdbcImpl();
        int id;

        try {
            id = Integer.parseInt(req.getParameter("id"));
        }catch (NumberFormatException e){
            id = 0;
        }

        if (id > 0 ){
            try {
                repository.delete(id);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        resp.sendRedirect(req.getContextPath()+ "/listarusuarios");
    }
}
