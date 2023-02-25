-- Active: 1676209919073@@127.0.0.1@3306@db_inventario

/** 
 @AUTOR : JEFFERSON CHILENO
 @EMAIL : JEFFERSONCHILE2001@GMAIL.COM
 @DATE :  26/01/2023
 @COPYRIGHT© Todos los derechos reservados 2023-2028   
 */

-- CREATE DATABASE DB_INVENTARIO CHARACTER SET = 'utf8';

USE DB_INVENTARIO;

-- SHOW DATABASES;

-- DROP DATABASE DB_INVENTARIO;

SHOW TABLES;

--------------------------- ESTADO -----------------------------

DROP TABLE IF EXISTS Estado;

CREATE TABLE
    Estado (
        PK_ID_ESTADO INTEGER NOT NULL AUTO_INCREMENT,
        ESTADO VARCHAR(15) NOT NULL,
        PRIMARY KEY (PK_ID_ESTADO)
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
        PK_ID_CATEGORIA_PRODUCTO INTEGER NOT NULL AUTO_INCREMENT,
        FK_ID_ESTADO INTEGER NOT NULL DEFAULT(1),
        NOMBRE VARCHAR(25) NOT NULL,
        PRIMARY KEY (PK_ID_CATEGORIA_PRODUCTO)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

ALTER TABLE CategoriaProducto
ADD
    FOREIGN KEY(FK_ID_ESTADO) REFERENCES Estado(PK_ID_ESTADO);

-- DROP TABLE CategoriaProducto;

DESCRIBE CategoriaProducto;

SELECT * FROM CategoriaProducto;

INSERT INTO
    CategoriaProducto(NOMBRE)
VALUES ("Escolar"), ("Cereales"), ("Higiene"), ("Jardìn"), ("Frutas"), ("Verduras"), ("Bebidas"), ("Licores"), ("Ropa"), ("Juguetes"), ("Salud"), ("Belleza"), ("Tecnología"), ("Hogar");

------------------------------------IVA-------------------------------

DROP TABLE IF EXISTS Iva;

CREATE TABLE
    Iva (
        PK_ID_IVA INTEGER NOT NULL AUTO_INCREMENT,
        NOMBRE VARCHAR(2) NOT NULL,
        PRIMARY KEY(PK_ID_IVA)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

-- DROP Iva;

DESCRIBE Iva;

SELECT * FROM Iva;

INSERT INTO Iva (NOMBRE) VALUES ("SI" ),("NO") ;

-------------------------------PRODUCTOS-------------------------------

DROP TABLE IF EXISTS Producto;

CREATE TABLE
    Producto(
        PK_ID_PRODUCTO VARCHAR(10) UNIQUE NOT NULL,
        CODIGO_PRODUCTO VARCHAR(20) UNIQUE NOT NULL,
        FK_ID_ESTADO INTEGER NOT NULL DEFAULT(1),
        FK_ID_CATEGORIA_PRODUCTO INTEGER NOT NULL,
        FK_ID_IVA INTEGER NOT NULL DEFAULT(1),
        PRODUCTO VARCHAR(30) UNIQUE NOT NULL,
        STOCK INTEGER NOT NULL DEFAULT(1),
        PRECIO_COMPRA FLOAT NOT NULL DEFAULT(1),
        PRECIO_VENTA FLOAT NOT NULL DEFAULT(1),
        DESCRIPCION VARCHAR(30),
        IMAGEN longblob,
        FECHA_CREACION VARCHAR(20) NOT NULL DEFAULT(CURRENT_TIMESTAMP()),
        FECHA_MODIFICA VARCHAR(20) NOT NULL DEFAULT(CURRENT_TIMESTAMP()),
        PRIMARY KEY(PK_ID_PRODUCTO)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_unicode_ci;

ALTER TABLE Producto
ADD
    FOREIGN KEY(FK_ID_ESTADO) REFERENCES Estado(PK_ID_ESTADO);

ALTER TABLE Producto
ADD
    FOREIGN KEY(FK_ID_CATEGORIA_PRODUCTO) REFERENCES CategoriaProducto(PK_ID_CATEGORIA_PRODUCTO);

ALTER TABLE Producto
ADD
    FOREIGN KEY(FK_ID_IVA) REFERENCES Iva(PK_ID_IVA);

DROP TABLE Producto;

DESCRIBE Producto;

SELECT * FROM Producto;

-- DELETE FROM Producto WHERE FK_ID_ESTADO = 1;

INSERT INTO
    Producto (
        PK_ID_PRODUCTO,
        CODIGO_PRODUCTO,
        FK_ID_CATEGORIA_PRODUCTO,
        FK_ID_IVA,
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
        "2CS80S8",
        "1962515100029",
        2,
        1,
        "Papel Familia 4u",
        150,
        0.75,
        1.00,
        " "
    ), (
        "2ZZP6S8",
        "1112015100029",
        2,
        1,
        "Pasta dental 300g",
        150,
        0.75,
        1.00,
        " "
    ), (
        "2CS8MS8",
        "1112015990029",
        1,
        1,
        "Chetos 100g",
        150,
        0.75,
        1.00,
        " "
    ), (
        "2C8P6S8",
        "1112036410029",
        3,
        1,
        "Arroz 25lb",
        150,
        0.75,
        1.00,
        " "
    ), (
        "52SP6S8",
        "1522015100029",
        3,
        1,
        "Coca Cola 1000ml",
        150,
        0.75,
        1.00,
        " "
    ), (
        "2CSPOL8",
        "1698015100029",
        2,
        2,
        "Fomix 12u",
        150,
        0.75,
        1.00,
        " "
    ), (
        "2CSP6P6",
        "1100015100029",
        1,
        1,
        "Galleta Amor",
        150,
        0.75,
        1.00,
        " "
    ), (
        "2CSLB6S8",
        "1362015100029",
        2,
        2,
        "Queso 4lb",
        150,
        0.75,
        1.00,
        " "
    ), (
        "2C266S8",
        "3622015100029",
        3,
        1,
        "Mayonesa 100g",
        150,
        0.75,
        1.00,
        " "
    ), (
        "2CSPBB8",
        "5149015100029",
        1,
        1,
        "azucar 2.2kg",
        150,
        0.75,
        1.00,
        " "
    );

-----------------------------------------------------------USUARIOS---------------------------------------------

------------------------------------- ROL -----------------------------

CREATE TABLE
    Rol(
        PK_ID_ROL INTEGER NOT NULL AUTO_INCREMENT,
        -- FK_ID_ESTADO INTEGER NOT NULL,
        NOMBRE VARCHAR(13) UNIQUE NOT NULL,
        PRIMARY KEY(PK_ID_ROL)
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
        PK_ID_USUARIO INTEGER NOT NULL AUTO_INCREMENT,
        FK_ID_ESTADO INTEGER NOT NULL DEFAULT(1),
        FK_ID_ROL INTEGER NOT NULL DEFAULT(2),
        USUARIO VARCHAR(20) UNIQUE NOT NULL,
        CONTRASENA VARCHAR(25) NOT NULL,
        EMAIL VARCHAR(50) NOT NULL,
        PRIMER_NOMBRE VARCHAR(15) NOT NULL,
        SEGUNDO_NOMBRE VARCHAR(15) NOT NULL,
        APELLIDO_PATERNO VARCHAR(15) NOT NULL,
        APELLIDO_MATERNO VARCHAR(15) NOT NULL,
        CEDULA VARCHAR(15) NOT NULL,
        TELEFONO VARCHAR(15) NOT NULL,
        FOTO longblob,
        PRIMARY KEY (PK_ID_USUARIO)
    );

ALTER TABLE Usuario
ADD
    FOREIGN KEY (FK_ID_ESTADO) REFERENCES Estado(PK_ID_ESTADO);

ALTER TABLE Usuario
ADD
    FOREIGN KEY (FK_ID_ROL) REFERENCES Rol(PK_ID_ROL);

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