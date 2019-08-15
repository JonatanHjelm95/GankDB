-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gankDB` DEFAULT CHARACTER SET utf8 ;
-- -----------------------------------------------------
-- Schema gankDB
-- -----------------------------------------------------
USE `gankDB` ;

-- -----------------------------------------------------
-- Table `mydb`.`alliancePlayer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gankDB`.`alliancePlayer` (
  `charName` VARCHAR(12) NOT NULL,
  `race` VARCHAR(255) NOT NULL,
  `class` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `level` INT NULL,
  PRIMARY KEY (`charName`),
  UNIQUE INDEX `charName_UNIQUE` (`charName` ASC));


-- -----------------------------------------------------
-- Table `mydb`.`playerNotes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gankDB`.`playerNotes` (
  `name` VARCHAR(45) NOT NULL,
  `notes` VARCHAR(255) NULL,
  PRIMARY KEY (`name`),
  CONSTRAINT `charName`
    FOREIGN KEY (`name`)
    REFERENCES `gankDB`.`alliancePlayer` (`charName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
