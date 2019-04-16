-- MySQL dump 10.13  Distrib 5.6.41, for Win64 (x86_64)
--
-- Host: localhost    Database: train
-- ------------------------------------------------------
-- Server version	5.6.41-log

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
-- Table structure for table `available_seats`
--

DROP TABLE IF EXISTS `available_seats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `available_seats` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avail_seat` varchar(255) DEFAULT NULL,
  `sold_seats` varchar(255) DEFAULT NULL,
  `total_seats` varchar(255) DEFAULT NULL,
  `compartment_id` bigint(20) NOT NULL,
  `train_id` bigint(20) NOT NULL,
  `available_date` datetime DEFAULT NULL,
  `seat_details_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5722lme4quv56ji5pgcn91sd` (`seat_details_id`),
  KEY `FKcoajod8enrds7iyobskk12okw` (`compartment_id`),
  KEY `FKthx2gowa64opffhtayg6mbjgq` (`train_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `available_seats`
--

LOCK TABLES `available_seats` WRITE;
/*!40000 ALTER TABLE `available_seats` DISABLE KEYS */;
INSERT INTO `available_seats` VALUES (1,'12','12','39',2,10,NULL,0);
/*!40000 ALTER TABLE `available_seats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `available_train_schedule`
--

DROP TABLE IF EXISTS `available_train_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `available_train_schedule` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available_date` date DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `train_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ltlc6efvinaj69405ohw0ov4` (`train_id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `available_train_schedule`
--

LOCK TABLES `available_train_schedule` WRITE;
/*!40000 ALTER TABLE `available_train_schedule` DISABLE KEYS */;
INSERT INTO `available_train_schedule` VALUES (1,'2019-04-17','',10),(2,'2019-04-21','',10),(3,'2019-04-19','',10),(4,'2019-04-19','',10),(5,'2019-04-19','',10),(6,'2019-04-19','',10),(7,'2019-04-18','',10);
/*!40000 ALTER TABLE `available_train_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `availabletrainschedule_seatdetails`
--

DROP TABLE IF EXISTS `availabletrainschedule_seatdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `availabletrainschedule_seatdetails` (
  `av_trainsche_id` bigint(20) NOT NULL,
  `seatdetails_id` bigint(20) NOT NULL,
  KEY `FKcknx4mbt2qeb9abk9xxhu1l1i` (`seatdetails_id`),
  KEY `FKnb1g0qvqw3qu6xtdeagm7m8o5` (`av_trainsche_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availabletrainschedule_seatdetails`
--

LOCK TABLES `availabletrainschedule_seatdetails` WRITE;
/*!40000 ALTER TABLE `availabletrainschedule_seatdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `availabletrainschedule_seatdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compartment`
--

DROP TABLE IF EXISTS `compartment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compartment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `compartment_name` varchar(255) DEFAULT NULL,
  `compartment_no` int(11) NOT NULL,
  `train_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK83wuysdxfl2i7urv0netmtca9` (`train_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compartment`
--

LOCK TABLES `compartment` WRITE;
/*!40000 ALTER TABLE `compartment` DISABLE KEYS */;
INSERT INTO `compartment` VALUES (2,'Dual',809,10),(3,'Ritta ',808,2),(4,'Filep',807,8),(5,'Cina',806,8),(6,'Gazi',805,10),(7,'Sigda',803,10),(8,'Jibon',811,6),(10,'Queen',813,9);
/*!40000 ALTER TABLE `compartment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fare`
--

DROP TABLE IF EXISTS `fare`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fare` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `fare_categore_no` varchar(255) DEFAULT NULL,
  `fare_categore_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fare`
--

LOCK TABLES `fare` WRITE;
/*!40000 ALTER TABLE `fare` DISABLE KEYS */;
INSERT INTO `fare` VALUES (1,'1098','1st_class'),(2,'1092','2nd_class'),(3,'1076','3nd_class'),(4,'1067','4th_class');
/*!40000 ALTER TABLE `fare` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `purchase`
--

DROP TABLE IF EXISTS `purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `purchase` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `purchasedate` datetime DEFAULT NULL,
  `qty` int(11) NOT NULL,
  `total_price` double NOT NULL,
  `unit_price` double NOT NULL,
  `ticket_id` bigint(20) NOT NULL,
  `pasenger_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdoji9hyoblfmsrsn58fnnw5oh` (`pasenger_id`),
  KEY `FKg8fasilc91n6t0u60d3bhofn9` (`ticket_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase`
--

LOCK TABLES `purchase` WRITE;
/*!40000 ALTER TABLE `purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation`
--

DROP TABLE IF EXISTS `reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `journy_date` datetime DEFAULT NULL,
  `no_off_seats` varchar(255) DEFAULT NULL,
  `total_price` double NOT NULL,
  `unit_price` double NOT NULL,
  `compartment_id` bigint(20) DEFAULT NULL,
  `ticket_id` bigint(20) DEFAULT NULL,
  `train_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `pasenger_id` bigint(20) NOT NULL,
  `available_train_schedule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKm4oimk0l1757o9pwavorj6ljg` (`user_id`),
  KEY `FKk91l6w953ahgljuts9kiiwr21` (`available_train_schedule_id`),
  KEY `FK6k2qh1d7lkj1ennnwdhqauh43` (`compartment_id`),
  KEY `FKsk0pga3dyidbhwrw7s250jev6` (`pasenger_id`),
  KEY `FKkn72g30lgqj1a31doyr5qb6ln` (`ticket_id`),
  KEY `FK1dapn2n2425sb2gvys7me8g9w` (`train_id`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation`
--

LOCK TABLES `reservation` WRITE;
/*!40000 ALTER TABLE `reservation` DISABLE KEYS */;
INSERT INTO `reservation` VALUES (1,'2019-03-29 00:00:00','1',800,800,5,NULL,3,3,0,0);
/*!40000 ALTER TABLE `reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservation_seatdetails`
--

DROP TABLE IF EXISTS `reservation_seatdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservation_seatdetails` (
  `reservation_id` bigint(20) NOT NULL,
  `seatdetails_id` bigint(20) NOT NULL,
  KEY `FK590epbva7xrbli35wccbxl900` (`seatdetails_id`),
  KEY `FKey22s936ockawu9e630xf9rh1` (`reservation_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservation_seatdetails`
--

LOCK TABLES `reservation_seatdetails` WRITE;
/*!40000 ALTER TABLE `reservation_seatdetails` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservation_seatdetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'SUPERADMIN'),(3,'ADMIN'),(6,'USER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `route`
--

DROP TABLE IF EXISTS `route`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `route` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `route_name` varchar(255) DEFAULT NULL,
  `station_from` varchar(255) DEFAULT NULL,
  `station_to` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `route`
--

LOCK TABLES `route` WRITE;
/*!40000 ALTER TABLE `route` DISABLE KEYS */;
INSERT INTO `route` VALUES (1,'Khulna to Kumila Route','Khulna','Kumila'),(2,'Rongpur to Dhaka Route','Rongpur','Dhaka'),(3,'Dhaka to Khulna Route','Dhaka','Khulna'),(4,'Chittagong To Dhaka','Chittagong','Dhaka'),(5,'Dhaka To Chittagong','Dhaka','Chittagong'),(6,'Dhaka To Shylet','Dhaka','Shylet'),(7,'Dhaka To Nilfamari','Dha','Nilfamari'),(8,'Dhaka To Dinazpur','Dhaka','Dinazpur'),(9,'Shylet To Dhaka','Shylet','Dhaka'),(10,'Dinazpur To Dhaka','Dinazpur ','Dhaka'),(11,'Khulna To Dhaka','Khulna','Dhaka'),(12,'Nilfamari To Dhaka','Nilfamari','Dhaka');
/*!40000 ALTER TABLE `route` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sales`
--

DROP TABLE IF EXISTS `sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sales` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `qty` int(11) NOT NULL,
  `salse_date` datetime DEFAULT NULL,
  `total_price` double NOT NULL,
  `unit_price` double NOT NULL,
  `ticket_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo9u32i1vmg7gicfmiw21j5rfs` (`ticket_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sales`
--

LOCK TABLES `sales` WRITE;
/*!40000 ALTER TABLE `sales` DISABLE KEYS */;
/*!40000 ALTER TABLE `sales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat`
--

DROP TABLE IF EXISTS `seat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cabin_no` int(11) NOT NULL,
  `seat_no` int(11) NOT NULL,
  `compartment_id` bigint(20) DEFAULT NULL,
  `train_class_id` bigint(20) DEFAULT NULL,
  `train_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9xnwellv84xw3acxe2snk14rr` (`compartment_id`),
  KEY `FKf06vp4yt7gfurnva97y7hlqa3` (`train_id`),
  KEY `FK8fqu3gdh738evxpyi1n0mh4cc` (`train_class_id`)
) ENGINE=MyISAM AUTO_INCREMENT=176 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat`
--

LOCK TABLES `seat` WRITE;
/*!40000 ALTER TABLE `seat` DISABLE KEYS */;
INSERT INTO `seat` VALUES (1,0,1201,2,7,10),(2,0,1202,2,7,10),(3,0,1203,2,7,10),(4,0,1204,2,7,10),(5,0,1205,5,7,10),(6,0,1206,2,7,10),(7,0,1207,2,7,10),(8,0,1208,2,7,10),(9,0,1209,2,7,10),(10,0,1210,2,7,10),(11,0,1211,2,7,10),(12,0,1212,2,7,10),(13,0,1213,2,7,10),(14,0,1214,2,7,10),(15,0,1215,2,7,10),(16,0,1216,2,7,10),(17,0,1217,2,7,10),(18,0,1218,2,7,10),(19,0,1219,2,7,10),(20,0,1220,2,7,10),(21,0,1221,2,7,10),(22,0,1222,2,7,10),(23,0,1223,2,7,10),(24,0,1224,2,7,10),(25,0,1225,2,7,10),(26,0,1226,2,7,10),(27,0,1227,2,7,10),(28,0,1228,2,7,10),(29,0,1229,2,7,10),(30,0,1230,2,7,10),(31,0,1231,2,7,10),(32,0,1232,2,7,10),(33,0,1233,2,7,10),(34,0,1234,2,7,10),(35,0,1235,2,7,10),(36,0,1236,6,3,10),(37,0,1237,6,3,10),(38,0,1238,6,3,10),(39,0,1239,6,3,10),(40,0,1240,6,3,10),(41,0,1241,6,3,10),(42,0,1242,6,3,10),(43,0,1243,6,3,10),(44,0,1244,6,3,10),(45,0,1245,6,3,10),(46,0,1246,6,3,10),(47,0,1247,6,3,10),(48,0,1248,6,3,10),(49,0,1249,6,3,10),(50,0,1250,6,3,10),(51,0,1251,6,3,10),(52,0,1252,6,3,10),(53,0,1253,6,3,10),(54,0,1254,6,3,10),(55,0,1255,6,3,10),(56,0,1256,6,3,10),(57,0,1257,6,3,10),(58,0,1258,6,3,10),(59,0,1259,6,3,10),(60,0,1260,6,3,10),(61,0,1261,6,3,10),(62,0,1262,6,3,10),(63,0,1263,6,3,10),(64,0,1264,6,3,10),(65,0,1265,6,3,10),(66,0,1266,6,3,10),(67,0,1267,6,3,10),(68,0,1268,6,3,10),(69,0,1269,6,3,10),(70,0,1270,6,3,10),(71,0,1271,7,9,10),(72,0,1272,7,9,10),(73,0,1273,7,9,10),(74,0,1274,7,9,10),(75,0,1275,7,9,10),(76,0,1276,7,9,10),(77,0,1277,7,9,10),(78,0,1278,7,9,10),(79,0,1279,7,9,10),(80,0,1280,7,9,10),(81,0,1281,7,9,10),(82,0,1282,7,9,10),(83,0,1283,7,9,10),(84,0,1284,7,9,10),(85,0,1285,7,9,10),(86,0,1286,7,9,10),(87,0,1287,7,9,10),(88,0,1288,7,9,10),(89,0,1289,7,9,10),(90,0,1290,7,9,10),(91,0,1291,7,9,10),(92,0,1292,7,9,10),(93,0,1293,7,9,10),(94,0,1294,7,9,10),(95,0,1295,7,9,10),(96,0,1296,7,9,10),(97,0,1297,7,9,10),(98,0,1298,7,9,10),(99,0,1299,7,9,10),(100,0,1300,7,9,10),(101,0,1301,7,9,10),(102,0,1302,7,9,10),(103,0,1303,7,9,10),(104,0,1304,7,9,10),(105,0,1305,7,9,10),(106,0,1401,5,6,8),(107,0,1402,5,6,8),(108,0,1403,5,6,8),(109,0,1404,5,6,8),(110,0,1405,5,6,8),(111,0,1406,5,6,8),(112,0,1407,5,6,8),(113,0,1408,5,6,8),(114,0,1409,5,6,8),(115,0,1410,5,6,8),(116,0,1411,5,6,8),(117,0,1412,5,6,8),(118,0,1413,5,6,8),(119,0,1414,5,6,8),(120,0,1415,5,6,8),(121,0,1416,5,6,8),(122,0,1417,5,6,8),(123,0,1418,5,6,8),(124,0,1419,5,6,8),(125,0,1420,5,6,8),(126,0,1421,5,6,8),(127,0,1422,5,6,8),(128,0,1423,5,6,8),(129,0,1424,5,6,8),(130,0,1425,5,6,8),(131,0,1426,5,6,8),(132,0,1427,5,6,8),(133,0,1428,5,6,8),(134,0,1429,5,6,8),(135,0,1430,5,6,8),(136,0,1431,5,6,8),(137,0,1432,5,6,8),(138,0,1433,5,6,8),(139,0,1434,5,6,8),(140,0,1435,5,6,8),(141,0,1436,4,11,8),(142,0,1437,4,11,8),(143,0,1438,4,11,8),(144,0,1439,4,11,8),(145,0,1440,4,11,8),(146,0,1441,4,11,8),(147,0,1442,4,11,8),(148,0,1443,4,11,8),(149,0,1444,4,11,8),(150,0,1445,4,11,8),(151,0,1446,4,11,8),(152,0,1447,4,11,8),(153,0,1448,4,11,8),(154,0,1449,4,11,8),(155,0,1450,4,11,8),(156,0,1451,4,11,8),(157,0,1452,4,11,8),(158,0,1453,4,11,8),(159,0,1454,4,11,8),(160,0,1455,4,11,8),(161,0,1456,4,11,8),(162,0,1457,4,11,8),(163,0,1458,4,11,8),(164,0,1459,4,11,8),(165,0,1460,4,11,8),(166,0,1461,4,11,8),(167,0,1462,4,11,8),(168,0,1463,4,11,8),(169,0,1464,4,11,8),(170,0,1465,4,11,8),(171,0,1466,4,11,8),(172,0,1467,4,11,8),(173,0,1468,4,11,8),(174,0,1469,4,11,8),(175,0,1470,4,11,8);
/*!40000 ALTER TABLE `seat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seat_available_details`
--

DROP TABLE IF EXISTS `seat_available_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seat_available_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `journy_date` datetime DEFAULT NULL,
  `status` bit(1) DEFAULT NULL,
  `compartment_id` bigint(20) NOT NULL,
  `seat_or_cabin_id` bigint(20) NOT NULL,
  `train_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbqa6vots4oqr2torj5dlidy1t` (`compartment_id`),
  KEY `FKnixtpftgn1py8vvf3b4ggxej7` (`seat_or_cabin_id`),
  KEY `FK6g1650d42wylemmdxpog28spb` (`train_id`)
) ENGINE=MyISAM AUTO_INCREMENT=82 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seat_available_details`
--

LOCK TABLES `seat_available_details` WRITE;
/*!40000 ALTER TABLE `seat_available_details` DISABLE KEYS */;
INSERT INTO `seat_available_details` VALUES (7,'2019-04-18 00:00:00','\0',2,1,10),(8,'2019-04-18 00:00:00','',2,2,10),(9,'2019-04-18 00:00:00','',2,3,10),(10,'2019-04-18 00:00:00','',2,5,10),(11,'2019-04-18 00:00:00','',2,7,10),(12,'2019-04-18 00:00:00','',2,6,10),(13,'2019-04-18 00:00:00','',2,7,10),(14,'2019-04-18 00:00:00','',2,8,10),(15,'2019-04-18 00:00:00','',2,9,10),(16,'2019-04-18 00:00:00','\0',2,10,10),(17,'2019-04-18 00:00:00','',2,11,10),(18,'2019-04-18 00:00:00','',2,12,10),(19,'2019-04-18 00:00:00','',2,13,10),(20,'2019-04-18 00:00:00','',2,14,10),(21,'2019-04-18 00:00:00','',2,15,10),(22,'2019-04-18 00:00:00','',2,16,10),(23,'2019-04-18 00:00:00','',2,17,10),(24,'2019-04-18 00:00:00','',2,18,10),(25,'2019-04-18 00:00:00','',2,19,10),(26,'2019-04-18 00:00:00','',2,20,10),(27,'2019-04-18 00:00:00','',2,21,10),(28,'2019-04-18 00:00:00','',2,22,10),(29,'2019-04-18 00:00:00','',2,23,10),(30,'2019-04-18 00:00:00','',2,24,10),(31,'2019-04-18 00:00:00','',2,25,10),(32,'2019-04-18 00:00:00','',2,26,10),(33,'2019-04-18 00:00:00','',2,27,10),(34,'2019-04-18 00:00:00','',2,28,10),(35,'2019-04-18 00:00:00','',2,29,10),(36,'2019-04-18 00:00:00','',2,30,10),(37,'2019-04-18 00:00:00','',2,31,10),(38,'2019-04-18 00:00:00','',2,32,10),(39,'2019-04-18 00:00:00','',2,33,10),(40,'2019-04-18 00:00:00','',2,34,10),(41,'2019-04-18 00:00:00','',2,35,10),(42,'2019-04-18 00:00:00','',6,36,10),(43,'2019-04-18 00:00:00','',6,37,10),(44,'2019-04-18 00:00:00','',6,38,10),(45,'2019-04-18 00:00:00','',6,39,10),(46,'2019-04-18 00:00:00','',6,40,10),(47,'2019-04-18 00:00:00','',6,41,10),(48,'2019-04-18 00:00:00','',6,42,10),(49,'2019-04-18 00:00:00','',6,43,10),(50,'2019-04-18 00:00:00','',6,44,10),(51,'2019-04-18 00:00:00','',6,45,10),(52,'2019-04-18 00:00:00','',6,46,10),(53,'2019-04-18 00:00:00','',6,47,10),(54,'2019-04-18 00:00:00','',6,48,10),(55,'2019-04-18 00:00:00','',6,49,10),(56,'2019-04-18 00:00:00','\0',6,50,10),(57,'2019-04-18 00:00:00','\0',6,51,10),(58,'2019-04-18 00:00:00','',6,52,10),(59,'2019-04-18 00:00:00','',6,53,10),(60,'2019-04-18 00:00:00','',6,54,10),(61,'2019-04-18 00:00:00','',6,55,10),(62,'2019-04-18 00:00:00','',6,56,10),(63,'2019-04-18 00:00:00','',6,57,10),(64,'2019-04-18 00:00:00','',6,58,10),(65,'2019-04-18 00:00:00','',6,59,10),(66,'2019-04-18 00:00:00','',6,60,10),(67,'2019-04-18 00:00:00','',6,61,10),(68,'2019-04-18 00:00:00','',6,62,10),(69,'2019-04-18 00:00:00','',6,63,10),(70,'2019-04-18 00:00:00','',6,64,10),(71,'2019-04-18 00:00:00','',6,65,10),(72,'2019-04-18 00:00:00','',6,66,10),(73,'2019-04-18 00:00:00','',6,67,10),(74,'2019-04-18 00:00:00','',6,68,10),(75,'2019-04-18 00:00:00','',6,69,10),(76,'2019-04-18 00:00:00','\0',6,70,10),(77,'2019-04-18 00:00:00','',6,71,10),(78,'2019-04-18 00:00:00','',6,72,10),(79,'2019-04-18 00:00:00','',6,73,10),(80,'2019-04-18 00:00:00','',6,74,10),(81,'2019-04-18 00:00:00','',6,75,10);
/*!40000 ALTER TABLE `seat_available_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seats_details`
--

DROP TABLE IF EXISTS `seats_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `seats_details` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `status` bit(1) DEFAULT NULL,
  `compartment_id` bigint(20) NOT NULL,
  `seat_or_cabin_id` bigint(20) NOT NULL,
  `train_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKqcmgm6xmlrt6f686g5lr4wo0w` (`compartment_id`),
  KEY `FKoxro6uckpcdpdj9p4r6tma6iu` (`seat_or_cabin_id`),
  KEY `FKqmlnnel2yqp73venuqst7nvi3` (`train_id`)
) ENGINE=MyISAM AUTO_INCREMENT=76 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seats_details`
--

LOCK TABLES `seats_details` WRITE;
/*!40000 ALTER TABLE `seats_details` DISABLE KEYS */;
INSERT INTO `seats_details` VALUES (1,'',2,1,10),(2,'',2,2,10),(3,'',2,3,10),(4,'',2,5,10),(5,'',2,7,10),(6,'',2,6,10),(7,'',2,7,10),(8,'',2,8,10),(9,'',2,9,10),(10,'',2,10,10),(11,'',2,11,10),(12,'',2,12,10),(13,'',2,13,10),(14,'',2,14,10),(15,'',2,15,10),(16,'',2,16,10),(17,'',2,17,10),(18,'',2,18,10),(19,'',2,19,10),(20,'',2,20,10),(21,'',2,21,10),(22,'',2,22,10),(23,'',2,23,10),(24,'',2,24,10),(25,'',2,25,10),(26,'',2,26,10),(27,'',2,27,10),(28,'',2,28,10),(29,'',2,29,10),(30,'',2,30,10),(31,'',2,31,10),(32,'',2,32,10),(33,'',2,33,10),(34,'',2,34,10),(35,'',2,35,10),(36,'',6,36,10),(37,'',6,37,10),(38,'',6,38,10),(39,'',6,39,10),(40,'',6,40,10),(41,'',6,41,10),(42,'',6,42,10),(43,'',6,43,10),(44,'',6,44,10),(45,'',6,45,10),(46,'',6,46,10),(47,'',6,47,10),(48,'',6,48,10),(49,'',6,49,10),(50,'',6,50,10),(51,'',6,51,10),(52,'',6,52,10),(53,'',6,53,10),(54,'',6,54,10),(55,'',6,55,10),(56,'',6,56,10),(57,'',6,57,10),(58,'',6,58,10),(59,'',6,59,10),(60,'',6,60,10),(61,'',6,61,10),(62,'',6,62,10),(63,'',6,63,10),(64,'',6,64,10),(65,'',6,65,10),(66,'',6,66,10),(67,'',6,67,10),(68,'',6,68,10),(69,'',6,69,10),(70,'',6,70,10),(71,'',7,71,10),(72,'',7,72,10),(73,'',7,73,10),(74,'',7,74,10),(75,'',7,75,10);
/*!40000 ALTER TABLE `seats_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shedule_time`
--

DROP TABLE IF EXISTS `shedule_time`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `shedule_time` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `arrival_time` time DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shedule_time`
--

LOCK TABLES `shedule_time` WRITE;
/*!40000 ALTER TABLE `shedule_time` DISABLE KEYS */;
INSERT INTO `shedule_time` VALUES (1,'19:09:00','14:01:00'),(2,'09:00:00','03:00:00'),(3,'21:08:00','15:04:00'),(4,'16:05:00','12:34:00'),(5,'16:05:00','12:30:00'),(6,'11:00:00','04:06:00'),(7,'21:00:00','17:09:00'),(8,'14:00:00','05:20:00'),(9,'06:20:00','00:50:00'),(10,'13:20:00','20:00:00');
/*!40000 ALTER TABLE `shedule_time` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `station`
--

DROP TABLE IF EXISTS `station`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `station` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adress` varchar(255) DEFAULT NULL,
  `station_name` varchar(255) DEFAULT NULL,
  `train_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5iuh8yuiw4ruf36byd9pdpox` (`train_id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `station`
--

LOCK TABLES `station` WRITE;
/*!40000 ALTER TABLE `station` DISABLE KEYS */;
INSERT INTO `station` VALUES (2,'509/R Rajshahi','Rajshahi',NULL),(3,'123/K Khulna','Khulna',NULL),(4,'234/k Komolapur, Dhaka','Komolapur Station',NULL),(5,'786/J Joidabpur, Gazipur','Joidabpur ',NULL),(6,'120/R Rampura Road','Rampura_Station',NULL),(7,'88/N Nilmafari','Nilfamari Station',NULL),(8,'76/D Dinagpur road','Dinagpur',NULL),(9,'122/S Shylet','Shylet',NULL),(10,'34/C Chittagoag Road','Chittagoag Station',NULL);
/*!40000 ALTER TABLE `station` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `summary`
--

DROP TABLE IF EXISTS `summary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `summary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available_qty` int(11) NOT NULL,
  `last_update` datetime DEFAULT NULL,
  `sold_qty` int(11) NOT NULL,
  `ticket_no` varchar(255) DEFAULT NULL,
  `total_qty` int(11) NOT NULL,
  `ticket_id` bigint(20) DEFAULT NULL,
  `available_seat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_adu5sglxbrfg0mw2hr75ony03` (`ticket_id`),
  UNIQUE KEY `UK_ohg7mubbnh4fxt8ydi187m0qa` (`available_seat_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `summary`
--

LOCK TABLES `summary` WRITE;
/*!40000 ALTER TABLE `summary` DISABLE KEYS */;
/*!40000 ALTER TABLE `summary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ticket_categore` varchar(255) DEFAULT NULL,
  `compartment_id` bigint(20) DEFAULT NULL,
  `fare_categore_id` bigint(20) DEFAULT NULL,
  `route_id` bigint(20) DEFAULT NULL,
  `seat_or_cabin_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `ticket_no` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjshb54s7kh4ndo3t7epc0prod` (`compartment_id`),
  KEY `FKkptgiuf8ceue425gxmpdrmvxh` (`fare_categore_id`),
  KEY `FKyr2pu9q0aw7h6xmw5n2yae6w` (`route_id`),
  KEY `FK18d2lelk2bnuj70r8nnplt29b` (`seat_or_cabin_id`),
  KEY `FKdvt57mcco3ogsosi97odw563o` (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (1,NULL,3,2,2,2,NULL,5098),(2,NULL,4,1,2,1,NULL,5087),(3,NULL,3,2,3,2,NULL,5012),(4,NULL,4,2,3,2,NULL,5013);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train`
--

DROP TABLE IF EXISTS `train`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `train_name` varchar(255) DEFAULT NULL,
  `train_no` int(11) NOT NULL,
  `route_id` bigint(20) DEFAULT NULL,
  `shedule_time_id` bigint(20) DEFAULT NULL,
  `station_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK189619hk9k3ovx3iu8s9n7t3i` (`route_id`),
  KEY `FKo78lap3ldvrdyb3159b9rwc3k` (`shedule_time_id`),
  KEY `FKc72gg7y1mvxv923yl50cj0xkw` (`station_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train`
--

LOCK TABLES `train` WRITE;
/*!40000 ALTER TABLE `train` DISABLE KEYS */;
INSERT INTO `train` VALUES (1,'Khulna Express',709,1,1,2),(2,'Chitra Express',708,1,3,3),(3,'Khumila Express',705,1,3,3),(4,'Turna_Express',706,4,3,4),(5,'Mohanagar Goduli',703,3,3,4),(6,'Sonar Bangla Express',701,5,4,4),(7,'Chitra Express',711,3,6,4),(8,'Parabat',712,6,7,9),(9,'Nilsagor',765,7,7,4),(10,'Sundarban',734,3,6,4),(11,'Ekota Express',760,8,5,4),(12,'Kalni',745,6,9,4),(13,'Drutojan',757,8,10,4);
/*!40000 ALTER TABLE `train` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `train_class`
--

DROP TABLE IF EXISTS `train_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `train_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `train_class`
--

LOCK TABLES `train_class` WRITE;
/*!40000 ALTER TABLE `train_class` DISABLE KEYS */;
INSERT INTO `train_class` VALUES (3,'Non_AC_Class'),(2,'AC_class'),(4,'media_AC_Class'),(5,'Sleeper_Class'),(6,'First Class'),(7,'First CLass AC'),(8,'First Class Chair'),(9,'2nd Class-Shovon Chair'),(10,'2nd Class-Shovon'),(11,'2nd Class-Shulov'),(12,'AC First/Cabin'),(13,'AC Chair Car'),(14,'Non-AC Chair Car');
/*!40000 ALTER TABLE `train_class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `file_extension` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` bigint(20) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `regi_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_cnjwxx5favk5ycqajjt17fwy1` (`mobile`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'admin@pms.com','','Md.','Gazi',NULL,'2019-03-06','image/jpeg','new-in1.jpg','/images/new-in1.jpg',2560,'Male','2019-03-29 00:25:35','098765433','123',NULL),(7,'f2afa7df-14a4-478f-95ca-5de15d7e6ae7','moni@gmail.com','\0','moni','nahar','moni','1990-10-01',NULL,NULL,NULL,0,'f','2019-04-16 09:40:25',NULL,NULL,'2019-04-16 09:40:25'),(2,'5a9db991-9860-46e9-bad5-474969a95579','nurnaharmoly@gmail.com','','nur','moly','nurnaharmoly','1997-03-10','image/jpeg','new-VIP-42086.jpg','/images/new-VIP-42086.jpg',128521,'Female','2019-03-28 23:57:16','01623782838','$2a$10$4ZDb9kz6tbAFSxZ7oXbnb.lbdNUuJQDu5w/RuCiBaWg4ZC4vT6jb2','2019-03-07 20:49:01'),(3,'d813e810-093e-45e3-a91e-5ae57435cec9','mir@gmail.com','','Mr','Hahammad','mir','2000-10-27','image/jpeg','new-in10.jpg','/images/new-in10.jpg',2225,'Male','2019-03-29 00:24:38','012353463','$2a$10$ToFgDH.0Q/sAsSqhI0A7eOR3B8tVwvJKCRMO1EqDd8LmZuuHZCyhi',NULL),(4,NULL,'rana@gmail.com','','Mr','Rana',NULL,'1994-03-07','image/jpeg','new-98199532N04.jpg','/images/new-98199532N04.jpg',2785,'Male','2019-03-18 10:24:20',NULL,'123',NULL),(6,'c8113887-6ef6-4073-a5a1-fe3ebb6b2983','mohiuddin019123@gmail.com','','MD','Mohiuddin','mohiuddin019123','1987-12-31','image/jpeg','new-in7.jpg','/images/new-in7.jpg',1804,'Male','2019-03-29 00:26:22','0123348434',NULL,'2019-03-18 21:51:40');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_role` (
  `u_id` bigint(20) NOT NULL,
  `r_id` bigint(20) NOT NULL,
  PRIMARY KEY (`u_id`,`r_id`),
  KEY `FKto8gqveqi41eyylx7a2tqlfip` (`r_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (1,1),(2,1),(2,6),(3,3),(3,6),(4,6),(6,6),(7,6);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-16 21:51:35
