/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.5.28 : Database - tradesys
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`tradesys` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `tradesys`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2y94svpmqttx80mshyny85wqr` (`parent_id`),
  CONSTRAINT `FK2y94svpmqttx80mshyny85wqr` FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FK_category_id` FOREIGN KEY (`parent_id`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `comments` */

DROP TABLE IF EXISTS `comments`;

CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(500) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `prodid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKj1n52bql39i7ktdm9uuswxj5b` (`prodid`),
  KEY `FK4hh9i1avxu3024fauion4ovb` (`userid`),
  CONSTRAINT `FK4hh9i1avxu3024fauion4ovb` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `FKj1n52bql39i7ktdm9uuswxj5b` FOREIGN KEY (`prodid`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_comments_prod` FOREIGN KEY (`prodid`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_comments_user` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `location` */

DROP TABLE IF EXISTS `location`;

CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location_name` varchar(45) DEFAULT NULL,
  `createdby` varchar(45) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `parent_id_fk_index` (`parent_id`),
  CONSTRAINT `FKm5xl34yboc8re75qsac6svt6g` FOREIGN KEY (`parent_id`) REFERENCES `location` (`id`),
  CONSTRAINT `location_parent_id_fk` FOREIGN KEY (`parent_id`) REFERENCES `location` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `order` */

DROP TABLE IF EXISTS `order`;

CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `order_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `payment_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt7abetueht6dd1gs9jyl3o4t7` (`user_id`),
  CONSTRAINT `FKt7abetueht6dd1gs9jyl3o4t7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK_order` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `orderproduct` */

DROP TABLE IF EXISTS `orderproduct`;

CREATE TABLE `orderproduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ord_id` int(11) DEFAULT NULL,
  `prod_id` int(11) DEFAULT NULL,
  `prod_quantity` double DEFAULT NULL,
  `price_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5gpllff762wwqn6elxm9llk11` (`ord_id`),
  KEY `FKlnsmx40vn9qrr0ba0m0ui8ovh` (`price_id`),
  KEY `FKhwdv6nb5qtk9rhhvrs4s5y7ei` (`prod_id`),
  CONSTRAINT `FKhwdv6nb5qtk9rhhvrs4s5y7ei` FOREIGN KEY (`prod_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK5gpllff762wwqn6elxm9llk11` FOREIGN KEY (`ord_id`) REFERENCES `order` (`id`),
  CONSTRAINT `FKlnsmx40vn9qrr0ba0m0ui8ovh` FOREIGN KEY (`price_id`) REFERENCES `pricesslot` (`id`),
  CONSTRAINT `FK_order_product_order` FOREIGN KEY (`ord_id`) REFERENCES `order` (`id`),
  CONSTRAINT `FK_order_product_price` FOREIGN KEY (`price_id`) REFERENCES `pricesslot` (`id`),
  CONSTRAINT `FK_order_product_prod` FOREIGN KEY (`prod_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `orderproductstatus` */

DROP TABLE IF EXISTS `orderproductstatus`;

CREATE TABLE `orderproductstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ord_prod_id` int(11) DEFAULT NULL,
  `status_date` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKprx4apbxp7b9tuv3eavx3yyk1` (`ord_prod_id`),
  KEY `FK6wgybtho5op9x3tc1gcv5rvol` (`status`),
  CONSTRAINT `FK6wgybtho5op9x3tc1gcv5rvol` FOREIGN KEY (`status`) REFERENCES `status` (`id`),
  CONSTRAINT `FKprx4apbxp7b9tuv3eavx3yyk1` FOREIGN KEY (`ord_prod_id`) REFERENCES `orderproduct` (`id`),
  CONSTRAINT `FK_ops_prod` FOREIGN KEY (`ord_prod_id`) REFERENCES `orderproduct` (`id`),
  CONSTRAINT `FK_order_product_status_status_id` FOREIGN KEY (`status`) REFERENCES `status` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Table structure for table `pricesslot` */

DROP TABLE IF EXISTS `pricesslot`;

CREATE TABLE `pricesslot` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `min_order` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKl7jimvgvygs3hjea2i16dosoi` (`prod_id`),
  CONSTRAINT `FKl7jimvgvygs3hjea2i16dosoi` FOREIGN KEY (`prod_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_pricesslot_id` FOREIGN KEY (`prod_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_name` varchar(100) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1mtsbur82frn64de7balymq9s` (`category_id`),
  KEY `FKrjx2c79b1cc0jykhf57lfqx0t` (`status`),
  KEY `FK979liw4xk18ncpl87u4tygx2u` (`user_id`),
  CONSTRAINT `FK979liw4xk18ncpl87u4tygx2u` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FK1mtsbur82frn64de7balymq9s` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`),
  CONSTRAINT `FKrjx2c79b1cc0jykhf57lfqx0t` FOREIGN KEY (`status`) REFERENCES `status` (`id`),
  CONSTRAINT `FK_product` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_prod_cat_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_prod_status_id` FOREIGN KEY (`status`) REFERENCES `status` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

/*Table structure for table `productpicture` */

DROP TABLE IF EXISTS `productpicture`;

CREATE TABLE `productpicture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prod_id` int(11) DEFAULT NULL,
  `picture` varchar(500) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKlxl68kwbf1qe8d8d5l85rp6pn` (`prod_id`),
  CONSTRAINT `FKlxl68kwbf1qe8d8d5l85rp6pn` FOREIGN KEY (`prod_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FK_prodpicture_prod` FOREIGN KEY (`prod_id`) REFERENCES `product` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `status` */

DROP TABLE IF EXISTS `status`;

CREATE TABLE `status` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `status_name` varchar(50) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `created_date` datetime DEFAULT NULL,
  `created_by` int(11) DEFAULT NULL,
  `status_id` int(11) DEFAULT NULL,
  `profile_id` int(11) DEFAULT NULL,
  `salt` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `username_UNIQUE` (`user_name`),
  UNIQUE KEY `UKlqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  UNIQUE KEY `salt_UNIQUE` (`salt`),
  UNIQUE KEY `UKoqm7ghdjhag2ovumjblrnaavb` (`salt`),
  KEY `user_profile_id_fk_idx` (`profile_id`),
  KEY `user_role_id_fk_idx` (`role_id`),
  CONSTRAINT `FKpyhic5sa3npul6p4bywna05ju` FOREIGN KEY (`profile_id`) REFERENCES `userprofile` (`id`),
  CONSTRAINT `FKn82ha3ccdebhokx3a8fgdqeyy` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  CONSTRAINT `user_profile_id_fk` FOREIGN KEY (`profile_id`) REFERENCES `userprofile` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

/*Table structure for table `userprofile` */

DROP TABLE IF EXISTS `userprofile`;

CREATE TABLE `userprofile` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `phone` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `profile_location_id_fk_idx` (`location_id`),
  CONSTRAINT `FK4flp605mehmoi1v2idncxdemn` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `profile_location_id_fk` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
