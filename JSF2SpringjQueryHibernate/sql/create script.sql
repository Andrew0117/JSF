USE `db`;

DELIMITER //

DROP VIEW `vwU`;
DROP TABLE `user`;

CREATE TABLE IF NOT EXISTS `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `login` varchar(101) NOT NULL,
  `password` varchar(101) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;

INSERT INTO `user` (`id`, `login`, `password`) VALUES
	(1, 'John', SHA1('John')),
	(2, 'Andrew', SHA1('Andrew')),
	(3, 'Jack', SHA1('Jack'));

create view vwU
as
select `u`.`id` AS i, `u`.`login` AS l, `u`.`password` AS p
from `user` `u`;

//
DELIMITER ;