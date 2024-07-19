-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 20-07-2024 a las 00:13:07
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

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
(1, 'Pastillas', b'1', 2),
(2, 'Cremas', b'1', 3),
(3, 'Jarabes', b'1', 4),
(4, 'Jeringas', b'1', 5),
(5, 'Preservativo', b'1', 7),
(6, 'Geles', b'1', 6),
(7, 'Fragancias', b'1', 8),
(8, 'Cuidado Bucal', b'1', 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `apellido_materno` varchar(100) DEFAULT NULL,
  `apellido_paterno` varchar(100) DEFAULT NULL,
  `departamento` varchar(100) DEFAULT NULL,
  `direccion_envio` varchar(500) DEFAULT NULL,
  `distrito` varchar(100) DEFAULT NULL,
  `nombres` varchar(100) DEFAULT NULL,
  `num_doc` varchar(11) DEFAULT NULL,
  `provincia` varchar(100) DEFAULT NULL,
  `telefono` varchar(9) DEFAULT NULL,
  `tipo_doc` varchar(20) DEFAULT NULL,
  `foto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `apellido_materno`, `apellido_paterno`, `departamento`, `direccion_envio`, `distrito`, `nombres`, `num_doc`, `provincia`, `telefono`, `tipo_doc`, `foto_id`) VALUES
(1, 'Medina', 'Fuentes', 'Lambayeque', 'Calle Prolongación Sucre 903\nU.V \"Casimiro Chuman\"', 'Ferreñafe', 'Luigui Alexander', '10780197787', 'Ferreñafe', '917967148', 'RUC', 1),
(2, 'Sandoval', 'Torres', 'Lambayeque', 'Calle Prolongación Sucre 903\n', 'Ferreñafe', 'Luigui', '78019778', 'Ferreñafe', '917635231', 'DNI', 13);

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

--
-- Volcado de datos para la tabla `detalle_pedido`
--

INSERT INTO `detalle_pedido` (`id`, `cantidad`, `precio`, `pedido_id`, `platillo_id`) VALUES
(1, 3, 54.32, 1, 5),
(2, 2, 30.32, 1, 6),
(3, 3, 10.64, 1, 10),
(4, 2, 8.96, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `dispositivo`
--

CREATE TABLE `dispositivo` (
  `id` int(11) NOT NULL,
  `device_id` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `dispositivo`
--

INSERT INTO `dispositivo` (`id`, `device_id`) VALUES
(1, 'cIfqygqZQdSqpODBrgLihR:APA91bE0xsTctDbYntAPzb-BhPYwdStEI6cOGjefFLs1QVorzpdvZ9XIe3KpEfftzzI59CMbL1B1mGyIpe68wI4EbPYDPc1ogwEBG93QJnCua1Z7oeh_kziRgQ4G0z_wXabMTWQ8hN9S');

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
(1, b'0', 'A', '.jpeg', '8aed77d5-ce89-4df2-9e18-443983f3e7ea', 'profilePh27202419494'),
(2, b'0', 'A', '.jpeg', 'a905f5b3-1d02-42e5-9418-2b295a1f1023', 'C-Pastillas'),
(3, b'0', 'A', '.jpeg', '420fbcfe-4c22-4dad-a239-027bff2f1f88', 'C-Cremas'),
(4, b'0', 'A', '.jpeg', '9a833ea3-915d-4aaa-a347-962f43f68b82', 'C-Jarabes'),
(5, b'0', 'A', '.jpg', '23eaa6e3-30cd-48a1-91c3-48713208b077', 'C-Jeringas'),
(6, b'0', 'A', '.jpeg', '2bbf6625-c94c-4d5b-9d52-c53b12757006', 'C-Geles'),
(7, b'0', 'A', '.jpg', '2266e1be-b165-4f4b-be8c-1607246247c2', 'C-Preservativo'),
(8, b'0', 'A', '.jpeg', '7c05ec0d-9af2-414b-9f47-33d189ddaca6', 'C-Fragancias'),
(9, b'0', 'A', '.jpeg', '313ab5db-fe40-43e5-b1a8-5031e8ab9731', 'P-Kitadol'),
(10, b'0', 'A', '.jpg', '57fab6e4-0c99-4ae6-b12e-e2e16a14fd0b', 'P-Bioelectro'),
(11, b'0', 'A', '.png', '8f69998a-478a-4927-95e8-ab6747d8d2c5', 'P-Enjuage'),
(12, b'0', 'A', '.jpg', '1f1d03e8-4338-4525-af5e-69dfc9a1ad78', 'B-Oferta-1'),
(13, b'0', 'A', '.jpeg', '07c9169c-c9ed-4720-9ede-cbf049adecb4', 'profilePh872024201246'),
(14, b'0', 'A', '.jpg', '18958ca7-cf4b-48dc-9f87-19f3b045b1cb', 'B-Oferta-2'),
(15, b'0', 'A', '.jpg', 'be492f61-7e71-4f02-ac71-df16eb879125', 'B-Oferta-3'),
(16, b'0', 'A', '.jpg', 'b868a078-9d93-47ce-b77d-0b3fe9436d4e', 'B-Oferta-4'),
(17, b'0', 'A', '.jpg', '5f2fe3b7-4bc8-4e3c-b875-aa08478ecb70', 'P-OralB-1'),
(18, b'0', 'A', '.jpg', '10ad2575-d24a-4b89-bb71-426611ae3666', 'P-OralB-2'),
(19, b'0', 'A', '.jpg', 'e46d78a5-0bdc-446b-afea-0fc5137ac46f', 'P-OralB-3'),
(20, b'0', 'A', '.jpg', '457cd90a-eb2c-4b3c-8536-4a41e35d152d', 'P-Colgate-4'),
(21, b'0', 'A', '.jpg', '54494ea0-64c5-46b5-8083-f5301e110c65', 'P-Colgate-5'),
(22, b'0', 'A', '.jpg', '746077b7-6fd9-48e7-abf1-6da6bda10f62', 'P-Durex-2'),
(23, b'0', 'A', '.jpg', 'fd8a7431-6072-4590-80bf-fe37b96cfe3f', 'P-Durex-3'),
(24, b'0', 'A', '.jpg', '9ba7d8e9-b8f6-40bf-a215-96f904b4d3bc', 'P-Durex-4'),
(25, b'0', 'A', '.jpg', '55c090c6-8198-44a3-9680-7bef0cf0ea8e', 'P-Durex-5'),
(26, b'0', 'A', '.jpg', '95e63d29-5dc7-4645-bcb1-31d9017f3ce6', 'P-Durex-7'),
(27, b'0', 'A', '.png', '43b744ac-3260-4269-9767-950a750867c5', 'C-CuidadoBucal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id` bigint(20) NOT NULL,
  `apellidos` varchar(100) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `numero_documento` varchar(11) DEFAULT NULL,
  `password` varchar(10) DEFAULT NULL,
  `tipo_documento` varchar(3) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `vigencia` bit(1) DEFAULT NULL,
  `rol_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta`
--

CREATE TABLE `oferta` (
  `id` int(11) NOT NULL,
  `descripcion_oferta` varchar(255) DEFAULT NULL,
  `fecha_fin` date DEFAULT NULL,
  `fecha_inicio` date DEFAULT NULL,
  `nombre_oferta` varchar(255) DEFAULT NULL,
  `vigencia` bit(1) DEFAULT NULL,
  `banner_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `oferta`
--

INSERT INTO `oferta` (`id`, `descripcion_oferta`, `fecha_fin`, `fecha_inicio`, `nombre_oferta`, `vigencia`, `banner_id`) VALUES
(1, 'Aprovecha el 20% en todos los Preservativos de diferentes marcas desde el 21 de junio hasta el 30 de junio.', '2024-06-30', '2024-06-21', '20% en todos los Preservativos de diferentes marcas', b'1', 12),
(2, 'Aprovecha hasta el 10% de descuento en productos Vital. Promoción válida hasta 30 de junio y/o agotar stock.', '2024-06-30', '2024-06-21', '10% de descuento en productos Vital', b'1', 14),
(3, 'Packs de cuidado bucal desde 39.90 en la marca Colgate, Oral-B, Gillete y Doctor. Promoción válida hasta el 30 de junio.', '2024-06-30', '2024-06-21', 'Packs de cuidado bucal desde 39.90', b'1', 15),
(4, 'Desodorantes de 150 ml a mitad de precio. Promoción hasta el 30 de junio y/o agotar stock', '2024-06-30', '2024-06-21', 'Desodorantes de 150 ml a mitad de precio.', b'1', 16);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `oferta_producto`
--

CREATE TABLE `oferta_producto` (
  `id` int(11) NOT NULL,
  `descuento` int(11) DEFAULT NULL,
  `precio_ahora` double DEFAULT NULL,
  `id_oferta_id` int(11) DEFAULT NULL,
  `id_platillo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `oferta_producto`
--

INSERT INTO `oferta_producto` (`id`, `descuento`, `precio_ahora`, `id_oferta_id`, `id_platillo_id`) VALUES
(1, 20, 8.96, 1, 1),
(2, 20, 10.64, 1, 10),
(3, 20, 27.04, 1, 13),
(4, 20, 42.64, 1, 14),
(5, 20, 54.32, 3, 5),
(6, 20, 30.32, 3, 6),
(7, 20, 116.72, 3, 7),
(8, 20, 16.72, 3, 8);

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

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `anular_pedido`, `fecha_compra`, `monto`, `cliente_id`) VALUES
(1, b'0', '2024-06-22 00:00:00', 341.8, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `platillo`
--

CREATE TABLE `platillo` (
  `id` int(11) NOT NULL,
  `descripcion_platillo` varchar(500) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `recomendado` bit(1) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `vigencia` bit(1) DEFAULT NULL,
  `categoria_id` int(11) DEFAULT NULL,
  `foto_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `platillo`
--

INSERT INTO `platillo` (`id`, `descripcion_platillo`, `nombre`, `precio`, `recomendado`, `stock`, `vigencia`, `categoria_id`, `foto_id`) VALUES
(1, 'Texturizado con estrías y puntos\r\nLubricado con fluido de silicón\r\nLargo 195 mm, Ancho 56 mm, espesor 0,052 mm (valores nominales)\r\nR.S: DM0861E\r\nLos preservativos Durex Placer Prolongados, está elaborado con un lubricante especial que contiene benzocaína que ayuda al hombre a retardar el clímax y a prolongar el placer. Cuenta con forma anatómica. Largo 195 mm, Ancho nominal 56 mm, espesor 0.052 mm.', 'Preservativos Durex Placer Prolongado', 11.2, b'1', 84, b'1', 5, 7),
(3, 'Analgésico\r\nRegistro Sanitario N-26449\r\nParacetamol 500mg | Cafeína 65mg\r\nHipersensibilidad a Paracetamol, Cafeína y/o otros excipientes. Este medicamento no debe ser usado por personas a quienes se les ha diagnosticado hipertensión o que reciben medicamentos antihipertensivos, o que tienen antecedentes de arritmia cardiaca. Este medicamento no debe ser usado por pacientes que se recuperan de alcoholismo crónico que toman Disulfiram.', 'Kitadol Migraña Tableta Recubierta', 1.25, b'1', 92, b'1', 1, 9),
(4, 'Analgésico\r\nRegistro Sanitario N-26449\r\nParacetamol 500mg | Cafeína 65mg', 'Kitadol Migraña Tableta Recubierta', 1.25, b'1', 100, b'1', 1, 10),
(5, 'Remueve más placa que un cepillo manual. Mejora la salud de las encía. Mango ergonómico de goma suave Contiene 2 pilas AA', 'Cepillo de Dientes Eléctrico Oral-B Pro-Salud de Pilas', 67.9, b'1', 97, b'1', 8, 17),
(6, 'Promueve una boca y encías sanas. Compatible con cepillos eléctricos Oral-B. Limpia áreas de difícil alcance. Incluye 2 cabezales de repuesto.', 'Repuesto para Cepillo Eléctrico Oral-B Cross Action', 37.9, b'1', 98, b'1', 8, 18),
(7, 'Máxima remoción de placa bacteriana. Acción de limpieza Superior. Cabezal redondo.', 'Cepillo de Dientes Eléctrico Oral-B Vitality 100', 145.9, b'0', 100, b'1', 8, 19),
(8, 'Crema dental anticaries con flúor\r\nPoderosa remoción de manchas\r\nPasta Dental Blanqueadora\r\nRegistro Sanitario: NSOC44215-11CO', 'Pasta Dental Colgate Luminous White', 20.9, b'1', 100, b'1', 8, 20),
(9, 'Protección anticaries\r\nExtra blancura\r\nAliento fresco por más tiempo\r\nNSOC72336-16CO', 'Pasta Dental Colgate Triple Acción', 12.8, b'0', 100, b'1', 8, 21),
(10, 'Látex sintético de polisopreno\r\nIdeal para personas alérgicas al látex natural\r\nLargo 195 mm, Ancho nominal 56 mm\r\nDM8538E', 'Preservativos Durex Real Feel', 13.3, b'1', 97, b'1', 5, 22),
(11, 'Largo 195 mm, Ancho nominal 56 mm, espesor 0,065 mm (valores nominales)\r\nCon lubricante a base de agua\r\nCondón Transparente de Látex natural\r\nR.S: DM1309E', 'Preservativos Durex Clásico', 8.7, b'0', 100, b'1', 5, 23),
(12, 'Puntos y estrías que aceleran el clímax\r\nLubricado con fluido silicón\r\nMaterial en látex natural\r\nR.S: DM1293E', 'Preservativos Durex Máximo Placer', 10.8, b'0', 100, b'1', 5, 24),
(13, 'Preservativos Durex Invisible - R.S: DM1184E\r\nGel Lubricante - R.S: DM118000E', 'Pack Preservativos Durex Invisible + Gel Lubricante Durex Cerezas de Pasión', 33.8, b'0', 100, b'1', 5, 25),
(14, 'Preservativos Durex - R.S: DM0861E\r\nGel Lubricante - R.S: DM-19746E', 'Pack Preservativos Durex Placer Prolongado + Gel Lubricante Durex Naturals', 53.3, b'0', 100, b'1', 5, 26);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `clave` varchar(20) DEFAULT NULL,
  `email` varchar(500) DEFAULT NULL,
  `vigencia` bit(1) DEFAULT NULL,
  `cliente_id` int(11) DEFAULT NULL,
  `dispositivo_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `clave`, `email`, `vigencia`, `cliente_id`, `dispositivo_id`) VALUES
(1, '123', 'fuentesalexander61@gmail.com', b'1', 1, 1),
(2, '123', 'alexanderfuentes199912@gmail.com', b'1', 2, 1);

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
-- Indices de la tabla `dispositivo`
--
ALTER TABLE `dispositivo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `documento_almacenado`
--
ALTER TABLE `documento_almacenado`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKqudsrbctju4p60b7n0cdalf6d` (`rol_id`);

--
-- Indices de la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKlkd1k60h0t9kd9tel7b3cjrj6` (`banner_id`);

--
-- Indices de la tabla `oferta_producto`
--
ALTER TABLE `oferta_producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKiqrebs4maq47te9fxwqjsa4xg` (`id_oferta_id`),
  ADD KEY `FKsbm6xssc84v2egp2q6fun1q1x` (`id_platillo_id`);

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
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKp3dqdf5mc3lqr5y9p3b0omjl9` (`cliente_id`),
  ADD KEY `FK84vl5opawivrk1dpysyjlnq8k` (`dispositivo_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `detalle_pedido`
--
ALTER TABLE `detalle_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `dispositivo`
--
ALTER TABLE `dispositivo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `documento_almacenado`
--
ALTER TABLE `documento_almacenado`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `oferta`
--
ALTER TABLE `oferta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `oferta_producto`
--
ALTER TABLE `oferta_producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `platillo`
--
ALTER TABLE `platillo`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `FKqudsrbctju4p60b7n0cdalf6d` FOREIGN KEY (`rol_id`) REFERENCES `rol` (`id`);

--
-- Filtros para la tabla `oferta`
--
ALTER TABLE `oferta`
  ADD CONSTRAINT `FKlkd1k60h0t9kd9tel7b3cjrj6` FOREIGN KEY (`banner_id`) REFERENCES `documento_almacenado` (`id`);

--
-- Filtros para la tabla `oferta_producto`
--
ALTER TABLE `oferta_producto`
  ADD CONSTRAINT `FKiqrebs4maq47te9fxwqjsa4xg` FOREIGN KEY (`id_oferta_id`) REFERENCES `oferta` (`id`),
  ADD CONSTRAINT `FKsbm6xssc84v2egp2q6fun1q1x` FOREIGN KEY (`id_platillo_id`) REFERENCES `platillo` (`id`);

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
  ADD CONSTRAINT `FK84vl5opawivrk1dpysyjlnq8k` FOREIGN KEY (`dispositivo_id`) REFERENCES `dispositivo` (`id`),
  ADD CONSTRAINT `FKp3dqdf5mc3lqr5y9p3b0omjl9` FOREIGN KEY (`cliente_id`) REFERENCES `cliente` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
