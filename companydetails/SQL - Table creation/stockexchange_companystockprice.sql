
DROP TABLE IF EXISTS `companystockprice`;

CREATE TABLE `companystockprice` (
  `companyStockPriceId` int(11) NOT NULL AUTO_INCREMENT,
  `companyCode` decimal(10,0) DEFAULT NULL,
  `stockExchange` varchar(20) DEFAULT NULL,
  `currentPrice` double DEFAULT NULL,
  `stockPriceDate` date DEFAULT NULL,
  `stockPriceTime` time DEFAULT NULL,
  PRIMARY KEY (`companyStockPriceId`)
);
