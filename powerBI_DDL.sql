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

INSERT INTO usuario (nombreUsuario,contrasenia,correo,rol) VALUES ("20008921",",gato","nesito24@gmail.com","Maestro");

INSERT INTO usuario (nombreUsuario,contrasenia,correo,rol) VALUES ("simon","simon","niko.beelik@hotmail.com","Estudiante");

CREATE TABLE maestro(
		idMaestro INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        nombreMaestro 	VARCHAR(45),
        primerApe 		VARCHAR(45),
        segundoApe	 	VARCHAR(45),
        area			VARCHAR(20),
        matricula		VARCHAR(45),
        idUsuario		INT,
        
        FOREIGN KEY (idUsuario) REFERENCES usuario (idUsuario) 
        );
        
        SELECT * FROM maestro;
        
        
        DELIMITER $$
CREATE PROCEDURE insertarMaestro(	/* Datos Personales */
                                    IN	var_nombre          VARCHAR(64),    --  1
                                    IN	var_ape1 			VARCHAR(64),    --  2
                                    IN	var_ape2	    	VARCHAR(64),    --  3
                                    IN	var_matricula       VARCHAR(129),   -- 14
                                    
                                    /* Datos de Usuario */
                                    IN	var_nombreUsuario   VARCHAR(129),   -- 15
                                    IN	var_contrasenia     VARCHAR(129),   -- 16
                                    IN	var_rol             VARCHAR(25),    -- 17                                    
                                    
				)                                    
    BEGIN        
        -- Comenzamos insertando los datos de la Persona:
        INSERT INTO persona (nombre, apellidoPaterno, apellidoMaterno, genero,
                             fechaNacimiento, calle, numero, colonia, cp, ciudad,
                             estado, telcasa, telmovil, email)
                    VALUES( var_nombre, var_apellidoPaterno, var_apellidoMaterno, 
                            var_genero, STR_TO_DATE(var_fechaNacimiento, '%d/%m/%Y'), 
                            var_calle, var_numero, var_colonia, var_cp, var_ciudad,
                            var_estado, var_telcasa, var_telmovil, var_email);
        -- Obtenemos el ID de Persona que se generó:
        SET var_idPersona = LAST_INSERT_ID();

        -- Insertamos los datos de seguridad del Empleado:
        INSERT INTO usuario ( nombre, contrasenia, rol) 
                    VALUES( var_nombreUsuario, var_contrasenia, var_rol);
        -- Obtenemos el ID de Usuario que se generó:
        SET var_idUsuario = LAST_INSERT_ID();

        --  Generamos el numero unico de empleado.        
        SET var_numeroUnico = '';
        --  Agregamos la primera letra del apellidoPaterno:
        IF  LENGTH(var_apellidoPaterno) >= 1 THEN
            SET var_numeroUnico = SUBSTRING(var_apellidoPaterno, 1, 1);
        ELSE
            SET var_numeroUnico = 'X';
        END IF;
        --  Agregamos la segunda letra del apellidoPaterno:
        IF  LENGTH(var_apellidoPaterno) >= 2 THEN
            SET var_numeroUnico = CONCAT(var_numeroUnico, SUBSTRING(var_apellidoPaterno, 2, 1));
        ELSE
            SET var_numeroUnico = CONCAT(var_numeroUnico, 'X');
        END IF;        
        --  Agregamos el timestamp:
        SET var_numeroUnico = CONCAT(var_numeroUnico, CAST(UNIX_TIMESTAMP() AS CHAR));
        -- Codificamos el numero unico generado:
        SET var_numeroUnico = MD5(var_numeroUnico);

        -- Finalmente, insertamos en la tabla Empleado:
        INSERT INTO empleado (idPersona, idUsuario, numeroUnico)
                    VALUES(var_idPersona, var_idUsuario, var_numeroUnico);
        -- Obtenemos el ID del Empleado que se genero:
        SET var_idEmpleado = LAST_INSERT_ID();
    END
$$
DELIMITER ;
