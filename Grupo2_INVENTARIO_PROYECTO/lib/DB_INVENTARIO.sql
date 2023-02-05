-- Active: 1675538605226@@127.0.0.1@3306@DB_INVENTARIO

/** 
 @AUTOR : JEFFERSON CHILENO
 @EMAIL : JEFFERSONCHILE2001@GMAIL.COM
 @DATE :  26/01/2023
 @COPYRIGHT© Todos los derechos reservados 2023-2028   
 */

-- CREATE DATABASE DB_INVENTARIO CHARACTER SET = 'utf8';

-- USE DB_INVENTARIO ;

-- SHOW DATABASES;

-- DROP DATABASE DB_INVENTARIO;

SHOW TABLES;

--------------------------- ESTADO -----------------------------

DROP TABLE IF EXISTS Estado;

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

--------------------------------------------------------INVENTARIO---------------------------------------------

---------------------CATEGORIA DE PRODUCTO-------------------------------

DROP TABLE IF EXISTS CategoriaProducto;

CREATE TABLE
    CategoriaProducto(
        ID_CATEGORIA_PRODUCTO INTEGER NOT NULL AUTO_INCREMENT,
        FK_ID_ESTADO INTEGER NOT NULL DEFAULT(1),
        NOMBRE VARCHAR(25) NOT NULL,
        PRIMARY KEY (ID_CATEGORIA_PRODUCTO)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

ALTER TABLE CategoriaProducto
ADD
    FOREIGN KEY(FK_ID_ESTADO) REFERENCES Estado(ID_ESTADO);

-- DROP TABLE CategoriaProducto;

DESCRIBE CategoriaProducto;

SELECT * FROM CategoriaProducto;

INSERT INTO
    CategoriaProducto(NOMBRE)
VALUES ("Escolar"), ("Cereales"), ("Higiene");

------------------------------------IVA-------------------------------

DROP TABLE IF EXISTS Iva;

CREATE TABLE
    Iva (
        ID_IVA INTEGER NOT NULL AUTO_INCREMENT,
        NOMBRE VARCHAR(2) NOT NULL,
        PRIMARY KEY(ID_IVA)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

-- DROP Iva;

DESCRIBE Iva;

SELECT * FROM Iva;

INSERT INTO Iva (NOMBRE) VALUES ("SI" ),("NO") ;

-------------------------------PRODUCTOS-------------------------------

DROP TABLE IF EXISTS Producto;

CREATE TABLE
    Producto(
        ID_PRODUCTO VARCHAR(10) NOT NULL,
        CODIGO_PRODUCTO VARCHAR(20) NOT NULL,
        FK_ID_ESTADO INTEGER NOT NULL DEFAULT(1),
        FK_ID_CATEGORIA_PRODUCTO INTEGER NOT NULL,
        PK_ID_IVA INTEGER NOT NULL DEFAULT(1),
        PRODUCTO VARCHAR(30) NOT NULL,
        STOCK INTEGER NOT NULL DEFAULT(1),
        PRECIO_COMPRA FLOAT NOT NULL DEFAULT(1),
        PRECIO_VENTA FLOAT NOT NULL DEFAULT(1),
        DESCRIPCION VARCHAR(30),
        IMAGEN longblob,
        FECHA_CREACION VARCHAR(20) NOT NULL DEFAULT(CURRENT_TIMESTAMP()),
        FECHA_MODIFICA VARCHAR(20) NOT NULL DEFAULT(CURRENT_TIMESTAMP()),
        PRIMARY KEY(ID_PRODUCTO)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

ALTER TABLE Producto
ADD
    FOREIGN KEY(FK_ID_ESTADO) REFERENCES Estado(ID_ESTADO);

ALTER TABLE Producto
ADD
    FOREIGN KEY(FK_ID_CATEGORIA_PRODUCTO) REFERENCES CategoriaProducto(ID_CATEGORIA_PRODUCTO);

ALTER TABLE Producto
ADD
    FOREIGN KEY(PK_ID_IVA) REFERENCES Iva(ID_IVA);

DROP TABLE Producto;

DESCRIBE Producto;

SELECT * FROM Producto;

-- DELETE FROM Producto WHERE FK_ID_ESTADO = 1;

INSERT INTO
    Producto (
        ID_PRODUCTO,
        CODIGO_PRODUCTO,
        FK_ID_CATEGORIA_PRODUCTO,
        PK_ID_IVA,
        PRODUCTO,
        STOCK,
        PRECIO_COMPRA,
        PRECIO_VENTA,
        DESCRIPCION
    )
VALUES (
        "2CD6S5",
        "1112021100029",
        1,
        1,
        "Caja 12u Esferos Big Azul",
        200,
        0.80,
        1.10,
        " "
    ), (
        "2CSP6S8",
        "1112015100029",
        3,
        1,
        "Papel Familia 4u",
        150,
        0.75,
        1.00,
        " "
    );

-----------------------------------------------------------USUARIOS---------------------------------------------

------------------------------------- ROL -----------------------------

CREATE TABLE
    Rol(
        ID_ROL INTEGER NOT NULL AUTO_INCREMENT,
        -- FK_ID_ESTADO INTEGER NOT NULL,
        NOMBRE VARCHAR(13) NOT NULL,
        PRIMARY KEY(ID_ROL)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

-- DROP TABLE Rol;

DESCRIBE Rol;

INSERT INTO Rol(NOMBRE) VALUES ("ADMINISTRADOR"), ("TRABAJADOR");

SELECT * FROM Rol;

-- DELETE FROM Rol;

-------------------------------- USUARIOS -----------------------------

DROP TABLE IF EXISTS Usuario;

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
        FOTO longblob,
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

SHOW TABLES;