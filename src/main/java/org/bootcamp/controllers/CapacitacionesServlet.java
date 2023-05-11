package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bootcamp.models.Capacitacion;
import org.bootcamp.repositories.CapacitacionRepositoryJdbcImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/capacitaciones")
public class CapacitacionesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CapacitacionRepositoryJdbcImpl repository = new CapacitacionRepositoryJdbcImpl();
        List<Capacitacion> capacitaciones;


        try {
            capacitaciones = repository.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        req.setAttribute("capacitaciones", capacitaciones);
        getServletContext().getRequestDispatcher("/WEB-INF/listarcapacitaciones.jsp").forward(req,resp);
    }
}
