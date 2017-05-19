CREATE DATABASE  IF NOT EXISTS `ordermeal` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ordermeal`;
-- MySQL dump 10.13  Distrib 5.7.17, for Linux (x86_64)
--
-- Host: localhost    Database: ordermeal
-- ------------------------------------------------------
-- Server version	5.7.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bebestible`
--

DROP TABLE IF EXISTS `bebestible`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bebestible` (
  `id_bebestible` int(11) NOT NULL,
  `beb_nombre` varchar(25) NOT NULL,
  `beb_precio` double NOT NULL,
  PRIMARY KEY (`id_bebestible`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebestible`
--

LOCK TABLES `bebestible` WRITE;
/*!40000 ALTER TABLE `bebestible` DISABLE KEYS */;
INSERT INTO `bebestible` VALUES (1,'Jugo de Naranja',1000),(2,'Jugo de Pina',1000),(3,'Soda',1200);
/*!40000 ALTER TABLE `bebestible` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `cli_nombre` varchar(25) NOT NULL,
  PRIMARY KEY (`id_cliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'Richard'),(2,'Isaias'),(3,'Lucho');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `edificio`
--

DROP TABLE IF EXISTS `edificio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `edificio` (
  `id_edificio` int(11) NOT NULL,
  `edi_direccion` varchar(45) NOT NULL,
  `edi_nombre` varchar(25) NOT NULL,
  PRIMARY KEY (`id_edificio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `edificio`
--

LOCK TABLES `edificio` WRITE;
/*!40000 ALTER TABLE `edificio` DISABLE KEYS */;
INSERT INTO `edificio` VALUES (1,'Calle Falsa 123','Edificio A'),(2,'Evergreen Av. 555','Edificio B'),(3,'Jerusalen 777','Edificio C');
/*!40000 ALTER TABLE `edificio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ensalada`
--

DROP TABLE IF EXISTS `ensalada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ensalada` (
  `id_ensalada` int(11) NOT NULL,
  `ens_nombre` varchar(25) NOT NULL,
  `ens_precio` double NOT NULL,
  PRIMARY KEY (`id_ensalada`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ensalada`
--

LOCK TABLES `ensalada` WRITE;
/*!40000 ALTER TABLE `ensalada` DISABLE KEYS */;
INSERT INTO `ensalada` VALUES (1,'Ens. Palta Lechuga',1500),(2,'Ens. Pepino',900),(3,'Ens. Palmitos',1200);
/*!40000 ALTER TABLE `ensalada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `id_order` int(11) NOT NULL,
  `ord_total_pago` double NOT NULL,
  `plato_id_plato` int(11) NOT NULL,
  `tipo_pago_id_tipo_pago` int(11) NOT NULL,
  `usuario_id_usuario` int(11) NOT NULL,
  `cliente_id_cliente` int(11) NOT NULL,
  `edificio_id_edificio` int(11) NOT NULL,
  `postre_id_postre` int(11) NOT NULL,
  `bebestible_id_bebestible` int(11) NOT NULL,
  `ensalada_id_ensalada` int(11) NOT NULL,
  `ord_fecha_retiro` date DEFAULT NULL,
  `ord_fecha_emision` date DEFAULT NULL,
  PRIMARY KEY (`id_order`,`plato_id_plato`,`tipo_pago_id_tipo_pago`,`usuario_id_usuario`,`cliente_id_cliente`,`edificio_id_edificio`,`postre_id_postre`,`bebestible_id_bebestible`,`ensalada_id_ensalada`),
  KEY `fk_order_plato_idx` (`plato_id_plato`),
  KEY `fk_order_tipo_pago1_idx` (`tipo_pago_id_tipo_pago`),
  KEY `fk_order_usuario1_idx` (`usuario_id_usuario`),
  KEY `fk_order_cliente1_idx` (`cliente_id_cliente`),
  KEY `fk_order_edificio1_idx` (`edificio_id_edificio`),
  KEY `fk_order_postre1_idx` (`postre_id_postre`),
  KEY `fk_order_bebestible1_idx` (`bebestible_id_bebestible`),
  KEY `fk_order_ensalada1_idx` (`ensalada_id_ensalada`),
  CONSTRAINT `fk_order_bebestible1` FOREIGN KEY (`bebestible_id_bebestible`) REFERENCES `bebestible` (`id_bebestible`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_cliente1` FOREIGN KEY (`cliente_id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_edificio1` FOREIGN KEY (`edificio_id_edificio`) REFERENCES `edificio` (`id_edificio`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_ensalada1` FOREIGN KEY (`ensalada_id_ensalada`) REFERENCES `ensalada` (`id_ensalada`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_plato` FOREIGN KEY (`plato_id_plato`) REFERENCES `plato` (`id_plato`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_postre1` FOREIGN KEY (`postre_id_postre`) REFERENCES `postre` (`id_postre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_tipo_pago1` FOREIGN KEY (`tipo_pago_id_tipo_pago`) REFERENCES `tipo_pago` (`id_tipo_pago`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_order_usuario1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,4750,1,1,1,1,1,3,2,3,'2017-05-17','2017-05-18');
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plato` (
  `id_plato` int(11) NOT NULL,
  `pla_nombre` varchar(25) NOT NULL,
  `pla_precio` double NOT NULL,
  `pla_detalles` varchar(45) DEFAULT NULL,
  `pla_especial` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id_plato`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
INSERT INTO `plato` VALUES (1,'Lasagna',2000,'Laminas de pasta horneadas con queso y carne',1),(2,'Salchipapas',1600,NULL,0),(3,'Arroz con Pollo Asado',1600,NULL,0);
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postre`
--

DROP TABLE IF EXISTS `postre`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `postre` (
  `id_postre` int(11) NOT NULL,
  `pos_nombre` varchar(25) NOT NULL,
  `pos_precio` double NOT NULL,
  PRIMARY KEY (`id_postre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postre`
--

LOCK TABLES `postre` WRITE;
/*!40000 ALTER TABLE `postre` DISABLE KEYS */;
INSERT INTO `postre` VALUES (1,'Flan de vainilla',400),(2,'Arroz con Leche',400),(3,'Tuti-Fruti',550);
/*!40000 ALTER TABLE `postre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_pago`
--

DROP TABLE IF EXISTS `tipo_pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_pago` (
  `id_tipo_pago` int(11) NOT NULL,
  `t_p_nombre` varchar(15) NOT NULL,
  PRIMARY KEY (`id_tipo_pago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_pago`
--

LOCK TABLES `tipo_pago` WRITE;
/*!40000 ALTER TABLE `tipo_pago` DISABLE KEYS */;
INSERT INTO `tipo_pago` VALUES (1,'Efectivo'),(2,'Debito'),(3,'Desc. a Remun.');
/*!40000 ALTER TABLE `tipo_pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `usu_nombre` varchar(15) NOT NULL,
  `usu_pass` varchar(15) NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'oscarg','pass'),(2,'cristianf','pass');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ordermeal'
--

--
-- Dumping routines for database 'ordermeal'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-18 21:24:41
