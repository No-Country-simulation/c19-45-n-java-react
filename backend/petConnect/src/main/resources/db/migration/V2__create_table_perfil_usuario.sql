CREATE TABLE perfil_usuario (
    usuario_id INT NOT NULL,
    nombre VARCHAR(50) NOT NULL,
    foto VARCHAR(255),
    telefono VARCHAR(15),
    sexo VARCHAR(20),
    fecha_nacimiento DATE,
    tipo_usuario VARCHAR(20) NOT NULL,
    latitud DECIMAL(9,6),
    longitud DECIMAL(9,6),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);