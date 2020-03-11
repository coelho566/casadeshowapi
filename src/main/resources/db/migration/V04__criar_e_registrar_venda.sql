CREATE TABLE `venda` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_venda` datetime DEFAULT NULL,
  `quantidade` int NOT NULL,
  `total` decimal(19,2) DEFAULT NULL,
  `event_id` bigint DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK96se4d389ifycpiix320sufdd` (`event_id`),
  KEY `FKicq76w8emyd9tkuhs3xioriak` (`user_id`),
  CONSTRAINT `FK96se4d389ifycpiix320sufdd` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  CONSTRAINT `FKicq76w8emyd9tkuhs3xioriak` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

