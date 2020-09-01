
DROP TABLE IF EXISTS `sector`;

CREATE TABLE `sector` (
  `sectorId` int(11) NOT NULL AUTO_INCREMENT,
  `sectorName` varchar(20) DEFAULT NULL,
  `brief` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`sectorId`)
) ;
