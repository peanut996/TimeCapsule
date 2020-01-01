-- MySQL Script generated by MySQL Workbench
-- 2020年01月01日 星期三 00时02分31秒
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema TimeCapsule
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `TimeCapsule` ;

-- -----------------------------------------------------
-- Schema TimeCapsule
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `TimeCapsule` DEFAULT CHARACTER SET utf8mb4 ;
USE `TimeCapsule` ;

-- -----------------------------------------------------
-- Table `TimeCapsule`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TimeCapsule`.`user` ;

CREATE TABLE IF NOT EXISTS `TimeCapsule`.`user` (
  `id` BIGINT(10) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NULL,
  `email` VARCHAR(45) NOT NULL,
  `createtime` VARCHAR(45) NULL,
  `updatetime` VARCHAR(45) NULL COMMENT 'the time user change the profile latestly. ',
  `avatar` VARCHAR(255) NULL DEFAULT NULL COMMENT 'get image from smms api',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COMMENT = 'Information for all member. ';


-- -----------------------------------------------------
-- Table `TimeCapsule`.`capsule`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TimeCapsule`.`capsule` ;

CREATE TABLE IF NOT EXISTS `TimeCapsule`.`capsule` (
  `id` BIGINT(10) NOT NULL,
  `content` VARCHAR(4096) NOT NULL,
  `createtime` DATETIME NOT NULL,
  `opentime` DATETIME NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `uuid` VARCHAR(45) NOT NULL COMMENT 'unqiue key for the capsule. ',
  `warncontent` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `uuid_UNIQUE` (`uuid` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `TimeCapsule`.`admin`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `TimeCapsule`.`admin` ;

CREATE TABLE IF NOT EXISTS `TimeCapsule`.`admin` (
  `id` BIGINT(10) NOT NULL,
  `account` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `avatar` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `account_UNIQUE` (`account` ASC))
ENGINE = InnoDB
COMMENT = 'Administrator for timecapsule-web-admin. ';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
