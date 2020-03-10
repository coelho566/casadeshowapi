CREATE TABLE `house` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

INSERT INTO `casadeshowapi`.`house` (`name`, `street`) VALUES ('Opera de Arame', 'Rua Pedro viera 455');
INSERT INTO `casadeshowapi`.`house` (`name`, `street`) VALUES ('Shed Bar', 'Rua Das Flores 67');
INSERT INTO `casadeshowapi`.`house` (`name`, `street`) VALUES ('Arena Da Baixada', 'Av. Marechal Floriano Peixoto 452');
INSERT INTO `casadeshowapi`.`house` (`name`, `street`) VALUES ('Bar do Zé', 'Av. Silva Jardim');