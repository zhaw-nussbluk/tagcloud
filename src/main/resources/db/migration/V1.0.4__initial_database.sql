DROP TABLE IF EXISTS `user_roles`;
DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `role`;

CREATE OR REPLACE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime(6) DEFAULT NULL,
  `name` varchar(40) COLLATE utf8_bin NOT NULL,
  `update_date_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_8sewwnpamngi6b1dwaa88askk` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `role` (`id`, `create_date_time`, `name`, `update_date_time`) VALUES
	(1, '2019-04-02 07:57:00.000000', 'ROLE_ADMIN', '2019-04-02 07:57:03.000000');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;

CREATE OR REPLACE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_date_time` datetime(6) DEFAULT NULL,
  `first_name` varchar(80) COLLATE utf8_bin NOT NULL,
  `last_name` varchar(80) COLLATE utf8_bin NOT NULL,
  `mail` varchar(160) COLLATE utf8_bin NOT NULL,
  `password` varchar(255) COLLATE utf8_bin NOT NULL,
  `salutation` varchar(4) COLLATE utf8_bin NOT NULL,
  `update_date_time` datetime(6) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_6sou31qus5dnws6dwfu61e71v` (`mail`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `user` (`id`, `create_date_time`, `first_name`, `last_name`, `mail`, `password`, `salutation`, `update_date_time`) VALUES
	(1, '2019-04-02 07:56:29.000000', 'Admin', 'Admin', 'admin@tagcloud.ch', '$2a$10$TBoYn9sw197j8U1V9zCfMOjTXkq.eGnLWnoW.S.FKlYLGZiI1t0Pa', 'Herr', '2019-04-02 07:56:29.000000');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

CREATE OR REPLACE TABLE `user_roles` (
  `users_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY (`users_id`,`roles_id`),
  KEY `FKj9553ass9uctjrmh0gkqsmv0d` (`roles_id`),
  CONSTRAINT `FK7ecyobaa59vxkxckg6t355l86` FOREIGN KEY (`users_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKj9553ass9uctjrmh0gkqsmv0d` FOREIGN KEY (`roles_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

INSERT INTO `user_roles` (`users_id`, `roles_id`) VALUES
	(1, 1);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;