
DROP TABLE IF EXISTS `ipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ipo` (
  `ipoId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(20) DEFAULT NULL,
  `stockExchange` varchar(20) DEFAULT NULL,
  `pricePerShare` double DEFAULT NULL,
  `totalShare` double DEFAULT NULL,
  `openDateTime` datetime DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ipoId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
