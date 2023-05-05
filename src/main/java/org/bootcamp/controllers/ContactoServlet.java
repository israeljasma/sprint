package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/contacto")
public class ContactoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/contacto.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nombre = req.getParameter("nombre");
        String telefono = req.getParameter("telefono");
        String email = req.getParameter("email");
        String mensaje = req.getParameter("mensaje");

        PrintWriter out = resp.getWriter();

        // Escribir en la respuesta HTTP al navegador
        out.println("<html><body>");
        out.println("<h1>" + nombre + "</h1>");
        out.println("<h1>" + telefono + "</h1>");
        out.println("<h1>" + email + "</h1>");
        out.println("<h1>" + mensaje + "</h1>");
        // Escribir en la consola del navegador usando JavaScript
        out.println("<script>");
        out.println("console.log('Hola desde MiServlet!');");
        out.println("</script>");

        out.println("</body></html>");
    }
}
