-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: tpfinalRugnaSantiago
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `CLIENTE`
--

DROP TABLE IF EXISTS `CLIENTE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENTE` (
  `ID` bigint NOT NULL,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `APELLIDO` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CELULAR` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIRECCION` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DNI` int DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHANACIMIENTO` date DEFAULT NULL,
  `NACIONALIDAD` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE`
--

LOCK TABLES `CLIENTE` WRITE;
/*!40000 ALTER TABLE `CLIENTE` DISABLE KEYS */;
INSERT INTO `CLIENTE` VALUES (3,1,'Perez','123123','Bs As',45389167,'correo@gmail.com','2021-12-02','Arg','Juan'),(4,1,'Gomez','123123','Bs As',34345345,'correo@gmail.com','2021-12-08','Arg','Dario'),(11,1,'Francescoli','12345','Uruguay',48564545,'correo@gmail.com','2021-12-16','Uru','Enzo');
/*!40000 ALTER TABLE `CLIENTE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CLIENTE_VENTA`
--

DROP TABLE IF EXISTS `CLIENTE_VENTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CLIENTE_VENTA` (
  `Cliente_ID` bigint NOT NULL,
  `listaVentas_NUMERO` bigint NOT NULL,
  PRIMARY KEY (`Cliente_ID`,`listaVentas_NUMERO`),
  KEY `FK_CLIENTE_VENTA_listaVentas_NUMERO` (`listaVentas_NUMERO`),
  CONSTRAINT `FK_CLIENTE_VENTA_Cliente_ID` FOREIGN KEY (`Cliente_ID`) REFERENCES `CLIENTE` (`ID`),
  CONSTRAINT `FK_CLIENTE_VENTA_listaVentas_NUMERO` FOREIGN KEY (`listaVentas_NUMERO`) REFERENCES `VENTA` (`NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CLIENTE_VENTA`
--

LOCK TABLES `CLIENTE_VENTA` WRITE;
/*!40000 ALTER TABLE `CLIENTE_VENTA` DISABLE KEYS */;
INSERT INTO `CLIENTE_VENTA` VALUES (11,12),(4,13),(3,16);
/*!40000 ALTER TABLE `CLIENTE_VENTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLEADO`
--

DROP TABLE IF EXISTS `EMPLEADO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EMPLEADO` (
  `ID` bigint NOT NULL,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `APELLIDO` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CARGO` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `CELULAR` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DIRECCION` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DNI` int DEFAULT NULL,
  `EMAIL` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHANACIMIENTO` date DEFAULT NULL,
  `NACIONALIDAD` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `SUELDO` double DEFAULT NULL,
  `USUARIO_ID` bigint DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_EMPLEADO_USUARIO_ID` (`USUARIO_ID`),
  CONSTRAINT `FK_EMPLEADO_USUARIO_ID` FOREIGN KEY (`USUARIO_ID`) REFERENCES `USUARIO` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLEADO`
--

LOCK TABLES `EMPLEADO` WRITE;
/*!40000 ALTER TABLE `EMPLEADO` DISABLE KEYS */;
INSERT INTO `EMPLEADO` VALUES (2,1,'Rugna','Programador','123123','895',29747931,'maxirp9@gmail.com','1982-04-06','Arg','Santiago Maximiliano ',10000,1),(10,0,'Perez','Vendedor','123123','Bs As',45888999,'correo@gmail.com','2021-12-16','Arg','Juan Andres',10000,9);
/*!40000 ALTER TABLE `EMPLEADO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `EMPLEADO_VENTA`
--

DROP TABLE IF EXISTS `EMPLEADO_VENTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `EMPLEADO_VENTA` (
  `Empleado_ID` bigint NOT NULL,
  `listaVentas_NUMERO` bigint NOT NULL,
  PRIMARY KEY (`Empleado_ID`,`listaVentas_NUMERO`),
  KEY `FK_EMPLEADO_VENTA_listaVentas_NUMERO` (`listaVentas_NUMERO`),
  CONSTRAINT `FK_EMPLEADO_VENTA_Empleado_ID` FOREIGN KEY (`Empleado_ID`) REFERENCES `EMPLEADO` (`ID`),
  CONSTRAINT `FK_EMPLEADO_VENTA_listaVentas_NUMERO` FOREIGN KEY (`listaVentas_NUMERO`) REFERENCES `VENTA` (`NUMERO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `EMPLEADO_VENTA`
--

LOCK TABLES `EMPLEADO_VENTA` WRITE;
/*!40000 ALTER TABLE `EMPLEADO_VENTA` DISABLE KEYS */;
INSERT INTO `EMPLEADO_VENTA` VALUES (10,12),(10,13),(10,16);
/*!40000 ALTER TABLE `EMPLEADO_VENTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAQUETE`
--

DROP TABLE IF EXISTS `PAQUETE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PAQUETE` (
  `CODIGO` bigint NOT NULL,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `COSTO` double DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAQUETE`
--

LOCK TABLES `PAQUETE` WRITE;
/*!40000 ALTER TABLE `PAQUETE` DISABLE KEYS */;
INSERT INTO `PAQUETE` VALUES (8,1,1080,'Viaje a Bariloche'),(15,1,810,'Viajes combo');
/*!40000 ALTER TABLE `PAQUETE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAQUETE_SERVICIO`
--

DROP TABLE IF EXISTS `PAQUETE_SERVICIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PAQUETE_SERVICIO` (
  `Paquete_CODIGO` bigint NOT NULL,
  `listaServicios_CODIGO` bigint NOT NULL,
  PRIMARY KEY (`Paquete_CODIGO`,`listaServicios_CODIGO`),
  KEY `FK_PAQUETE_SERVICIO_listaServicios_CODIGO` (`listaServicios_CODIGO`),
  CONSTRAINT `FK_PAQUETE_SERVICIO_listaServicios_CODIGO` FOREIGN KEY (`listaServicios_CODIGO`) REFERENCES `SERVICIO` (`CODIGO`),
  CONSTRAINT `FK_PAQUETE_SERVICIO_Paquete_CODIGO` FOREIGN KEY (`Paquete_CODIGO`) REFERENCES `PAQUETE` (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAQUETE_SERVICIO`
--

LOCK TABLES `PAQUETE_SERVICIO` WRITE;
/*!40000 ALTER TABLE `PAQUETE_SERVICIO` DISABLE KEYS */;
INSERT INTO `PAQUETE_SERVICIO` VALUES (8,5),(8,6),(15,7),(15,14);
/*!40000 ALTER TABLE `PAQUETE_SERVICIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PAQUETE_VENTA`
--

DROP TABLE IF EXISTS `PAQUETE_VENTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PAQUETE_VENTA` (
  `Paquete_CODIGO` bigint NOT NULL,
  `listaVentas_NUMERO` bigint NOT NULL,
  PRIMARY KEY (`Paquete_CODIGO`,`listaVentas_NUMERO`),
  KEY `FK_PAQUETE_VENTA_listaVentas_NUMERO` (`listaVentas_NUMERO`),
  CONSTRAINT `FK_PAQUETE_VENTA_listaVentas_NUMERO` FOREIGN KEY (`listaVentas_NUMERO`) REFERENCES `VENTA` (`NUMERO`),
  CONSTRAINT `FK_PAQUETE_VENTA_Paquete_CODIGO` FOREIGN KEY (`Paquete_CODIGO`) REFERENCES `PAQUETE` (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PAQUETE_VENTA`
--

LOCK TABLES `PAQUETE_VENTA` WRITE;
/*!40000 ALTER TABLE `PAQUETE_VENTA` DISABLE KEYS */;
INSERT INTO `PAQUETE_VENTA` VALUES (8,13),(15,16);
/*!40000 ALTER TABLE `PAQUETE_VENTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SEQUENCE`
--

DROP TABLE IF EXISTS `SEQUENCE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SEQUENCE` (
  `SEQ_NAME` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `SEQ_COUNT` decimal(38,0) DEFAULT NULL,
  PRIMARY KEY (`SEQ_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SEQUENCE`
--

LOCK TABLES `SEQUENCE` WRITE;
/*!40000 ALTER TABLE `SEQUENCE` DISABLE KEYS */;
INSERT INTO `SEQUENCE` VALUES ('SEQ_GEN',50);
/*!40000 ALTER TABLE `SEQUENCE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SERVICIO`
--

DROP TABLE IF EXISTS `SERVICIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SERVICIO` (
  `CODIGO` bigint NOT NULL,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `COSTO` double DEFAULT NULL,
  `DESCRIPCION_BREVE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DESTINO` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `FECHA` date DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SERVICIO`
--

LOCK TABLES `SERVICIO` WRITE;
/*!40000 ALTER TABLE `SERVICIO` DISABLE KEYS */;
INSERT INTO `SERVICIO` VALUES (5,1,200,'Hotel en Bariloche','Bariloche','2021-12-08','Hotel 5*'),(6,1,1000,'Pasajes de avion','Bariloche','2021-12-17','Vuelo Bariloche'),(7,1,400,'Pasajes de tren','Mar del Plata','2021-12-10','Tren Mar del Plata'),(14,1,500,'Colectivo a Cordoba ','Cordoba','2021-12-11','Colectivo a Cordoba ');
/*!40000 ALTER TABLE `SERVICIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SERVICIO_PAQUETE`
--

DROP TABLE IF EXISTS `SERVICIO_PAQUETE`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SERVICIO_PAQUETE` (
  `Servicio_CODIGO` bigint NOT NULL,
  `listaPaquetes_CODIGO` bigint NOT NULL,
  PRIMARY KEY (`Servicio_CODIGO`,`listaPaquetes_CODIGO`),
  KEY `FK_SERVICIO_PAQUETE_listaPaquetes_CODIGO` (`listaPaquetes_CODIGO`),
  CONSTRAINT `FK_SERVICIO_PAQUETE_listaPaquetes_CODIGO` FOREIGN KEY (`listaPaquetes_CODIGO`) REFERENCES `PAQUETE` (`CODIGO`),
  CONSTRAINT `FK_SERVICIO_PAQUETE_Servicio_CODIGO` FOREIGN KEY (`Servicio_CODIGO`) REFERENCES `SERVICIO` (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SERVICIO_PAQUETE`
--

LOCK TABLES `SERVICIO_PAQUETE` WRITE;
/*!40000 ALTER TABLE `SERVICIO_PAQUETE` DISABLE KEYS */;
INSERT INTO `SERVICIO_PAQUETE` VALUES (5,8),(6,8),(7,15),(14,15);
/*!40000 ALTER TABLE `SERVICIO_PAQUETE` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `SERVICIO_VENTA`
--

DROP TABLE IF EXISTS `SERVICIO_VENTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `SERVICIO_VENTA` (
  `Servicio_CODIGO` bigint NOT NULL,
  `listaVentas_NUMERO` bigint NOT NULL,
  PRIMARY KEY (`Servicio_CODIGO`,`listaVentas_NUMERO`),
  KEY `FK_SERVICIO_VENTA_listaVentas_NUMERO` (`listaVentas_NUMERO`),
  CONSTRAINT `FK_SERVICIO_VENTA_listaVentas_NUMERO` FOREIGN KEY (`listaVentas_NUMERO`) REFERENCES `VENTA` (`NUMERO`),
  CONSTRAINT `FK_SERVICIO_VENTA_Servicio_CODIGO` FOREIGN KEY (`Servicio_CODIGO`) REFERENCES `SERVICIO` (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `SERVICIO_VENTA`
--

LOCK TABLES `SERVICIO_VENTA` WRITE;
/*!40000 ALTER TABLE `SERVICIO_VENTA` DISABLE KEYS */;
INSERT INTO `SERVICIO_VENTA` VALUES (6,12);
/*!40000 ALTER TABLE `SERVICIO_VENTA` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USUARIO`
--

DROP TABLE IF EXISTS `USUARIO`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `USUARIO` (
  `ID` bigint NOT NULL,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `CONTRASENIA` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `NOMBRE` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USUARIO`
--

LOCK TABLES `USUARIO` WRITE;
/*!40000 ALTER TABLE `USUARIO` DISABLE KEYS */;
INSERT INTO `USUARIO` VALUES (1,1,'1234','maxi'),(9,1,'1234','juan');
/*!40000 ALTER TABLE `USUARIO` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `VENTA`
--

DROP TABLE IF EXISTS `VENTA`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `VENTA` (
  `NUMERO` bigint NOT NULL,
  `ACTIVO` tinyint(1) DEFAULT '0',
  `FECHA` date DEFAULT NULL,
  `MEDIOPAGO` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `UNCLIENTE_ID` bigint DEFAULT NULL,
  `UNEMPLEADO_ID` bigint DEFAULT NULL,
  `UNPAQUETE_CODIGO` bigint DEFAULT NULL,
  `UNSERVICIO_CODIGO` bigint DEFAULT NULL,
  PRIMARY KEY (`NUMERO`),
  KEY `FK_VENTA_UNSERVICIO_CODIGO` (`UNSERVICIO_CODIGO`),
  KEY `FK_VENTA_UNCLIENTE_ID` (`UNCLIENTE_ID`),
  KEY `FK_VENTA_UNPAQUETE_CODIGO` (`UNPAQUETE_CODIGO`),
  KEY `FK_VENTA_UNEMPLEADO_ID` (`UNEMPLEADO_ID`),
  CONSTRAINT `FK_VENTA_UNCLIENTE_ID` FOREIGN KEY (`UNCLIENTE_ID`) REFERENCES `CLIENTE` (`ID`),
  CONSTRAINT `FK_VENTA_UNEMPLEADO_ID` FOREIGN KEY (`UNEMPLEADO_ID`) REFERENCES `EMPLEADO` (`ID`),
  CONSTRAINT `FK_VENTA_UNPAQUETE_CODIGO` FOREIGN KEY (`UNPAQUETE_CODIGO`) REFERENCES `PAQUETE` (`CODIGO`),
  CONSTRAINT `FK_VENTA_UNSERVICIO_CODIGO` FOREIGN KEY (`UNSERVICIO_CODIGO`) REFERENCES `SERVICIO` (`CODIGO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `VENTA`
--

LOCK TABLES `VENTA` WRITE;
/*!40000 ALTER TABLE `VENTA` DISABLE KEYS */;
INSERT INTO `VENTA` VALUES (12,1,'2021-12-16','efec',11,10,NULL,6),(13,1,'2021-12-23','efec',4,10,8,NULL),(16,1,'2021-12-23','efec',3,10,15,NULL);
/*!40000 ALTER TABLE `VENTA` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-20 20:32:03
