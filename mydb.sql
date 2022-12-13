-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `c_area`
--

DROP TABLE IF EXISTS `c_area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `c_area` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `etiqueta` varchar(45) NOT NULL,
  PRIMARY KEY (`id_area`),
  UNIQUE KEY `etiqueta_UNIQUE` (`etiqueta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_area`
--

LOCK TABLES `c_area` WRITE;
/*!40000 ALTER TABLE `c_area` DISABLE KEYS */;
INSERT INTO `c_area` VALUES (2,'BIBLIOTECA'),(1,'ESTADISTICA');
/*!40000 ALTER TABLE `c_area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_marca_impresora`
--

DROP TABLE IF EXISTS `c_marca_impresora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `c_marca_impresora` (
  `id_marca_impresora` int NOT NULL AUTO_INCREMENT,
  `etiqueta` varchar(45) NOT NULL,
  PRIMARY KEY (`id_marca_impresora`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_marca_impresora`
--

LOCK TABLES `c_marca_impresora` WRITE;
/*!40000 ALTER TABLE `c_marca_impresora` DISABLE KEYS */;
INSERT INTO `c_marca_impresora` VALUES (1,'HP'),(2,'CANON');
/*!40000 ALTER TABLE `c_marca_impresora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_tipo_impresion`
--

DROP TABLE IF EXISTS `c_tipo_impresion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `c_tipo_impresion` (
  `id_tipoImp` int NOT NULL AUTO_INCREMENT,
  `etiqueta` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipoImp`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_tipo_impresion`
--

LOCK TABLES `c_tipo_impresion` WRITE;
/*!40000 ALTER TABLE `c_tipo_impresion` DISABLE KEYS */;
INSERT INTO `c_tipo_impresion` VALUES (1,'DUPLEX'),(2,'DIGITAL');
/*!40000 ALTER TABLE `c_tipo_impresion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_tipo_impresora`
--

DROP TABLE IF EXISTS `c_tipo_impresora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `c_tipo_impresora` (
  `id_tipo_impresora` int NOT NULL AUTO_INCREMENT,
  `etiqueta` varchar(45) NOT NULL,
  `bandera` varchar(45) NOT NULL,
  PRIMARY KEY (`id_tipo_impresora`),
  UNIQUE KEY `etiqueta_UNIQUE` (`etiqueta`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_tipo_impresora`
--

LOCK TABLES `c_tipo_impresora` WRITE;
/*!40000 ALTER TABLE `c_tipo_impresora` DISABLE KEYS */;
INSERT INTO `c_tipo_impresora` VALUES (1,'CARTUCHOS','INYECCION'),(2,'INYECCION','BN/COLOR');
/*!40000 ALTER TABLE `c_tipo_impresora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_impresora`
--

DROP TABLE IF EXISTS `t_impresora`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_impresora` (
  `id_impresora` int NOT NULL AUTO_INCREMENT,
  `numero_serie` varchar(45) NOT NULL,
  `id_marca_impresora` int NOT NULL,
  `id_area` int NOT NULL,
  `id_tipo_impresora` int NOT NULL,
  `descripcion_imp` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_impresora`),
  KEY `fk_impresora_area_idx` (`id_area`),
  KEY `fk_impresora_tipo_impresora_idx` (`id_tipo_impresora`),
  KEY `fk_impresora_marca_impresora_idx` (`id_marca_impresora`),
  CONSTRAINT `fk_impresora_area` FOREIGN KEY (`id_area`) REFERENCES `c_area` (`id_area`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_impresora_marca_impresora` FOREIGN KEY (`id_marca_impresora`) REFERENCES `c_marca_impresora` (`id_marca_impresora`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_impresora_tipo_impresora` FOREIGN KEY (`id_tipo_impresora`) REFERENCES `c_tipo_impresora` (`id_tipo_impresora`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_impresora`
--

LOCK TABLES `t_impresora` WRITE;
/*!40000 ALTER TABLE `t_impresora` DISABLE KEYS */;
INSERT INTO `t_impresora` VALUES (2,'2',2,1,2,'prueba2'),(4,'123789',2,2,2,'');
/*!40000 ALTER TABLE `t_impresora` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_registro`
--

DROP TABLE IF EXISTS `t_registro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_registro` (
  `id_registro` int NOT NULL AUTO_INCREMENT,
  `cedula` varchar(10) NOT NULL,
  `apellidos` varchar(25) NOT NULL,
  `nombres` varchar(25) NOT NULL,
  `id_impresora` int NOT NULL,
  `id_tipoImp` int NOT NULL,
  `numero_hojas` int NOT NULL,
  `timestamp` varchar(10) NOT NULL,
  `descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_registro`),
  KEY `fk_registro_impresora_idx` (`id_impresora`),
  KEY `fk_registro_tipo_impresion_idx` (`id_tipoImp`),
  CONSTRAINT `fk_registro_impresora` FOREIGN KEY (`id_impresora`) REFERENCES `t_impresora` (`id_impresora`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_registro_tipo_impresion` FOREIGN KEY (`id_tipoImp`) REFERENCES `c_tipo_impresion` (`id_tipoImp`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_registro`
--

LOCK TABLES `t_registro` WRITE;
/*!40000 ALTER TABLE `t_registro` DISABLE KEYS */;
INSERT INTO `t_registro` VALUES (2,'1002364527','muñoz ','PAULA',2,2,300,'2022-10-07','prueba4');
/*!40000 ALTER TABLE `t_registro` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-13  1:13:36
