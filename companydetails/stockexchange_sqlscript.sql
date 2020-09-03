/*
create schema stockexchange and use that to create the below tables
*/
create table sector(sectorId int AUTO_INCREMENT primary key, sectorName varchar(20) unique not null, brief varchar(50));
insert into sector values(1,'agr','asdfg');

create table user(userId int AUTO_INCREMENT primary key, userName varchar(20) unique not null, UserPassword varchar(20), 
userType varchar(20), email varchar(50), confirmed varchar(1));
insert into user values(1234,'admin','admin','admin','jogn@gmail.com','y');

create table T_StockExchange(stockExchangeId int AUTO_INCREMENT primary key, stockExchange varchar(20) unique not null,
 brief varchar(20), contactAddress varchar(100), remarks varchar(50));
insert into T_StockExchange values(1,'nsc','asdfr','aq-9 cxde street', 'this is stockexchange');

create table Company(companyId int AUTO_INCREMENT primary key, companyName varchar(20) unique not null,
 ceo varchar(20),
 sector varchar(20), companyCode numeric unique,
 companyDetails varchar(20),
 CONSTRAINT FK_SectorCompany
FOREIGN KEY (sector) REFERENCES Sector(sectorname)  ON DELETE CASCADE
 );
 
 insert into Company(companyid,companyname,ceo,sector,companycode,companydetails) 
 values(1,'abc','xyez','agr',1002,'it is 1002 company');
 insert into Company(companyid,companyname,ceo,sector,companycode,companydetails) 
 values(2,'abcd','tree','agr',1005,'it is 1005 company');
  insert into Company(companyid,companyname,ceo,sector,companycode,companydetails) 
 values(3,'xyz','tr1','agr',1008,'it is 1008 company');
 create table company_X_BoardOfDir(AssocCompanyId int, boardOfDirName varchar(20),
 CONSTRAINT FK_companyboardofdir
FOREIGN KEY (AssocCompanyId) REFERENCES company(companyid)  ON DELETE CASCADE
);


insert into company_X_BoardOfDir values(1, 'poi');
insert into company_X_BoardOfDir values(1, 'qwerty');

create table company_x_stockexchange(assocCompanyCode numeric, stockExchange varchar(20), stockcode varchar(20) primary key,
 CONSTRAINT FK_companycode
FOREIGN KEY (assocCompanyCode) REFERENCES company(companycode)  ON DELETE CASCADE,
CONSTRAINT FK_stockexchange
FOREIGN KEY (stockExchange) REFERENCES t_stockExchange(stockExchange)  ON DELETE CASCADE
);


insert into company_x_stockexchange values(1002,'nsc','123');

create table CompanyStockPrice(companyStockPriceId int AUTO_INCREMENT primary key, companyCode numeric, stockExchange varchar(20),
 currentPrice double, stockPriceDate date, stockPriceTime time,
  CONSTRAINT FK_company_stockprice
FOREIGN KEY (CompanyCode) REFERENCES company(companycode)  ON DELETE CASCADE,
CONSTRAINT FK_stockexchange_price
FOREIGN KEY (stockExchange) REFERENCES t_stockExchange(stockExchange)  ON DELETE CASCADE
 );
 
insert into CompanyStockPrice values(1, 1002, 'nsc', 10.7,date("2020-08-28"),time("12:15"));
 
 
 create table IPO(ipoId int AUTO_INCREMENT primary key, companyName varchar(20), stockExchange varchar(20), pricePerShare double,
totalShare double, openDateTime datetime, remarks varchar(50),
  CONSTRAINT FK_company_ipo
FOREIGN KEY (Companyname) REFERENCES company(companyname)  ON DELETE CASCADE,
CONSTRAINT FK_stockexchange_ipo
FOREIGN KEY (stockExchange) REFERENCES t_stockExchange(stockExchange)  ON DELETE CASCADE
);

insert into IPO(companyname,stockexchange,pricepershare,totalshare,opendatetime,remarks) 
values('abc','nsc',8987,981133,date("1992-08-20"),'this is ipo1 for abc');

