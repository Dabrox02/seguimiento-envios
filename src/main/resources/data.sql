INSERT INTO public.direccion (codigo_postal, calle, ciudad, estado)
VALUES 
    ('12345', 'Calle 1', 'Ciudad 1', 'Estado 1'),
    ('23456', 'Calle 2', 'Ciudad 2', 'Estado 2'),
    ('34567', 'Calle 3', 'Ciudad 3', 'Estado 3'),
    ('45678', 'Calle 4', 'Ciudad 4', 'Estado 4'),
    ('56789', 'Calle 5', 'Ciudad 5', 'Estado 5'),
    ('35232', 'Calle 1', 'Ciudad 1', 'Estado 1'),
    ('22233', 'Calle 2', 'Ciudad 2', 'Estado 2'),
    ('33344', 'Calle 3', 'Ciudad 3', 'Estado 3'),
    ('44455', 'Calle 4', 'Ciudad 4', 'Estado 4'),
    ('55566', 'Calle 5', 'Ciudad 5', 'Estado 5');

INSERT INTO public.cliente (dni_cliente, telefono_cliente, apellido_string, email_cliente, nombre_cliente, id_direccion)
VALUES 
    ('11111111A', '123456789', 'Gomez', 'gomez@example.com', 'Juan', 1),
    ('22222222B', '987654321', 'Perez', 'perez@example.com', 'Maria', 2),
    ('33333333C', '111222333', 'Lopez', 'lopez@example.com', 'Carlos', 3),
    ('44444444D', '555555555', 'Martinez', 'martinez@example.com', 'Laura', 4),
    ('55555555E', '999999999', 'Sanchez', 'sanchez@example.com', 'Pedro', 5),
    ('66666666F', '123456789', 'Apellido1', 'cliente1@example.com', 'Nombre1', 6),
    ('77777777G', '987654321', 'Apellido2', 'cliente2@example.com', 'Nombre2', 8),
    ('88888888H', '555555555', 'Apellido3', 'cliente3@example.com', 'Nombre3', 7),
    ('99999999I', '111222333', 'Apellido4', 'cliente4@example.com', 'Nombre4', 9),
    ('10101010J', '444555666', 'Apellido5', 'cliente5@example.com', 'Nombre5', 10);

INSERT INTO public.paquete (peso, destinatario, remitente, tamano)
VALUES 
    (2.5, '11111111A', '22222222B', 'GRANDE'),
    (1.8, '33333333C', '44444444D', 'MEDIANO'),
    (0.5, '55555555E', '66666666F', 'PEQUENO'),
    (3.2, '77777777G', '88888888H', 'GRANDE'),
    (2.0, '99999999I', '10101010J', 'MEDIANO');

INSERT INTO public.transportista (nit_transportista, telefono_transportista, email_transportista, razon_social) 
VALUES 
('1234567890', '123456789', 'blue@example.com', 'Transportista Blue'),
('2345678901', '234567890', 'faszt@example.com', 'Fazt'),
('3456789012', '345678901', 'rapisomos@example.com', 'Rapisomos'),
('4567890123', '456789012', 'organfast@example.com', 'Orangfast'),
('5678901234', '567890123', 'expresso@example.com', 'Exprreso');


INSERT INTO public.ruta (nit_transportista, direccion_destino, direccion_origen) 
VALUES 
('5678901234', 'Direccion Destino 1', 'Direccion Origen 1'),
('4567890123', 'Direccion Destino 2', 'Direccion Origen 2'),
('3456789012', 'Direccion Destino 3', 'Direccion Origen 3'),
('2345678901', 'Direccion Destino 4', 'Direccion Origen 4'),
('1234567890', 'Direccion Destino 5', 'Direccion Origen 5');


INSERT INTO public.seguimiento (estado_envio, fecha, hora, id_paquete) 
VALUES 
('ENVIADO', '2024-03-01', '10:00:00', 1),
('ENVIADO', '2024-03-02', '11:00:00', 2),
('ENTREGADO', '2024-03-03', '12:00:00', 3),
('RETENIDO', '2024-03-04', '13:00:00', 4),
('ENTREGADO', '2024-03-05', '14:00:00', 5);


INSERT INTO public.paquete_ruta(id_paquete, id_ruta)
VALUES 
(1, 1),
(1, 2),
(2, 3),
(3, 4),
(5, 5);