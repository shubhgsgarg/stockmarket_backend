DROP TABLE IF EXISTS `company_x_stockexchange`;

CREATE TABLE `company_x_stockexchange` (
  `companyCode` decimal(10,0) DEFAULT NULL,
  `stockExchange` varchar(20) DEFAULT NULL,
  `stockcode` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
