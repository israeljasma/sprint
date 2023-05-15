<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.bootcamp.models.Rol"%>
<%
List<Rol> roles = (List<Rol>)request.getAttribute("roles");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <header>
        <%@ include file="/WEB-INF/includes/navbar.jsp" %>
    </header>
    <div class="container">
        <h2 class="text-center my-5">Crear usuario</h2>
        <form action="#" method="post">

            <div class="form-group row my-3">
                <label for="nombres" class="col-sm-2 col-form-label">Nombre de usuario:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="username" placeholder="Ingrese el nombre de usuario" value="${getUserId.getUsername()}">
                </div>
            </div>

            <div class="form-group row my-3">
                <label for="nombres" class="col-sm-2 col-form-label">Nombres:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="nombres" name="nombres" placeholder="Ingrese los nombres" value="${getUserId.getNombres()}">
                </div>
            </div>

            <div class="form-group row my-3">
                <label for="apellidos" class="col-sm-2 col-form-label">Apellidos:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Ingrese los apellidos" value="${getUserId.getApellidos()}">
                </div>
            </div>

            <div class="form-group row my-3">
                <label for="fechaNacimiento" class="col-sm-2 col-form-label">Fecha de Nacimiento:</label>
                <div class="col-sm-10">
                    <input type="date" class="form-control" id="fechaNacimiento" name="fechaNacimiento" value="${getUserId.getFechaNacimiento()}">
                </div>
            </div>

            <div class="form-group row my-3">
                <label for="rut" class="col-sm-2 col-form-label">RUT:</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="rut" placeholder="Ingrese el RUT" name="rut" value="${getUserId.getRut()}">
                </div>
            </div>

            <div class="form-group row my-3">
                <label for="rol" class="col-sm-2 col-form-label">Tipo de usuario:</label>
                <div class="col-sm-10">
                    <select class="form-control" id="rol" name="rol" required>
                        <option SELECTED DISABLED>Selecione una opcion</option>
                        <% for (int i = 0; i < roles.size(); i++) { %>
                            <option value="<%= roles.get(i).getId() %>"><%= roles.get(i).getNombre().substring(0,1).toUpperCase() + roles.get(i).getNombre().substring(1) %></option>
                        <% } %>
                    </select>
                </div>
            </div>

            <div id="campos-administrador" style="display: none;">
                <div class="form-group row my-3">
                    <label for="area" class="col-sm-2 col-form-label">Area:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="area" placeholder="Ingrese el area" name="area">
                    </div>
                </div>

                <div class="form-group row my-3">
                    <label for="experiencia" class="col-sm-2 col-form-label">Experiencia:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="experiencia" placeholder="Ingrese la experiencia" name="experiencia">
                    </div>
                </div>
            </div>

            <div id="campos-profesional" style="display: none;">
                <div class="form-group row my-3">
                    <label for="titulo" class="col-sm-2 col-form-label">Titulo:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="titulo" placeholder="Ingrese el titulo" name="titulo">
                    </div>
                </div>

                <div class="form-group row my-3">
                    <label for="fechaIngreso" class="col-sm-2 col-form-label">Fecha de ingreso:</label>
                    <div class="col-sm-10">
                        <input type="date" class="form-control" id="fechaIngreso" name="fechaIngreso">
                    </div>
                </div>
            </div>

            <div id="campos-cliente" style="display: none;">
                <div class="form-group row my-3">
                    <label for="telefono" class="col-sm-2 col-form-label">Telefono:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="telefono" placeholder="Ingrese el telefono" name="telefono">
                    </div>
                </div>

                <div class="form-group row my-3">
                    <label for="afp" class="col-sm-2 col-form-label">AFP:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="afp" name="afp" required>
                            <option SELECTED DISABLED>Selecione una opcion</option>
                            <option value="afp1">afp1</option>
                            <option value="afp2">afp2</option>
                            <option value="afp3">afp3</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row my-3">
                    <label for="sistemaSalud" class="col-sm-2 col-form-label">Sistema de salud:</label>
                    <div class="col-sm-10">
                        <select class="form-control" id="sistemaSalud" name="sistemaSalud" required>
                            <option SELECTED DISABLED>Selecione una opcion</option>
                            <option value="isapre">Isapre</option>
                            <option value="fonasa">Fonasa</option>
                        </select>
                    </div>
                </div>

                <div class="form-group row my-3">
                    <label for="direccion" class="col-sm-2 col-form-label">Dirección:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="direccion" placeholder="Ingrese la dirección" name="direccion">
                    </div>
                </div>

                <div class="form-group row my-3">
                    <label for="comuna" class="col-sm-2 col-form-label">Comuna:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="comuna" placeholder="Ingrese la comuna" name="comuna">
                    </div>
                </div>

                <div class="form-group row my-3">
                    <label for="edad" class="col-sm-2 col-form-label">Edad:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="edad" placeholder="Ingrese la edad" name="edad">
                    </div>
                </div>
            </div>

            <div class="form-group row my-3">
                <label for="password" class="col-sm-2 col-form-label">Contraseña:</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" placeholder="Ingrese su contraseña" name="password" value="${getUserId.getPassword()}">
                </div>
            </div>

            <div class="form-group row my-3">
                <div class="col-sm-12 text-center">
                    <button type="submit" class="btn btn-primary">Enviar</button>
                </div>
            </div>
        </form>
    </div>
    <footer>
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </footer>
    <script>
    var rolUsuarioSelect = document.getElementById("rol");
    var camposAdministrador = document.getElementById("campos-administrador");
    var camposProfesional = document.getElementById("campos-profesional");
    var camposCliente = document.getElementById("campos-cliente");

    var camposMap = {
        "Administrador": camposAdministrador,
        "Cliente": camposCliente,
        "Profesional": camposProfesional
    };

    rolUsuarioSelect.addEventListener("change", function() {
        var selectedOptionText = this.options[this.selectedIndex].text;

        // Ocultar todos los campos
        camposAdministrador.style.display = "none";
        camposCliente.style.display = "none";
        camposProfesional.style.display = "none";

        // Mostrar el campo correspondiente
        if (selectedOptionText in camposMap) {
            camposMap[selectedOptionText].style.display = "block";
        }
    });
    </script>
</body>
</html>