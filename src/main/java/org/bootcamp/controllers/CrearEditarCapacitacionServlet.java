package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/capacitaciones/crear")
public class CrearEditarCapacitacionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/capacitacion.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rutCliente = req.getParameter("rutCliente");
        String dia = req.getParameter("dia");
        String hora = req.getParameter("hora");
        String lugar = req.getParameter("lugar");
        String duracion = req.getParameter("duracion");
        String cantidad = req.getParameter("cantidad");

        PrintWriter out = resp.getWriter();

        // Escribir en la respuesta HTTP al navegador
        out.println("<html><body>");
        out.println("<h1>" + rutCliente + "</h1>");
        out.println("<h1>" + dia + "</h1>");
        out.println("<h1>" + hora + "</h1>");
        out.println("<h1>" + lugar + "</h1>");
        out.println("<h1>" + duracion + "</h1>");
        out.println("<h1>" + cantidad + "</h1>");
        // Escribir en la consola del navegador usando JavaScript
        out.println("<script>");
        out.println("console.log('Hola desde MiServlet!');");
        out.println("</script>");

        out.println("</body></html>");
    }
}
