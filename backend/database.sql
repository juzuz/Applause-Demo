
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for testers
-- ----------------------------
DROP TABLE IF EXISTS `testers`;
CREATE TABLE `testers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `lastName` varchar(255) NOT NULL,
  `country` varchar(255) NOT NULL,
  `lastLogin` TIMESTAMP NOT NULL,
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices` (
  `id` int NOT NULL AUTO_INCREMENT,
  -- User Profile Info, not necessarily the shipping info.
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
 
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for tester_device
-- ----------------------------
DROP TABLE IF EXISTS `tester_device`;
CREATE TABLE `tester_device` (
  `testerId` int NOT NULL,
  `deviceId` int NOT NULL,
  PRIMARY KEY (`testerId`,`deviceId`),
  FOREIGN KEY(`testerId`) REFERENCES `testers`(`id`),
  FOREIGN KEY(`deviceId`) REFERENCES `devices`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for bugs
-- ----------------------------
DROP TABLE IF EXISTS `bugs` ;
CREATE TABLE `bugs` (
  `id` int NOT NULL AUTO_INCREMENT,
  `testerId` int NOT NULL,
  `deviceId` int NOT NULL,
 
  PRIMARY KEY (`id`),
  FOREIGN KEY(`testerId`) REFERENCES `testers`(`id`),
  FOREIGN KEY(`deviceId`) REFERENCES `devices`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- TRIGGERS
-- THESE TRIGGERS WHERE RUN IN THE COMMAND LINE 

-- On soft-remove, which is when the removed boolean is set to true, 
-- remove all user cart items that have the same book id
-- DROP TRIGGER IF EXISTS trg_removeCartOnBookSoftDelete
-- delimiter // 
-- CREATE TRIGGER trg_removeCartOnBookSoftDelete
-- AFTER UPDATE ON book 
-- FOR EACH ROW
-- BEGIN
-- 	IF (OLD.removed != NEW.removed)
-- 	THEN
-- 		DELETE FROM cart WHERE book_id = NEW.id;
-- 	END IF;
-- END;
-- //
-- DELIMITER ;

-- DROP TRIGGER IF EXISTS trg_removeCartOnUserSoftDelete
-- delimiter // 
-- CREATE TRIGGER trg_removeCartOnUserSoftDelete
-- AFTER UPDATE ON user_auth 
-- FOR EACH ROW
-- BEGIN
-- 	IF (OLD.removed != NEW.removed)
-- 	THEN
-- 		DELETE FROM cart WHERE user_id = NEW.user_id;
-- 	END IF;
-- END;
-- //
-- DELIMITER ;

-- DROP TRIGGER IF EXISTS trg_removeAddressOnUserSoftDelete
-- delimiter // 
-- CREATE TRIGGER trg_removeAddressOnUserSoftDelete
-- AFTER UPDATE ON user_auth 
-- FOR EACH ROW
-- BEGIN
-- 	IF (OLD.removed != NEW.removed)
-- 	THEN
-- 		DELETE FROM address WHERE user_id = NEW.user_id;
-- 	END IF;
-- END;
-- //
-- DELIMITER ;



-- TRIGGERS
-- THESE TRIGGERS WHERE RUN IN THE COMMAND LINE 

-- On soft-remove, which is when the removed boolean is set to true, 
-- remove all user cart items that have the same book id
-- DROP TRIGGER IF EXISTS trg_removeCartOnBookSoftDelete
-- delimiter // 
-- CREATE TRIGGER trg_removeCartOnBookSoftDelete
-- AFTER UPDATE ON book 
-- FOR EACH ROW
-- BEGIN
-- 	IF (OLD.removed != NEW.removed)
-- 	THEN
-- 		DELETE FROM cart WHERE book_id = NEW.id;
-- 	END IF;
-- END;
-- //
-- DELIMITER ;

-- DROP TRIGGER IF EXISTS trg_removeCartOnUserSoftDelete
-- delimiter // 
-- CREATE TRIGGER trg_removeCartOnUserSoftDelete
-- AFTER UPDATE ON user_auth 
-- FOR EACH ROW
-- BEGIN
-- 	IF (OLD.removed != NEW.removed)
-- 	THEN
-- 		DELETE FROM cart WHERE user_id = NEW.user_id;
-- 	END IF;
-- END;
-- //
-- DELIMITER ;

-- DROP TRIGGER IF EXISTS trg_removeAddressOnUserSoftDelete
-- delimiter // 
-- CREATE TRIGGER trg_removeAddressOnUserSoftDelete
-- AFTER UPDATE ON user_auth 
-- FOR EACH ROW
-- BEGIN
-- 	IF (OLD.removed != NEW.removed)
-- 	THEN
-- 		DELETE FROM address WHERE user_id = NEW.user_id;
-- 	END IF;
-- END;
-- //
-- DELIMITER ;


