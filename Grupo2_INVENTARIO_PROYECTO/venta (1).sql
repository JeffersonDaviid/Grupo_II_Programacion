-- phpMyAdmin SQL Dump

-- version 5.2.0

-- https://www.phpmyadmin.net/

--

-- Servidor: 127.0.0.1

-- Tiempo de generación: 08-03-2023 a las 04:48:18

-- Versión del servidor: 10.4.27-MariaDB

-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";

START TRANSACTION;

SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */

;

/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */

;

/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */

;

/*!40101 SET NAMES utf8mb4 */

;

--

-- Base de datos: `db_inventario`

--

-- --------------------------------------------------------

--

-- Estructura de tabla para la tabla `venta`

--

CREATE TABLE
    venta (
        PK_ID int(11) NOT NULL,
        CLIENTE varchar(100) NOT NULL,
        CEDULA varchar(100) NOT NULL,
        DIRECCION varchar(100) NOT NULL,
        TELEFONO varchar(20) NOT NULL,
        TOTAL decimal(10, 2) NOT NULL,
        FECHA date NOT NULL DEFAULT current_timestamp(),
        PRIMARY KEY(PK_ID)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COLLATE = utf8mb4_general_ci;

--

-- Volcado de datos para la tabla  venta`

--

INSERT INTO
    venta (
        PK_ID,
        CLIENTE,
        CEDULA,
        DIRECCION,
        TELEFONO,
        TOTAL,
        FECHA
    )
VALUES (
        1,
        'asdaas',
        'asd',
        'asd',
        'asd',
        '123.00',
        '2023-03-07'
    );

--

-- Índices para tablas volcadas

--

--

-- Indices de la tabla `venta`

--

ALTER TABLE `venta` ADD PRIMARY KEY (`PK_ID`);

--

-- AUTO_INCREMENT de las tablas volcadas

--

--

-- AUTO_INCREMENT de la tabla `venta`

--

ALTER TABLE
    `venta` MODIFY `PK_ID` int(11) NOT NULL AUTO_INCREMENT,
    AUTO_INCREMENT = 2;

COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */

;

/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */

;

/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */

;