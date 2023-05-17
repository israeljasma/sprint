<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.bootcamp.models.Usuario"%>
<%
List<Usuario> usuarios = (List<Usuario>)request.getAttribute("usuarios");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listar usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <header>
        <%@ include file="/WEB-INF/includes/navbar.jsp" %>
    </header>
    <div class="container">
        <h2 class="text-center mb-4">Lista de Usuarios</h2>
        <div class="d-flex justify-content-end mb-3">
            <a href="/sprint/usuarios/agregar" class="btn btn-success">Agregar Usuario</a>
        </div>
        <table class="table table-striped">
            <thead>
            <tr>
                <th>ID</th>
                <th>Nombre de usuario</th>
                <th>RUT</th>
                <th>Nombres</th>
                <th>Apellidos</th>
                <th>Fecha de Nacimiento</th>
                <th>Acciones</th>
            </tr>
            </thead>
            <tbody>

            <% for (Usuario user : usuarios) {%>
                <tr>
                    <td><%=user.getId()%></td>
                    <td><%=user.getUsername()%></td>
                    <td><%=user.getRut()%></td>
                    <td><%=user.getNombres()%></td>
                    <td><%=user.getApellidos()%></td>
                    <td><%=user.getFechaNacimiento()%></td>
                    <td>
                        <a href="/sprint/usuarios/editar?id=<%=user.getId()%>" class="btn btn-primary">Editar</a>
                        <a onclick="return confirm('¿Está seguro de que desea eliminar?');" href="/sprint/usuarios/eliminar?id=<%=user.getId()%>" class="btn btn-danger">Eliminar</a>
                    </td>
                </tr>
            <%}%>

            </tbody>
        </table>
    </div>
    <footer>
        <%@ include file="/WEB-INF/includes/footer.jsp" %>
    </footer>
</body>
</html>