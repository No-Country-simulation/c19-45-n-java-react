INSERT INTO especies (nombre)
SELECT 'Gato' FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM especies WHERE nombre = 'Gato');


INSERT INTO especies (nombre)
SELECT 'Perro' FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM especies WHERE nombre = 'Perro');