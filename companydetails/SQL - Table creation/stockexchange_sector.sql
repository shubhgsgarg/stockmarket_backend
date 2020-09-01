
DROP TABLE IF EXISTS `sector`;

CREATE TABLE `sector` (
  `sectorId` int(11) NOT NULL AUTO_INCREMENT,
  `sectorName` varchar(20) DEFAULT NULL,
  `brief` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sectorId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
