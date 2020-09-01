drop table if exists `sector`;

create table `sector` (
	`sectorId` int(11) not null,
	`sectorBrief` varchar(50) default null,
	`sectorName` varchar(20) default null,
	primary key (`sectorId`)
);