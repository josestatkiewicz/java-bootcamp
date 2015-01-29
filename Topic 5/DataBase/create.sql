SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `high-school` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;

CREATE TABLE IF NOT EXISTS `high-school`.`Student` (
  `idStudent` INT(11) NOT NULL,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `regNumber` INT(11) NULL DEFAULT NULL,
  `dateOfBirth` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idStudent`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `high-school`.`Teacher` (
  `idTeacher` INT(11) NOT NULL,
  `firstName` VARCHAR(45) NULL DEFAULT NULL,
  `lastName` VARCHAR(45) NULL DEFAULT NULL,
  `dateOfBirth` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`idTeacher`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `high-school`.`Course` (
  `idCourse` INT(11) NOT NULL,
  `name` VARCHAR(45) NULL DEFAULT NULL,
  `asignedTeacher` INT(11) NULL DEFAULT NULL,
  `hoursByWeek` FLOAT(11) NULL DEFAULT NULL,
  `scheduleTime` TIME NULL DEFAULT NULL,
  PRIMARY KEY (`idCourse`),
  INDEX `fk_Course_Teacher_idx` (`asignedTeacher` ASC),
  CONSTRAINT `fk_Course_Teacher`
    FOREIGN KEY (`asignedTeacher`)
    REFERENCES `high-school`.`Teacher` (`idTeacher`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;

CREATE TABLE IF NOT EXISTS `high-school`.`CoursesForStudent` (
  `student` INT(11) NOT NULL,
  `course` INT(11) NOT NULL,
  `partialNote1` INT(11) NULL DEFAULT NULL,
  `partialNote2` INT(11) NULL DEFAULT NULL,
  `partialNote3` INT(11) NULL DEFAULT NULL,
  `finalNote` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`student`, `course`),
  INDEX `fk_CoursesForStudent_Course_idx` (`course` ASC),
  CONSTRAINT `fk_CoursesForStudent_Student`
    FOREIGN KEY (`student`)
    REFERENCES `high-school`.`Student` (`idStudent`)
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `fk_CoursesForStudent_Course`
    FOREIGN KEY (`course`)
    REFERENCES `high-school`.`Course` (`idCourse`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_general_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
