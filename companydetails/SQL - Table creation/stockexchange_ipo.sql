
DROP TABLE IF EXISTS `ipo`;

CREATE TABLE `ipo` (
  `ipoId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(20) DEFAULT NULL,
  `stockExchange` varchar(20) DEFAULT NULL,
  `pricePerShare` double DEFAULT NULL,
  `totalShare` double DEFAULT NULL,
  `openDateTime` datetime DEFAULT NULL,
  `remarks` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ipoId`)
) ;
