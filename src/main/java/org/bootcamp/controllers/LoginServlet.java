package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.bootcamp.models.Rol;
import org.bootcamp.models.Usuario;
import org.bootcamp.repositories.RolRepositoryJdbcImpl;
import org.bootcamp.repositories.UsuarioRepositoryJdbcImpl;
import org.bootcamp.services.LoginService;
import org.bootcamp.services.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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
                resp.sendRedirect(req.getContextPath() + "/dashboard");
            }else if(rol.getNombre().equals("profesional")){
                resp.sendRedirect(req.getContextPath() + "/dashboard");
            }else {
                resp.sendRedirect(req.getContextPath() + "/contacto");
            }
        }else {
            getServletContext().getRequestDispatcher("/login.html").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UsuarioRepositoryJdbcImpl repository = new UsuarioRepositoryJdbcImpl();
        RolRepositoryJdbcImpl rolRepository = new RolRepositoryJdbcImpl();
        List<Rol> roles;
        Usuario user;

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            roles = rolRepository.listar();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            user = repository.loginUser(username,password);
            if (user != null){
                HttpSession session = req.getSession();
                session.setAttribute("user", user);

                Rol rol = null;
                for (Rol getRol: roles){
                    if (getRol.getId() == user.getRol()){
                        rol = new Rol();
                        rol.setId(getRol.getId());
                        rol.setNombre(getRol.getNombre());
                        break;
                    }
                }
                if (rol.getNombre().equals("administrador")){
                    resp.sendRedirect(req.getContextPath() + "/dashboard");
                }else {
                    resp.sendRedirect(req.getContextPath() + "/contacto");
                }
            }else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        } catch (SQLException e) {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }
}
