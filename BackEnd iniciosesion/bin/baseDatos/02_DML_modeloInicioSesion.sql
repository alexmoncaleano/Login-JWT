INSERT INTO perfiles(nombre_perfil) VALUES ('Administrador');
INSERT INTO perfiles(nombre_perfil) VALUES ('Gerente');
INSERT INTO perfiles(nombre_perfil) VALUES ('Vendedor');
INSERT INTO perfiles(nombre_perfil) VALUES ('Contador');
INSERT INTO perfiles(nombre_perfil) VALUES ('Médico');
INSERT INTO perfiles(nombre_perfil) VALUES ('Paciente');


INSERT INTO usuarios(cod_perfil, tipo_documento_usuario, documento_usuario, genero_usuario, nombres_usuario, apellidos_usuario, telefono_usuario) 
VALUES (1, 'CC', '66777888', 1, 'Andrés', 'Guerrero', '301-7900-437');

INSERT INTO usuarios(cod_perfil, tipo_documento_usuario, documento_usuario, genero_usuario, nombres_usuario, apellidos_usuario, telefono_usuario) 
VALUES (2, 'TI', '55777888', 1, 'Doña', 'Florinda', '320-7845-665');


INSERT INTO accesos(cod_usuario, estado_acceso, correo_acceso, clave_acceso, avatar_acceso) VALUES (1, 1, 'anguerrco@msn.com', '123456', '');
INSERT INTO accesos(cod_usuario, estado_acceso, correo_acceso, clave_acceso, avatar_acceso) VALUES (2, 1, 'florinda@gmail.com', '123456', '');
