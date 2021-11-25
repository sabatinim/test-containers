DROP DATABASE IF EXISTS birthday;
CREATE DATABASE birthday;
USE birthday;
CREATE TABLE employees
(
    FirstName varchar(255),
    LastName  varchar(255),
    BirthDay  varchar(255),
    Email     varchar(255)
)ENGINE = InnoDB;