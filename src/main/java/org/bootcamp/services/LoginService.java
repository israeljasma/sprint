package org.bootcamp.services;

import jakarta.servlet.http.HttpServletRequest;
import org.bootcamp.models.Usuario;

import java.util.Optional;

public interface LoginService {
    Optional<Usuario> getUser(HttpServletRequest request);
}
