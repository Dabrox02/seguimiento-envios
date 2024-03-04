
INSERT INTO cliente (dni_cliente, telefono_cliente, apellido_string, email_cliente, nombre_cliente)
VALUES 
    ('11111111A', '123456789', 'Gómez', 'gomez@example.com', 'Juan'),
    ('22222222B', '987654321', 'Pérez', 'perez@example.com', 'María'),
    ('33333333C', '111222333', 'López', 'lopez@example.com', 'Carlos'),
    ('44444444D', '555555555', 'Martínez', 'martinez@example.com', 'Laura'),
    ('55555555E', '999999999', 'Sánchez', 'sanchez@example.com', 'Pedro');

INSERT INTO direccion (codigo_postal, dni_cliente, calle, ciudad, estado)
VALUES 
    ('12345', '11111111A', 'Calle 1', 'Ciudad 1', 'Estado 1'),
    ('23456', '22222222B', 'Calle 2', 'Ciudad 2', 'Estado 2'),
    ('34567', '33333333C', 'Calle 3', 'Ciudad 3', 'Estado 3'),
    ('45678', '44444444D', 'Calle 4', 'Ciudad 4', 'Estado 4'),
    ('56789', '55555555E', 'Calle 5', 'Ciudad 5', 'Estado 5');
