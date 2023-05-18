<%@page contentType="text/html" pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">
    <img src="ruta/al/logo.png" width="30" height="30" class="d-inline-block align-top">
    Nombre de la empresa
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse justify-content-center justify-content-lg-end" id="navbarNav">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="/sprint">Inicio</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/sprint/usuarios">Usuarios</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/sprint/capacitaciones">Capacitaciones</a>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto">
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="usuarioLogueadoDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          ${user.getNombres()} ${user.getApellidos()}
        </a>
        <div class="dropdown-menu dropdown-menu-right" aria-labelledby="usuarioLogueadoDropdown">
          <a class="dropdown-item" href="#">Perfil</a>
          <a class="dropdown-item" href="#">Configuración</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="/sprint/logout">Cerrar sesión</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
