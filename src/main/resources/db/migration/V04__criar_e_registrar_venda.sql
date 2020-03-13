CREATE TABLE `venda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_evento` date DEFAULT NULL,
  `local` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `quantidade` int NOT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKicq76w8emyd9tkuhs3xioriak` (`user_id`),
  CONSTRAINT `FKicq76w8emyd9tkuhs3xioriak` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

