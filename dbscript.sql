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
-- -----------------------------------------------------
-- Schema gankDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema gankDB
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gankDB` DEFAULT CHARACTER SET utf8 COLLATE=utf8_general_ci;
USE `gankDB` ;

-- -----------------------------------------------------
-- Table `gankDB`.`alliancePlayer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gankDB`.`alliancePlayer` (
  `charName` VARCHAR(12) NOT NULL,
  `race` VARCHAR(255) NOT NULL,
  `gender` VARCHAR(45) NOT NULL,
  `class` VARCHAR(32) NOT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `level` INT(11) NULL DEFAULT NULL,
  `guild` VARCHAR(45) NULL DEFAULT 'N/A',
  PRIMARY KEY (`charName`),
  UNIQUE INDEX `charName_UNIQUE` (`charName` ASC))
ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci; 

-- -----------------------------------------------------
-- Table `gankDB`.`playerNotes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gankDB`.`playerNotes` (
  `name` VARCHAR(45) NOT NULL,
  `notes` VARCHAR(255) NULL DEFAULT NULL,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`name`),
  CONSTRAINT `charName`
    FOREIGN KEY (`name`)
    REFERENCES `gankDB`.`alliancePlayer` (`charName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci; 


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
