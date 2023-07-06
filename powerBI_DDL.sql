-- ------------------------------------------------------------------------ --
-- Archivo: PowerBI_DDL.sql		        								--
-- Version: 1.0                                                     		--
-- Autor:   Israel Alejandro López Tovar   								    --
-- Email:   niko.beelik@hotmail.com									        --
-- Fecha de elaboracion: 05-07-2023                                 		--
-- ------------------------------------------------------------------------ --

DROP DATABASE IF EXISTS powerBI;
CREATE DATABASE powerBI;
USE powerBI;

CREATE TABLE usuario(
	idUsuario			INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    nombreUsuario		VARCHAR(20) NOT NULL,
    contrasenia			VARCHAR(40) NOT NULL,
    correo				VARCHAR(45) NOT NULL,
    rol					VARCHAR(45) NOT NULL
);

SELECT * FROM usuario;
INSERT INTO usuario (nombreUsuario,contrasenia,correo,rol) VALUES ("20002148",",Enero2003","niko.beelik@hotmail.com","Estudiante");