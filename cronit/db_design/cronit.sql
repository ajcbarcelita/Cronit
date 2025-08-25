-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema cronit
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `cronit` ;

-- -----------------------------------------------------
-- Schema cronit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cronit` ;
SHOW WARNINGS;
USE `cronit` ;

-- -----------------------------------------------------
-- Table `cronit`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cronit`.`users` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cronit`.`users` (
  `user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL,
  `email` VARCHAR(100) NOT NULL,
  `lname` VARCHAR(50) NOT NULL,
  `fname` VARCHAR(50) NOT NULL,
  `mname` VARCHAR(50) NULL,
  `pw_hash` VARCHAR(255) NOT NULL,
  `created_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
CHECKSUM = 1;

SHOW WARNINGS;
CREATE UNIQUE INDEX `username_UNIQUE` ON `cronit`.`users` (`username` ASC) VISIBLE;

SHOW WARNINGS;
CREATE UNIQUE INDEX `user_id_UNIQUE` ON `cronit`.`users` (`user_id` ASC) VISIBLE;

SHOW WARNINGS;
CREATE UNIQUE INDEX `email_UNIQUE` ON `cronit`.`users` (`email` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cronit`.`habits`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cronit`.`habits` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cronit`.`habits` (
  `habit_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` TINYTEXT NULL,
  `created_at` DATETIME NOT NULL,
  PRIMARY KEY (`habit_id`),
  CONSTRAINT `fktousers`
    FOREIGN KEY (`user_id`)
    REFERENCES `cronit`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
CHECKSUM = 1;

SHOW WARNINGS;
CREATE UNIQUE INDEX `habit_id_UNIQUE` ON `cronit`.`habits` (`habit_id` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fktousers_idx` ON `cronit`.`habits` (`user_id` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cronit`.`tags`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cronit`.`tags` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cronit`.`tags` (
  `tag_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `user_id` INT UNSIGNED NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`tag_id`),
  CONSTRAINT `fk_tags_1`
    FOREIGN KEY (`user_id`)
    REFERENCES `cronit`.`users` (`user_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
CHECKSUM = 1;

SHOW WARNINGS;
CREATE UNIQUE INDEX `tag_id_UNIQUE` ON `cronit`.`tags` (`tag_id` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_tags_1_idx` ON `cronit`.`tags` (`user_id` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cronit`.`habit_logs`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cronit`.`habit_logs` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cronit`.`habit_logs` (
  `log_id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `habit_id` INT UNSIGNED NOT NULL,
  `completed_at` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`log_id`),
  CONSTRAINT `fk_habit_logs_1`
    FOREIGN KEY (`habit_id`)
    REFERENCES `cronit`.`habits` (`habit_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE UNIQUE INDEX `log_id_UNIQUE` ON `cronit`.`habit_logs` (`log_id` ASC) VISIBLE;

SHOW WARNINGS;
CREATE INDEX `fk_habit_logs_1_idx` ON `cronit`.`habit_logs` (`habit_id` ASC) VISIBLE;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `cronit`.`habit_tags`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cronit`.`habit_tags` ;

SHOW WARNINGS;
CREATE TABLE IF NOT EXISTS `cronit`.`habit_tags` (
  `habit_id` INT UNSIGNED NOT NULL,
  `tag_id` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`habit_id`, `tag_id`),
  CONSTRAINT `fk_habit_tags_1`
    FOREIGN KEY (`habit_id`)
    REFERENCES `cronit`.`habits` (`habit_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_habit_tags_2`
    FOREIGN KEY (`tag_id`)
    REFERENCES `cronit`.`tags` (`tag_id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SHOW WARNINGS;
CREATE INDEX `fk_habit_tags_2_idx` ON `cronit`.`habit_tags` (`tag_id` ASC) VISIBLE;

SHOW WARNINGS;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
