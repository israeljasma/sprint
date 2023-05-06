<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.bootcamp.models.Capacitacion"%>
<%
List<Capacitacion> capacitaciones = (List<Capacitacion>)request.getAttribute("capacitaciones");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listar capacitaciones</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h2 class="text-center mb-4">Lista de Capacitaciones</h2>
    <table class="table table-striped">
        <thead>
        <tr>
            <th>ID</th>
            <th>RUT Cliente</th>
            <th>Día</th>
            <th>Hora</th>
            <th>Lugar</th>
            <th>Duración (minutos)</th>
            <th>Cantidad de participantes</th>
        </tr>
        </thead>
        <tbody>
        <% for (Capacitacion listCapacitacion : capacitaciones) {%>
            <tr>
                <td><%=listCapacitacion.getId()%></td>
                <td><%=listCapacitacion.getRutCliente()%></td>
                <td><%=listCapacitacion.getDia()%></td>
                <td><%=listCapacitacion.getHora()%></td>
                <td><%=listCapacitacion.getLugar()%></td>
                <td><%=listCapacitacion.getDuracion()%></td>
                <td><%=listCapacitacion.getCantidad()%></td>
            </tr>
        <%}%>
        </tbody>
    </table>
</div>
</body>
</html>