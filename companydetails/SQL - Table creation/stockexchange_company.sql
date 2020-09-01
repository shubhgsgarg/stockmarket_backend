
DROP TABLE IF EXISTS `company`;

CREATE TABLE `company` (
  `companyId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(20) DEFAULT NULL,
  `ceo` varchar(20) DEFAULT NULL,
  `sector` varchar(20) DEFAULT NULL,
  `companyCode` decimal(10,0) DEFAULT NULL,
  `companyDetails` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`companyId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
