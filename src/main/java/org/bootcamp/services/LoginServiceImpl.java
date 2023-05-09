package org.bootcamp.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.bootcamp.models.Usuario;

import java.util.Optional;

public class LoginServiceImpl implements LoginService {

    @Override
    public Optional<Usuario> getUsername(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario username = (Usuario) session.getAttribute("user");
        if (username != null){
            return Optional.of(username);
        }
        return Optional.empty();
    }
}
