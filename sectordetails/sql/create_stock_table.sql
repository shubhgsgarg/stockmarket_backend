drop table if exists `stock`;

create table `stock` (
	`stockId` int(11) not null,
	`companyName` varchar(20) default null,
	`date` varchar(20) default null,
	`price` float(1) default null,
	primary key (`stockId`)
);