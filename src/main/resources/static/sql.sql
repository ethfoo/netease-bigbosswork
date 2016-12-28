CREATE TABLE `bigboss`.`item` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(80) NOT NULL,
  `image` VARCHAR(80) NULL,
  `info` VARCHAR(200) NULL,
  `content` TEXT(1000) NULL,
  `price` DOUBLE NULL,
  PRIMARY KEY (`id`));

CREATE TABLE `bigboss`.`shoppingcart` (
  `id` INT NOT NULL auto_increment,
  `itemid` INT NOT NULL,
  `num` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `itemid_UNIQUE` (`itemid` ASC));

CREATE TABLE `bigboss`.`buyrecord` (
  `id` INT NOT NULL auto_increment,
  `itemid` INT NULL,
  `buyprice` DOUBLE NULL,
  `num` INT NULL,
  `date` DATE NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `itemid_UNIQUE` (`itemid` ASC));

