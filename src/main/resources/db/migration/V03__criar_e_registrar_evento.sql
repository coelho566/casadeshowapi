CREATE TABLE `event` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `capacity` int NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `date_event` date NOT NULL,
  `foto` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `preco` decimal(19,2) NOT NULL,
  `house_show_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeudtwpa9m8rxtmj7011cs41jr` (`house_show_id`),
  CONSTRAINT `FKeudtwpa9m8rxtmj7011cs41jr` FOREIGN KEY (`house_show_id`) REFERENCES `house` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8

