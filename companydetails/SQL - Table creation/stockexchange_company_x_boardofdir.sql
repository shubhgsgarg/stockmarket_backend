
DROP TABLE IF EXISTS `company_x_boardofdir`;

CREATE TABLE `company_x_boardofdir` (
  `AssocCompanyId` decimal(10,0) DEFAULT NULL,
  `boardOfDirName` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
