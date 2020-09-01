use stockexchange;
DROP TABLE IF EXISTS `companystockprice`;
CREATE TABLE `companystockprice` (
  `companystockpriceid` int(11) NOT NULL AUTO_INCREMENT,
  `companycode` decimal(10,0) DEFAULT NULL,
  `stockexchange` varchar(20) DEFAULT NULL,
  `currentprice` double DEFAULT NULL,
  `stockpricedate` date DEFAULT NULL,
  `stockpricetime` time DEFAULT NULL,
  PRIMARY KEY (`companyStockPriceid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

select*from companystockprice;