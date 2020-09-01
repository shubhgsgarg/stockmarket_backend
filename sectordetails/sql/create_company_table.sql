drop table if exists `company`;

create table `company` (
	`companyId` int(11) not null,
	`companyName` varchar(20) default null,
	`sectorName` varchar(20) default null,
	primary key (`companyId`)
);