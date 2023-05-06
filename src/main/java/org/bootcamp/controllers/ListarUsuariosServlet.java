package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bootcamp.models.Usuario;
import org.bootcamp.repositories.UsuarioRepositoryJdbcImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/listarusuarios")
public class ListarUsuariosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioRepositoryJdbcImpl repository = new UsuarioRepositoryJdbcImpl();
        List<Usuario> usuarios =  null;

        try {
            usuarios = repository.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("usuarios", usuarios);
        getServletContext().getRequestDispatcher("/listarusuarios.jsp").forward(req, resp);
    }
}
