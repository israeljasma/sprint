<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
</head>
<body>
    <header>
        <%@ include file="/WEB-INF/includes/navbar.jsp" %>
    </header>
    <main class="container-fluid">
      <div class="row">
        <div class="col-md-6 col-lg-3 mb-4">
          <div class="card bg-primary text-white shadow">
            <div class="card-body">
              <h5 class="card-title">Usuarios</h5>
              <p class="card-text">Hay 256 usuarios registrados en el sistema.</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3 mb-4">
          <div class="card bg-warning text-white shadow">
            <div class="card-body">
              <h5 class="card-title">Exemplo</h5>
              <p class="card-text">Exemplo.</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3 mb-4">
          <div class="card bg-success text-white shadow">
            <div class="card-body">
              <h5 class="card-title">Exemplo</h5>
              <p class="card-text">Exemplo.</p>
            </div>
          </div>
        </div>
        <div class="col-md-6 col-lg-3 mb-4">
          <div class="card bg-danger text-white shadow">
            <div class="card-body">
              <h5 class="card-title">Incidencias</h5>
              <p class="card-text">Hay 3 incidencias reportadas en el sistema.</p>
            </div>
          </div>
        </div>
      </div>
      <div class="row">
        <div class="col-md-6">
          <div class="card shadow">
            <div class="card-header">
              <h5 class="card-title">Últimos Usuarios Registrados</h5>
            </div>
            <div class="card-body">
              <ul class="list-group list-group-flush">
                <li class="list-group-item">
                  <strong>Juan Pérez</strong> - juanperez@gmail.com
                </li>
                <li class="list-group-item">
                  <strong>Juan Pérez</strong> - juanperez@gmail.com
                </li>
                <li class="list-group-item">
                   <strong>Juan Pérez</strong> - juanperez@gmail.com
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-md-6">
          <div class="card shadow">
            <div class="card-header">
              <h5 class="card-title">Exemplo</h5>
            </div>
            <div class="card-body">
              <ul class="list-group list-group-flush">
                <li class="list-group-item">
                  <strong>Exemplo</strong>
                </li>
                <li class="list-group-item">
                  <strong>Exemplo</strong>
                </li>
                <li class="list-group-item">
                  <strong>Exemplo</strong>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </main>
    <footer>
        <%@ include file="/includes/footer.jsp" %>
    </footer>
</body>
</html>