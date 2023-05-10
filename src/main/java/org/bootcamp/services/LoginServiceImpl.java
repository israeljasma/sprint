package org.bootcamp.services;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.bootcamp.models.Usuario;

import java.util.Optional;

public class LoginServiceImpl implements LoginService {

    @Override
    public Optional<Usuario> getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Usuario user = (Usuario) session.getAttribute("user");
        if (user != null) {
            return Optional.of(user);
        }
        return Optional.empty();
    }
}
