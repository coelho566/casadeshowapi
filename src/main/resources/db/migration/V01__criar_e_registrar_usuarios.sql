CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO `casadeshowapi`.`user` (`email`, `password`, `roles`, `username`) VALUES ('admin@gmail.com', 'admin', 'ADMIN', 'admin');
INSERT INTO `casadeshowapi`.`user` (`email`, `password`, `roles`, `username`) VALUES ('user@gmail.com', 'user', 'USER', 'user');