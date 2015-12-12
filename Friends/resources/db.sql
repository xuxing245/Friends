CREATE TABLE `user` (
  `id` varchar(255) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `pwd` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `openId` varchar(45) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `activity` (
  `id` VARCHAR(255) NOT NULL,
  `title` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `startTime` DATETIME NULL,
  `creater` VARCHAR(255) NULL,
  `status` INT NULL,
  `addressName` VARCHAR(255) NULL,
  `latitude` DOUBLE NULL,
  `longtitude` DOUBLE NULL,
  PRIMARY KEY (`id`));
