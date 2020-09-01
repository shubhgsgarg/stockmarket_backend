
DROP TABLE IF EXISTS `t_stockexchange`;

CREATE TABLE `t_stockexchange` (
  `stockExchangeId` int(11) NOT NULL AUTO_INCREMENT,
  `stockExchange` varchar(20) DEFAULT NULL,
  `brief` varchar(20) DEFAULT NULL,
  `contactAddress` varchar(100) DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stockExchangeId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
