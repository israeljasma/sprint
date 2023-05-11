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
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet("/usuarios/eliminar")
public class UsuarioEliminarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceImpl();
        UsuarioRepositoryJdbcImpl repository = new UsuarioRepositoryJdbcImpl();
        RolRepositoryJdbcImpl rolRepository = new RolRepositoryJdbcImpl();
        Optional<Usuario> userOptional = auth.getUser(req);
        List<Rol> roles;
        int id;

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
                resp.sendRedirect(req.getContextPath()+ "/usuarios");
            }else {
                resp.sendRedirect(req.getContextPath() + "/login");
            }
        }
        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
