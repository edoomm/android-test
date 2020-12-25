DROP DATABASE Test;

CREATE DATABASE Test;

CREATE TABLE Empleado (
    numero_empleado VARCHAR(6) PRIMARY KEY,
    nombre VARCHAR(50)
) ENGINE = InnoDB;