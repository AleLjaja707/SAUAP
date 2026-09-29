CREATE DATABASE  IF NOT EXISTS `mydb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `mydb`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	9.4.0

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
-- Table structure for table `asignacion`
--

DROP TABLE IF EXISTS `asignacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asignacion` (
  `idAsignacion` int NOT NULL AUTO_INCREMENT,
  `idProfesor` int NOT NULL,
  `idUnidadAprendizaje` int NOT NULL,
  `diaSemana` varchar(50) NOT NULL,
  `horaInicio` time DEFAULT NULL,
  `horaFin` time DEFAULT NULL,
  PRIMARY KEY (`idAsignacion`),
  KEY `idProfesor_idx` (`idProfesor`),
  KEY `idUnidadAprendizaje_idx` (`idUnidadAprendizaje`),
  CONSTRAINT `idProfesor` FOREIGN KEY (`idProfesor`) REFERENCES `profesor` (`idProfesor`),
  CONSTRAINT `idUnidadAprendizaje` FOREIGN KEY (`idUnidadAprendizaje`) REFERENCES `unidad_aprendizaje` (`idUnidad_Aprendizaje`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asignacion`
--

LOCK TABLES `asignacion` WRITE;
/*!40000 ALTER TABLE `asignacion` DISABLE KEYS */;
INSERT INTO `asignacion` VALUES (1,1,2,'Martes','09:00:00','11:00:00'),(2,1,2,'Miercoles','14:00:00','15:00:00'),(3,3,4,'Viernes','13:00:00','15:00:00'),(4,2,3,'Lunes','13:00:00','14:00:00'),(5,2,1,'Jueves','10:00:00','11:00:00'),(6,2,2,'Miercoles','16:50:00','17:50:00'),(7,2,4,'Miercoles','17:51:00','18:51:00'),(8,4,2,'Miercoles','15:00:00','16:00:00'),(9,4,3,'Miercoles','16:19:00','17:18:00');
/*!40000 ALTER TABLE `asignacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `idProfesor` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `apellidoM` varchar(50) NOT NULL,
  `apellidoP` varchar(50) NOT NULL,
  `rfc` varchar(13) NOT NULL,
  PRIMARY KEY (`idProfesor`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
INSERT INTO `profesor` VALUES (1,'Lisseth','Lopez','LaMadrid','LALL701208XX1'),(2,'Luis Armando','Lugo','Jara','JALL800904XL2'),(3,'José Alfredo','Padilla','Abad','ABPJ700815LM2'),(4,'Alessandra','Arozamena','Leon','LLAA120912XX8'),(5,'Alejandro','Lopez','Rojas','ALLS120518HH1');
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `unidad_aprendizaje`
--

DROP TABLE IF EXISTS `unidad_aprendizaje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `unidad_aprendizaje` (
  `idUnidad_Aprendizaje` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL,
  `horasClase` int NOT NULL,
  `horasTaller` int NOT NULL,
  `horasLaboratorio` int NOT NULL,
  PRIMARY KEY (`idUnidad_Aprendizaje`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `unidad_aprendizaje`
--

LOCK TABLES `unidad_aprendizaje` WRITE;
/*!40000 ALTER TABLE `unidad_aprendizaje` DISABLE KEYS */;
INSERT INTO `unidad_aprendizaje` VALUES (1,'POO 2',4,2,2),(2,'Base de datos',4,4,2),(3,'Desarrollo de Software',4,4,2),(4,'Algoritmos y Estructuras de Datos',3,2,2);
/*!40000 ALTER TABLE `unidad_aprendizaje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuarios` int NOT NULL,
  `correo` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`idUsuarios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (111,'ale','123');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-29  7:35:24
