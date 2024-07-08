CREATE TABLE adopciones (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_adoptante INT NOT NULL,
    id_mascota INT NOT NULL,
    estado VARCHAR(50) NOT NULL,
    fecha_adopcion TIMESTAMP,
    FOREIGN KEY (id_adoptante) REFERENCES usuarios(id),
    FOREIGN KEY (id_mascota) REFERENCES mascotas(id)
);