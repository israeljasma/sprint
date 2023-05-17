package org.bootcamp.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.bootcamp.models.Rol;
import org.bootcamp.models.Usuario;
import org.bootcamp.repositories.RolRepositoryJdbcImpl;
import org.bootcamp.repositories.UsuarioRepositoryJdbcImpl;
import org.bootcamp.services.LoginService;
import org.bootcamp.services.LoginServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@WebServlet({"/usuarios/agregar", "/usuarios/editar"})
public class CrearEditarUsuarioServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImpl();
        RolRepositoryJdbcImpl rolRepository = new RolRepositoryJdbcImpl();
        UsuarioRepositoryJdbcImpl userRepository = new UsuarioRepositoryJdbcImpl();
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
                if ((req.getServletPath()).equals("/usuarios/editar")){
                    try {
                        Usuario getUserId = userRepository.getById(Integer.parseInt(req.getParameter("id")));
                        req.setAttribute("getUserId", getUserId);
                        req.setAttribute("roles", roles);
                        getServletContext().getRequestDispatcher("/WEB-INF/usuario.jsp").forward(req, resp);
                    }catch (NumberFormatException e){
                        resp.sendRedirect(req.getContextPath() + "/usuarios");
                    }
                }else {
                    req.setAttribute("roles", roles);
                    getServletContext().getRequestDispatcher("/WEB-INF/usuario.jsp").forward(req, resp);
                }
            }else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        }else {
            resp.sendRedirect(req.getContextPath() + "/login");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LoginService auth = new LoginServiceImpl();
        RolRepositoryJdbcImpl rolRepository = new RolRepositoryJdbcImpl();
        UsuarioRepositoryJdbcImpl usuarioRepository = new UsuarioRepositoryJdbcImpl();
        Optional<Usuario> userOptional = auth.getUser(req);
        Usuario usuario;

        String username = req.getParameter("username");
        String nombres = req.getParameter("nombres");
        String apellidos = req.getParameter("apellidos");
        String fechaNacimiento = req.getParameter("fechaNacimiento");
        String rut = req.getParameter("rut");
        String rolId = req.getParameter("rol");
        String password = req.getParameter("password");

        try {
            usuario = new Usuario(username, nombres, apellidos, dateFormat.parse(fechaNacimiento), rut, Integer.parseInt(rolId), password);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }


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
                try {
                    usuarioRepository.guardar(usuario);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                resp.sendRedirect(req.getContextPath()+ "/usuarios");
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
