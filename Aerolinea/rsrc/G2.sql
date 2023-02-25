-- Active: 1677234517062@@127.0.0.1@3306

-- todo lo que permite crear su tablas

.version.database.show;

.tables;

CREATE TABLE
    LOCALIDAD2 (
        ID_LOCALIDAD INTEGER PRIMARY KEY AUTOINCREMENT,
        ID_LOCALIDAD_PADRE INTEGER NULL,
        ID_LOCALIDAD_TIPO INTEGER,
        NOMBRE VARCHAR(30),
        CONSERVACION VARCHAR(100),
        ESTADO VARCHAR(30),
        CONSTRAINT fk_HIU FOREIGN KEY (HID) REFERENCES LOCALIDAD(ID_LOCALIDAD)
    );

CREATE TABLE
    VUELOS(
        ID_VUELO INTEGER PRIMARY KEY AUTOINCREMENT,
        ESTADO VARCHAR(1) DEFAULT('S'),
        TIPO_VUELO INTEGER,
        LUGAR_PARTIDA VARCHAR(30),
        LUGAR_DESTINO VARCHAR(30),
        PRECIO_POR_PERSONA FLOAT,
        RECOMENDACION VARCHAR(1),
        CLASE_VUELO VARCHAR(15),
        LATAM_PASS VARCHAR(1),
        CLASE_PRECIO INTEGER,
        FECHA_SALIDA VARCHAR(25),
        FECHA_VUELTA VARCHAR(25),
        TIEMPO_SALIDA VARCHAR(25),
        TIEMPO_LLEGADA VARCHAR(25)
    );

DROP TABLE VUELOS;

DESCRIBE TABLE VUELOS;

INSERT INTO
    VUELOS (
        ESTADO,
        TIPO_VUELO,
        LUGAR_PARTIDA,
        LUGAR_DESTINO,
        PRECIO_POR_PERSONA,
        RECOMENDACION,
        CLASE_VUELO,
        LATAM_PASS,
        CLASE_PRECIO,
        FECHA_SALIDA,
        FECHA_VUELTA,
        TIEMPO_SALIDA,
        TIEMPO_LLEGADA
    )
VALUES (
        'S',
        2,
        "Guayaquil, GYE - Ecuador",
        "Quito, UIO - Ecuador",
        85.52,
        'S',
        "Directo",
        'S',
        2,
        "jue. 2 mar",
        "jue. 13 abr",
        "06:00",
        "06:50"
    ), (
        'S',
        2,
        "Guayaquil, GYE - Ecuador",
        "Quito, UIO - Ecuador",
        50.80,
        'N',
        "Directo",
        'S',
        1,
        "jue. 2 mar",
        "jue. 13 abr",
        "07:05",
        "07:55"
    );

SELECT * FROM VUELOS;