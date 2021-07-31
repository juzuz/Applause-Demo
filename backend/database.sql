
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for testers
-- ----------------------------
DROP TABLE IF EXISTS `testers`;
CREATE TABLE `testers` (
   `id` int NOT NULL AUTO_INCREMENT,
   `first_name` varchar(255) NOT NULL,
   `last_name` varchar(255) NOT NULL,
   `country` varchar(255) NOT NULL,
   `last_login` TIMESTAMP NOT NULL,

   PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices` (
   `id` int NOT NULL AUTO_INCREMENT,
   `description` varchar(255) NOT NULL,
   PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tester_device
-- ----------------------------
DROP TABLE IF EXISTS `tester_device`;
CREATE TABLE `tester_device` (
     `tester_id` int NOT NULL,
     `device_id` int NOT NULL,
     PRIMARY KEY(`tester_id`,`device_id`),
     FOREIGN KEY(`tester_id`) REFERENCES `testers`(`id`),
     FOREIGN KEY(`device_id`) REFERENCES `devices`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for bugs
-- ----------------------------
DROP TABLE IF EXISTS `bugs` ;
CREATE TABLE `bugs` (
    `id` int NOT NULL AUTO_INCREMENT,
    `tester_id` int NOT NULL,
    `device_id` int NOT NULL,

    PRIMARY KEY (`id`),
    FOREIGN KEY(`tester_id`) REFERENCES `testers`(`id`),
    FOREIGN KEY(`device_id`) REFERENCES `devices`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
