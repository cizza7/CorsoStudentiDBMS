-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: corsostudente
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `aula`
--

DROP TABLE IF EXISTS `aula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aula` (
  `idAula` int NOT NULL AUTO_INCREMENT,
  `nComputer` int DEFAULT NULL,
  `FK_scuola` int DEFAULT NULL,
  PRIMARY KEY (`idAula`),
  KEY `FK_scuola` (`FK_scuola`),
  CONSTRAINT `aula_ibfk_1` FOREIGN KEY (`FK_scuola`) REFERENCES `scuola` (`idScuola`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aula`
--

LOCK TABLES `aula` WRITE;
/*!40000 ALTER TABLE `aula` DISABLE KEYS */;
INSERT INTO `aula` VALUES (1,2,1),(2,2,4),(3,3,2),(4,4,3);
/*!40000 ALTER TABLE `aula` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `corso`
--

DROP TABLE IF EXISTS `corso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `corso` (
  `idCorso` int NOT NULL AUTO_INCREMENT,
  `inizio` time(5) DEFAULT NULL,
  `fine` time(5) DEFAULT NULL,
  `FK_docente` int DEFAULT NULL,
  `FK_societa` int DEFAULT NULL,
  `FK_aula` int DEFAULT NULL,
  PRIMARY KEY (`idCorso`),
  KEY `FK_docente` (`FK_docente`),
  KEY `FK_societa` (`FK_societa`),
  CONSTRAINT `corso_ibfk_1` FOREIGN KEY (`FK_docente`) REFERENCES `docente` (`idDocente`),
  CONSTRAINT `corso_ibfk_2` FOREIGN KEY (`FK_societa`) REFERENCES `societa` (`idSocieta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `corso`
--

LOCK TABLES `corso` WRITE;
/*!40000 ALTER TABLE `corso` DISABLE KEYS */;
INSERT INTO `corso` VALUES (1,'15:00:00.00000','16:00:00.00000',1,1,2),(2,'11:00:00.00000','13:00:00.00000',2,2,3),(3,'11:00:00.00000','13:00:00.00000',3,3,1),(4,'19:00:00.00000','20:00:00.00000',4,4,4);
/*!40000 ALTER TABLE `corso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `docente`
--

DROP TABLE IF EXISTS `docente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `docente` (
  `idDocente` int NOT NULL AUTO_INCREMENT,
  `FK_societa` int DEFAULT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `cognome` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idDocente`),
  KEY `FK_societa` (`FK_societa`),
  CONSTRAINT `docente_ibfk_1` FOREIGN KEY (`FK_societa`) REFERENCES `societa` (`idSocieta`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `docente`
--

LOCK TABLES `docente` WRITE;
/*!40000 ALTER TABLE `docente` DISABLE KEYS */;
INSERT INTO `docente` VALUES (1,NULL,'Paolo','Esposito'),(2,NULL,'Gianni','Esposito'),(3,NULL,'Mario','Rossi'),(4,NULL,'Carlo','Marrone');
/*!40000 ALTER TABLE `docente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `materia`
--

DROP TABLE IF EXISTS `materia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `materia` (
  `idMateria` int NOT NULL AUTO_INCREMENT,
  `FK_corso` int DEFAULT NULL,
  PRIMARY KEY (`idMateria`),
  KEY `FK_corso` (`FK_corso`),
  CONSTRAINT `materia_ibfk_1` FOREIGN KEY (`FK_corso`) REFERENCES `corso` (`idCorso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `materia`
--

LOCK TABLES `materia` WRITE;
/*!40000 ALTER TABLE `materia` DISABLE KEYS */;
INSERT INTO `materia` VALUES (1,1),(2,2),(3,3),(4,4);
/*!40000 ALTER TABLE `materia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scuola`
--

DROP TABLE IF EXISTS `scuola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `scuola` (
  `idScuola` int NOT NULL AUTO_INCREMENT,
  `nomeScuola` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idScuola`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scuola`
--

LOCK TABLES `scuola` WRITE;
/*!40000 ALTER TABLE `scuola` DISABLE KEYS */;
INSERT INTO `scuola` VALUES (1,'Scuola Uno'),(2,'Scuola Due'),(3,'Scuola Tre'),(4,'Scuola Quattro');
/*!40000 ALTER TABLE `scuola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sede`
--

DROP TABLE IF EXISTS `sede`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sede` (
  `idSede` int NOT NULL AUTO_INCREMENT,
  `nomeSede` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idSede`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sede`
--

LOCK TABLES `sede` WRITE;
/*!40000 ALTER TABLE `sede` DISABLE KEYS */;
INSERT INTO `sede` VALUES (1,'Sede 1'),(2,'Sede 2'),(3,'Sede 3'),(4,'Sede 4');
/*!40000 ALTER TABLE `sede` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `societa`
--

DROP TABLE IF EXISTS `societa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `societa` (
  `idSocieta` int NOT NULL AUTO_INCREMENT,
  `FK_sede` int DEFAULT NULL,
  `nomeSocieta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idSocieta`),
  KEY `FK_sede` (`FK_sede`),
  CONSTRAINT `societa_ibfk_1` FOREIGN KEY (`FK_sede`) REFERENCES `sede` (`idSede`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `societa`
--

LOCK TABLES `societa` WRITE;
/*!40000 ALTER TABLE `societa` DISABLE KEYS */;
INSERT INTO `societa` VALUES (1,1,'societa 1'),(2,2,'societa 2'),(3,3,'societa 3'),(4,4,'societa 4');
/*!40000 ALTER TABLE `societa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studente`
--

DROP TABLE IF EXISTS `studente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studente` (
  `idStudente` int NOT NULL AUTO_INCREMENT,
  `FK_corso` int DEFAULT NULL,
  `nomeStudente` varchar(20) DEFAULT NULL,
  `cognomeStudente` varchar(20) DEFAULT NULL,
  `annoDiNascita` int DEFAULT NULL,
  PRIMARY KEY (`idStudente`),
  KEY `FK_corso` (`FK_corso`),
  CONSTRAINT `studente_ibfk_1` FOREIGN KEY (`FK_corso`) REFERENCES `corso` (`idCorso`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studente`
--

LOCK TABLES `studente` WRITE;
/*!40000 ALTER TABLE `studente` DISABLE KEYS */;
INSERT INTO `studente` VALUES (1,1,'Mario','Giallo',1990),(2,2,'Carlo','Rossi',1998),(3,3,'Simone','Andrei',2010),(4,4,'Gianni','Paolini',2002);
/*!40000 ALTER TABLE `studente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-11 22:49:47
