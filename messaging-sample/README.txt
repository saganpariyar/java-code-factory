Set up ActiveMQ server and point to it in the configuration
Set up RabbitMQ server and point to it in the configuration

Create table in mysql instance

drop table if exists `traderequest`;

CREATE TABLE `traderequest` (
  `ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `ticker` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB

Also, download StarUML if you want to look at the model