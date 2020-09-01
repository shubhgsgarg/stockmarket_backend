

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `UserPassword` varchar(20) DEFAULT NULL,
  `userType` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `confirmed` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ;
