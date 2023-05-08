CREATE TABLE roles (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50) NOT NULL,
  descripcion VARCHAR(255),
  permiso_lectura BOOLEAN NOT NULL DEFAULT FALSE,
  permiso_escritura BOOLEAN NOT NULL DEFAULT FALSE,
  permiso_eliminar BOOLEAN NOT NULL DEFAULT FALSE
);

INSERT INTO roles (nombre, descripcion, permiso_lectura, permiso_escritura, permiso_eliminar)
VALUES ('administrador', 'Rol con permisos de administrador', true, true, true),
       ('cliente', 'Rol para usuarios clientes', true, false, false),
       ('profesional', 'Rol para usuarios profesionales', true, true, false);

CREATE TABLE capacitaciones (
    id INT NOT NULL AUTO_INCREMENT,
    rut_cliente VARCHAR(20) NOT NULL,
    dia DATE NOT NULL,
    hora TIME NOT NULL,
    lugar VARCHAR(50) NOT NULL,
    duracion INT NOT NULL,
    cantidad INT NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO capacitaciones (rut_cliente, dia, hora, lugar, duracion, cantidad)
VALUES ('22345678-9', '2023-05-06', '14:30:00', 'Oficina 101', 60, 1);

INSERT INTO capacitaciones (rut_cliente, dia, hora, lugar, duracion, cantidad)
VALUES ('32345678-9', '2023-05-06', '14:30:00', 'Oficina 101', 60, 1);

INSERT INTO capacitaciones (rut_cliente, dia, hora, lugar, duracion, cantidad)
VALUES ('42345678-9', '2023-05-06', '14:30:00', 'Oficina 101', 60, 1);


CREATE TABLE sistemaSalud (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(255) NOT NULL
);

INSERT INTO sistemaSalud (nombre)
VALUES ('Isapre');

INSERT INTO sistemaSalud (nombre)
VALUES ('Fonasa');