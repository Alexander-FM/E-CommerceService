-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-07-2021 a las 05:12:35
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_ecommerce`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `vigencia` bit(1) DEFAULT NULL,
  `foto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `nombre`, `vigencia`, `foto_id`) VALUES
(1, 'Tallarines', b'1', 4),
(2, 'Arroz', b'1', 7),
(3, 'Postres', b'1', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `departamento` varchar(100) DEFAULT NULL,
  `direccion_envio` varchar(500) DEFAULT NULL,
  `distrito` varchar(100) DEFAULT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `num_doc` varchar(11) DEFAULT NULL,
  `provincia` varchar(100) DEFAULT NULL,
  `tipo_doc` varchar(20) DEFAULT NULL,
  `foto_id` bigint(20) DEFAULT NULL,
  `apellido_materno` varchar(100) DEFAULT NULL,
  `apellido_paterno` varchar(100) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `departamento`, `direccion_envio`, `distrito`, `nombres`, `num_doc`, `provincia`, `tipo_doc`, `foto_id`, `apellido_materno`, `apellido_paterno`, `telefono`) VALUES
(1, 'Lambayeque', 'Urb. Villa los sauces mz.v lt.5', 'Chiclayo', 'Oscar Antonio', '73139193', 'Chiclayo', 'DNI', 2, 'Veintimilla', 'Cumpa', '963258753'),
(2, 'Lambayeque', 'Calle sucre 903', 'Ferreñafe', 'Alexander', '78019778', 'Ferreñafe', 'DNI', 1, 'Medina', 'Fuentes', '917967148'),
(5, 'Lambayeque', 'Calle Nicanor Carmona N° 256', 'Ferreñafe', 'Ximena', '45896325', 'Ferreñafe', 'DNI', 9, 'Samamé', 'Quezada', '987456321');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_pedido`
--

CREATE TABLE `detalle_pedido` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `pedido_id` int(11) DEFAULT NULL,
  `platillo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento_almacenado`
--

CREATE TABLE `documento_almacenado` (
  `id` bigint(20) NOT NULL,
  `eliminado` bit(1) NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `extension` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `documento_almacenado`
--

INSERT INTO `documento_almacenado` (`id`, `eliminado`, `estado`, `extension`, `file_name`, `nombre`) VALUES
(1, b'0', 'A', '.jpg', 'fd89f1da-6594-4276-8cef-05766982e97f', 'Alexander'),
(2, b'0', 'A', '.jpg', '040ca99d-2f1a-41eb-80be-4c064eedffba', 'Oscar Photo'),
(3, b'0', 'A', '.png', '54aaf8e6-fa34-4331-9706-8fde78912352', 'Arroz Con Pollo'),
(4, b'0', 'A', '.png', '02a988d5-3918-4eac-8217-4106a37ecc9a', 'Tallarines'),
(5, b'0', 'A', '.png', '16d217d4-f119-410e-b219-116954fd66f2', 'Tallarines Verdes'),
(6, b'0', 'A', '.png', '4a289188-b8f0-4699-811d-76b2614325d4', 'Tallarines Rojos'),
(7, b'0', 'A', '.png', '37bf3d83-8550-4b8e-a710-076d9907be98', 'Arroz'),
(8, b'0', 'A', '.png', 'df453f5a-8587-4759-b51f-7ef6152059bc', 'Arroz Chaufa'),
(9, b'0', 'A', '.jpg', 'd7b80d86-a12c-4a7d-8a54-f3792ce16446', 'profilePh28202111144'),
(10, b'0', 'A', '.jpg', 'a085d757-07d4-43f1-a18d-df86d99622d3', 'Postres');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `anular_pedido` bit(1) DEFAULT NULL,
  `fecha_compra` datetime DEFAULT NULL,
  `monto` double DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platillo`
--

CREATE TABLE `platillo` (
  `id` int(11) NOT NULL,
  `descripcion_platillo` varchar(500) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `vigencia` bit(1) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `foto_id` bigint(20) DEFAULT NULL,
  `recomendado` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `platillo`
--

INSERT INTO `platillo` (`id`, `descripcion_platillo`, `nombre`, `precio`, `stock`, `vigencia`, `categoria_id`, `foto_id`, `recomendado`) VALUES
(1, 'El mejor plato del norte a tu casa', 'Arroz con Pollo', 15.5, 20, b'1', 2, 3, b'1'),
(2, 'Tallarines rojos con unos ricos hongos y laurel que le da el toque de casa', 'Tallarines Rojos', 10, 20, b'1', 1, 6, b'0'),
(3, 'No existe información del producto', 'Tallarines Verdes', 30, 20, b'1', 1, 5, b'1'),
(4, 'No existe información del Producto', 'Arroz Chaufa', 10, 50, b'1', 2, 8, b'1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `clave` varchar(20) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `vigencia` bit(1) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `clave`, `email`, `vigencia`, `cliente_id`) VALUES
(1, 'admin123', 'oantonio@gmail.com', b'1', 1),
(2, 'xime123', 'ximena@live.com', b'1', 5),
(3, '123', 'alexanderfuentes1912@gmail.com', b'1', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKbyh5eextelhhs5gyxj7giuspd` (`foto_id`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKorx40wtfkkqg46bht8mt4vb3a` (`foto_id`);

--
-- Indices de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKgqvba9e7dildyw45u0usdj1k2` (`pedido_id`),
  ADD KEY `FKhyip16w63t7nx78o23cu3fks4` (`platillo_id`);

--
-- Indices de la tabla `documento_almacenado`
--
ALTER TABLE `documento_almacenado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK30s8j2ktpay6of18lbyqn3632` (`cliente_id`);

--
-- Indices de la tabla `platillo`
--
ALTER TABLE `platillo`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKkchwn4n0badohpdsfeb2qwbca` (`categoria_id`),
  ADD KEY `FK42mi3n2tu0656xlm58cpaojb` (`foto_id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp3dqdf5mc3lqr5y9p3b0omjl9` (`cliente_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `documento_almacenado`
--
ALTER TABLE `documento_almacenado`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `platillo`
--
ALTER TABLE `platillo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD CONSTRAINT `FKbyh5eextelhhs5gyxj7giuspd` FOREIGN KEY (`foto_id`) REFERENCES `documento_almacenado` (`id`);

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FKorx40wtfkkqg46bht8mt4vb3a` FOREIGN KEY (`foto_id`) REFERENCES `documento_almacenado` (`id`);

--
-- Filtros para la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  ADD CONSTRAINT `FKgqvba9e7dildyw45u0usdj1k2` FOREIGN KEY (`pedido_id`) REFERENCES `pedido` (`id`),
  ADD CONSTRAINT `FKhyip16w63t7nx78o23cu3fks4` FOREIGN KEY (`platillo_id`) REFERENCES `platillo` (`id`);

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK30s8j2ktpay6of18lbyqn3632` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);

--
-- Filtros para la tabla `platillo`
--
ALTER TABLE `platillo`
  ADD CONSTRAINT `FK42mi3n2tu0656xlm58cpaojb` FOREIGN KEY (`foto_id`) REFERENCES `documento_almacenado` (`id`),
  ADD CONSTRAINT `FKkchwn4n0badohpdsfeb2qwbca` FOREIGN KEY (`categoria_id`) REFERENCES `categoria` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FKp3dqdf5mc3lqr5y9p3b0omjl9` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
