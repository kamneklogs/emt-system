CREATE DATABASE IF NOT EXISTS emt;

USE emt;

CREATE TABLE Role IF NOT EXISTS (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(45) NOT NULL,
    PRIMARY KEY (id)
) AUTO_INCREMENT = 1;

CREATE TABLE User IF NOT EXISTS (
    username varchar(256) NOT NULL,
    password varchar(256) NOT NULL,
    role_id int NOT NULL,
    last_login TIMESTAMP NOT NULL DEFAULT '1970-01-01 00:00:01',
    PRIMARY KEY (username),
    KEY fk_User_1_idx (role_id),
    CONSTRAINT fk_User_1 FOREIGN KEY (role_id) REFERENCES Role (id) ON DELETE CASCADE ON UPDATE RESTRICT
);