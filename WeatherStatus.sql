create DATABASE if not exists checkweather;
use checkweather;
drop table if exists `Users`;

CREATE TABLE `Users` (
  `name` varchar(20) NOT NULL DEFAULT '',
  `password` varchar(100) NOT NULL,
  `username` varchar(20) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
`enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;
---------------------
drop table if exists `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`,`authority`),
  CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-------------------------------
/*
admin email:admin@admin.com	
password:123
*/
 insert into `Users` 
values 
('admin','$2a$10$DqZKG3u2PcMaiBtvtnDx/eE06me6owpNPHeN.48Pm.lDci4FyGX8y','admin@admin.com','011',1);
insert into `authorities`
values ('admin@admin.com', 'ROLE_ADMIN');
insert into `authorities`
values ('admin@admin.com', 'ROLE_USER');
--------------------------------
drop table if exists `Notes`;

CREATE TABLE `Notes` (
  `status` varchar(20) NOT NULL DEFAULT '',
  `note` varchar(256) NOT NULL default "Sorry lazy Admin",
  `createdate` datetime NOT NULL,
  PRIMARY KEY (`status`)
)  DEFAULT CHARSET=utf8;

 insert into `notes` 
values 
('1',"Very cold",now()); 
insert into `notes` 
values 
('2',"cold",now()); 
insert into `notes` 
values 
('3',"cool ",now()); 
insert into `notes` 
values 
('4',"hot",now());
