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
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

CREATE TABLE `userprofile` (
  `id` int(11) NOT NULL,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `picture` varchar(45) DEFAULT NULL,
  `location_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `profile_location_id_fk_idx` (`location_id`),
  CONSTRAINT `FK4flp605mehmoi1v2idncxdemn` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`),
  CONSTRAINT `profile_location_id_fk` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(45) DEFAULT NULL,
  `createddate` datetime DEFAULT NULL,
  `createdby` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

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
  CONSTRAINT `user_profile_id_fk` FOREIGN KEY (`profile_id`) REFERENCES `userprofile` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `user_role_id_fk` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
