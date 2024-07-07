CREATE TABLE mascotas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    especie VARCHAR(50) NOT NULL,
    raza VARCHAR(50),
    sexo BOOLEAN,
    edad VARCHAR(50),
    tamaño VARCHAR(50),
    color VARCHAR(50),
    necesidades_especiales TEXT,
    vacunado BOOLEAN,
    esterilizado BOOLEAN,
    foto VARCHAR(255),
    estado VARCHAR(50),
    id_propietario INT NOT NULL,
    FOREIGN KEY (id_propietario) REFERENCES usuarios(id)
);