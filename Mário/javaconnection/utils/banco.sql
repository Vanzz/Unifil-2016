a/*
SQLyog Community Edition- MySQL GUI v7.02 
MySQL - 5.1.44-community : Database - laboratorio3
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`laboratorio3` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `laboratorio3`;

/*Table structure for table `pessoa` */

DROP TABLE IF EXISTS `pessoa`;

CREATE TABLE `pessoa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(127) COLLATE utf8_unicode_ci DEFAULT NULL,
  `idade` tinyint(4) DEFAULT NULL,
  `email` varchar(127) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `pessoa` */

insert  into `pessoa`(`id`,`nome`,`idade`,`email`) values (1,'Alan Turing',69,'alan.turing@email.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
