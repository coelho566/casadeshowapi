CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roles` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;


INSERT INTO `casadeshowapi`.`user` (`email`, `password`, `roles`, `username`) VALUES ('admin@gmail.com', '$2y$12$GBzvNRruX1IeDf7en62NDOEN40t7iqf4Owyyj6LIgQHIvmsBvHgf2', 'ADMIN', 'admin');
INSERT INTO `casadeshowapi`.`user` (`email`, `password`, `roles`, `username`) VALUES ('user@gmail.com', '$2y$12$sdctizmkUOn2jbpI.i7CC.W/asiYK6P3EG9ZEZCRahwQC6qQ.thT2', 'USER', 'user');
INSERT INTO `casadeshowapi`.`user` (`email`, `password`, `roles`, `username`) VALUES ('leandro@gmail.com', '$2y$12$sdctizmkUOn2jbpI.i7CC.W/asiYK6P3EG9ZEZCRahwQC6qQ.thT2', 'ADMIN', 'leandro');
