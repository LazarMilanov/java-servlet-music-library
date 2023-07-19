-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema itwsmidtermtwo
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema itwsmidtermtwo
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `itwsmidtermtwo` DEFAULT CHARACTER SET utf8 ;
USE `itwsmidtermtwo` ;

-- -----------------------------------------------------
-- Table `itwsmidtermtwo`.`artists`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itwsmidtermtwo`.`artists` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`Id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itwsmidtermtwo`.`albums`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itwsmidtermtwo`.`albums` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `artistid` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_albums_artists_idx` (`artistid` ASC),
  CONSTRAINT `fk_albums_artists`
    FOREIGN KEY (`artistid`)
    REFERENCES `itwsmidtermtwo`.`artists` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `itwsmidtermtwo`.`tracks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `itwsmidtermtwo`.`tracks` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(255) NOT NULL,
  `length` VARCHAR(45) NOT NULL,
  `price` VARCHAR(45) NOT NULL,
  `albumid` INT NOT NULL,
  PRIMARY KEY (`Id`),
  INDEX `fk_tracks_albums1_idx` (`albumid` ASC),
  CONSTRAINT `fk_tracks_albums1`
    FOREIGN KEY (`albumid`)
    REFERENCES `itwsmidtermtwo`.`albums` (`Id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
