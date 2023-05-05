package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/usuario.html").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String nombres = req.getParameter("nombres");
        String apellidos = req.getParameter("apellidos");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String rut = req.getParameter("rut");
        String password = req.getParameter("password");

        PrintWriter out = resp.getWriter();

        // Escribir en la respuesta HTTP al navegador
        out.println("<html><body>");
        out.println("<h1>" + nombres + "</h1>");
        out.println("<h1>" + apellidos + "</h1>");
        out.println("<h1>" + fechaNacimiento + "</h1>");
        out.println("<h1>" + rut + "</h1>");
        out.println("<h1>" + password + "</h1>");
        // Escribir en la consola del navegador usando JavaScript
        out.println("<script>");
        out.println("console.log('Hola desde MiServlet!');");
        out.println("</script>");

        out.println("</body></html>");
    }
}
