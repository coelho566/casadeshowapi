CREATE TABLE `house_event` (
  `house_id` bigint NOT NULL,
  `event_id` bigint NOT NULL,
  UNIQUE KEY `UK_kptwi7sie75wyvfau9j6p079g` (`event_id`),
  KEY `FKayj6p5eyqnjcj6t5ngk62t1b2` (`house_id`),
  CONSTRAINT `FK12t0s804u176fuexgs2q2sj40` FOREIGN KEY (`event_id`) REFERENCES `event` (`id`),
  CONSTRAINT `FKayj6p5eyqnjcj6t5ngk62t1b2` FOREIGN KEY (`house_id`) REFERENCES `house` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8