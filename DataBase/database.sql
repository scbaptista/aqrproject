-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema aegisBet
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema aegisBet
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `aegisBet` DEFAULT CHARACTER SET utf8 ;
USE `aegisBet` ;

-- -----------------------------------------------------
-- Table `aegisBet`.`Game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aegisBet`.`Game` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `houseTeam` VARCHAR(45) NOT NULL,
  `guestTeam` VARCHAR(45) NOT NULL,
  `oddVictory` FLOAT NOT NULL,
  `oddDraw` FLOAT NOT NULL,
  `oddDefeat` FLOAT NOT NULL,
  `date` VARCHAR(45) NOT NULL,
  `timeBegin` VARCHAR(45) NOT NULL,
  `status` TINYINT(4) NOT NULL,
  `goalsHT` INT(11) NOT NULL,
  `goalsGT` INT(11) NOT NULL,
  `ended` TINYINT(4) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `aegisBet`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aegisBet`.`User` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(256) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `name` VARCHAR(256) NOT NULL,
  `essCoins` FLOAT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `aegisBet`.`Bet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `aegisBet`.`Bet` (
  `idUser` INT(11) NOT NULL,
  `idGame` INT(11) NOT NULL,
  `amount` FLOAT NOT NULL,
  `type` INT(11) NOT NULL,
  `notified` TINYINT(4) NOT NULL,
  PRIMARY KEY (`idUser`, `idGame`),
  INDEX `fk_User_has_Game_Game1_idx` (`idGame` ASC),
  INDEX `fk_User_has_Game_User_idx` (`idUser` ASC),
  CONSTRAINT `fk_User_has_Game_Game1`
    FOREIGN KEY (`idGame`)
    REFERENCES `aegisBet`.`Game` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_User_has_Game_User`
    FOREIGN KEY (`idUser`)
    REFERENCES `aegisBet`.`User` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
