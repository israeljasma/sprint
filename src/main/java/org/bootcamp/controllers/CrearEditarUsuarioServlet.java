package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bootcamp.models.Rol;
import org.bootcamp.models.Usuario;
import org.bootcamp.repositories.RolRepositoryJdbcImpl;
import org.bootcamp.services.LoginService;
import org.bootcamp.services.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@WebServlet("/usuarios/crear")
public class CrearEditarUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImpl();
        RolRepositoryJdbcImpl rolRepository = new RolRepositoryJdbcImpl();
        Optional<Usuario> userOptional = auth.getUser(req);

        List<Rol> roles;

        try {
            roles = rolRepository.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (userOptional.isPresent()){
            Rol rol = null;
            for (Rol getRol: roles){
                if (getRol.getId() == userOptional.get().getRol()){
                    rol = new Rol();
                    rol.setId(getRol.getId());
                    rol.setNombre(getRol.getNombre());
                    break;
                }
            }
            if (rol.getNombre().equals("administrador")){
                getServletContext().getRequestDispatcher("/usuario.html").forward(req, resp);
            }else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        }else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String nombres = req.getParameter("nombres");
        String apellidos = req.getParameter("apellidos");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String rut = req.getParameter("rut");
        String password = req.getParameter("password");

        LoginService auth = new LoginServiceImpl();
        RolRepositoryJdbcImpl rolRepository = new RolRepositoryJdbcImpl();
        Optional<Usuario> userOptional = auth.getUser(req);

        List<Rol> roles;

        try {
            roles = rolRepository.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (userOptional.isPresent()){
            Rol rol = null;
            for (Rol getRol: roles){
                if (getRol.getId() == userOptional.get().getRol()){
                    rol = new Rol();
                    rol.setId(getRol.getId());
                    rol.setNombre(getRol.getNombre());
                    break;
                }
            }

            if (rol.getNombre().equals("administrador")){
                //Con permisos
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
                //getServletContext().getRequestDispatcher("/usuarios/crear").forward(req,resp);
            }else {
                //Sin permisos
                resp.sendRedirect(req.getContextPath()+ "/login");
            }
        }else {
            //Sin sesion
            resp.sendRedirect(req.getContextPath()+ "/login");
        }
    }
}
