-- Active: 1676209919073@@127.0.0.1@3306@db_usuario
/** 
 @AUTOR : JEFFERSON CHILENO
 @EMAIL : JEFFERSONCHILE2001@GMAIL.COM
 @DATE :  26/01/2023
 @COPYRIGHT© Todos los derechos reservados 2023-2028   
 */

CREATE DATABASE DB_USUARIO CHARACTER SET = 'utf8';

USE DB_USUARIO;

--------------------------- ESTADO -----------------------------

CREATE TABLE
    Estado (
        ID_ESTADO INTEGER NOT NULL AUTO_INCREMENT,
        ESTADO VARCHAR(15) NOT NULL,
        PRIMARY KEY (ID_ESTADO)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

-- DROP TABLE Estado ;

DESCRIBE Estado;

SELECT * FROM Estado;

INSERT INTO Estado(ESTADO) VALUES ("DISPONIBLE"), ("NO DISPONIBLE");

-----------------------------------------------------------USUARIOS---------------------------------------------

------------------------------------- ROL -----------------------------

CREATE TABLE
    Rol(
        ID_ROL INTEGER NOT NULL AUTO_INCREMENT,
        -- FK_ID_ESTADO INTEGER NOT NULL,
        NOMBRE VARCHAR(13) NOT NULL,
        PRIMARY KEY(ID_ROL)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

DROP TABLE Rol;

DESCRIBE Rol;

INSERT INTO Rol(NOMBRE) VALUES ("ADMINISTRADOR"), ("TRABAJADOR");

SELECT * FROM Rol;

-------------------------------- USUARIOS -----------------------------

CREATE TABLE
    Usuario(
        ID_USUARIO INTEGER NOT NULL AUTO_INCREMENT,
        FK_ID_ESTADO INTEGER NOT NULL DEFAULT(1),
        FK_ID_ROL INTEGER NOT NULL DEFAULT(2),
        USUARIO VARCHAR(20) NOT NULL,
        CONTRASENA VARCHAR(25) NOT NULL,
        EMAIL VARCHAR(50) NOT NULL,
        PRIMER_NOMBRE VARCHAR(15) NOT NULL,
        SEGUNDO_NOMBRE VARCHAR(15) NOT NULL,
        APELLIDO_PATERNO VARCHAR(15) NOT NULL,
        APELLIDO_MATERNO VARCHAR(15) NOT NULL,
        CEDULA VARCHAR(15) NOT NULL,
        TELEFONO VARCHAR(15) NOT NULL,
        -- FOTO longblob NOT NULL,
        PRIMARY KEY (ID_USUARIO)
    );

ALTER TABLE Usuario
ADD
    FOREIGN KEY (FK_ID_ESTADO) REFERENCES Estado(ID_ESTADO);

ALTER TABLE Usuario
ADD
    FOREIGN KEY (FK_ID_ROL) REFERENCES Rol(ID_ROL);

-- DROP TABLE Usuario;

DESCRIBE Usuario;

SELECT * FROM Usuario;

-- DELETE FROM Usuario;

INSERT INTO
    Usuario(
        FK_ID_ROL,
        USUARIO,
        CONTRASENA,
        EMAIL,
        PRIMER_NOMBRE,
        SEGUNDO_NOMBRE,
        APELLIDO_PATERNO,
        APELLIDO_MATERNO,
        CEDULA,
        TELEFONO
    )
VALUES (
        1,
        "DEVELOPER",
        "12345",
        "developer@dominio.com",
        "xxxx",
        "xxxx",
        "xxxx",
        "xxxx",
        "XXXXXXXXXX",
        "09XXXXXXXX"
    ), (
        2,
        "thomas.germain17",
        "271001",
        "thomasgermain@gmail.com",
        "Thomas",
        "Daniel",
        "Germain",
        "Lennox",
        "1748968418",
        "09927XXXXX"
    );