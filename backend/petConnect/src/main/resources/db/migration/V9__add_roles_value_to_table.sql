-- create roles por defecto

INSERT INTO roles (nombre)
SELECT 'USER' FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE nombre = 'USER');


INSERT INTO roles (nombre)
SELECT 'ADMIN' FROM DUAL
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE nombre = 'ADMIN');