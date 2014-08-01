SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema springtutorial
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `springtutorial` DEFAULT CHARACTER SET utf8 ;
USE `springtutorial` ;

-- -----------------------------------------------------
-- Table `springtutorial`.`offers`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springtutorial`.`offers` ;

CREATE TABLE IF NOT EXISTS `springtutorial`.`offers` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `email` VARCHAR(60) NOT NULL,
  `text` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `springtutorial`.`authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springtutorial`.`authorities` ;

CREATE TABLE IF NOT EXISTS `springtutorial`.`authorities` (
  `username` VARCHAR(60) NOT NULL,
  `authority` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `springtutorial`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `springtutorial`.`users` ;

CREATE TABLE IF NOT EXISTS `springtutorial`.`users` (
  `username` VARCHAR(60) NOT NULL,
  `password` VARCHAR(80) NULL DEFAULT NULL,
  `enabled` TINYINT(1) NULL DEFAULT 1,
  `email` VARCHAR(60) NULL,
  PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
