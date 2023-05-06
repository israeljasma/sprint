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
VALUES ('12345678-9', '2023-05-06', '14:30:00', 'Oficina 101', 60, 1);