package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bootcamp.repositories.ContactoRepositoryJdbcImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/contacto")
public class ContactoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/contacto.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContactoRepositoryJdbcImpl contactoRepository = new ContactoRepositoryJdbcImpl();
        String nombre = req.getParameter("nombre");
        String telefono = req.getParameter("telefono");
        String email = req.getParameter("email");
        String mensaje = req.getParameter("mensaje");

        int result;

        try {
            result = contactoRepository.createContacto(nombre, Integer.parseInt(telefono), email, mensaje);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        if (result != 0) {
            // Escribir en la respuesta HTTP al navegador
            out.println("<h1>" + nombre + "</h1>");
            out.println("<h1>" + telefono + "</h1>");
            out.println("<h1>" + email + "</h1>");
            out.println("<h1>" + mensaje + "</h1>");
            // Escribir en la consola del navegador usando JavaScript
            out.println("<script>");
            out.println("console.log('Hola desde MiServlet!');");
            out.println("</script>");

            out.println("</body></html>");
        }else {
            out.println("<h1>Ocurrio un error al crear el formulario de contacto</h1>");
            out.println("<script>");
            out.println("console.log('Hola desde MiServlet!');");
            out.println("</script>");

            out.println("</body></html>");
        }
    }
}
