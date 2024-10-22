create schema Taller2;

CREATE TABLE IF NOT EXISTS taller2.tbl_estado_civil
(
    id_esta_civil serial,
    descripcion character varying(25) COLLATE pg_catalog."default",
    PRIMARY KEY (id_esta_civil)
);

CREATE TABLE IF NOT EXISTS taller2.tbl_genero
(
    id_genero serial,
    descripcion character varying(15) COLLATE pg_catalog."default",
    abreviatura character varying(1) COLLATE pg_catalog."default",
    PRIMARY KEY (id_genero)
);

CREATE TABLE IF NOT EXISTS taller2.tbl_grupo_sanguineo
(
    id_grup_sang serial,
    descripcion character varying(2) COLLATE pg_catalog."default",
    PRIMARY KEY (id_grup_sang)
);

CREATE TABLE IF NOT EXISTS taller2.tbl_rh
(
    id_rh serial,
    descripcion character varying(1) COLLATE pg_catalog."default",
    PRIMARY KEY (id_rh)
);

CREATE TABLE IF NOT EXISTS taller2.tbl_tipodocumento
(
    id_tipo_documento serial,
    descripcion character varying(25) COLLATE pg_catalog."default",
    abreviatura character varying(3) COLLATE pg_catalog."default",
    PRIMARY KEY (id_tipo_documento)
);

CREATE TABLE IF NOT EXISTS taller2.tbl_usuario
(
    id_usuario serial,
    documento numeric NOT NULL,
    fecha_expedicion date NOT NULL,
    nombres character varying(30) COLLATE pg_catalog."default" NOT NULL,
    apellidos character varying(30) COLLATE pg_catalog."default" NOT NULL,
    numero_hijos numeric,
    celular character varying(15) COLLATE pg_catalog."default",
    correo_electronico character varying(40) COLLATE pg_catalog."default",
    contrasenha character varying(25) COLLATE pg_catalog."default" NOT NULL,
    id_tipo_documento integer,
    id_genero integer,
    id_grup_sang integer,
    id_rh integer,
    id_esta_civil integer,
    PRIMARY KEY (id_usuario)    
);

ALTER TABLE taller2.tbl_usuario
ADD CONSTRAINT fk_tbl_usuario_id_esta_civil FOREIGN KEY (id_esta_civil)
REFERENCES taller2.tbl_estado_civil (id_esta_civil);
        
ALTER TABLE taller2.tbl_usuario
ADD CONSTRAINT fk_tbl_usuario_tbl_grupo_sanguineo FOREIGN KEY (id_grup_sang)
        REFERENCES taller2.tbl_grupo_sanguineo (id_grup_sang);
ALTER TABLE taller2.tbl_usuario
ADD CONSTRAINT fk_tbl_usuario_tbl_id_genero FOREIGN KEY (id_genero)
REFERENCES taller2.tbl_genero (id_genero);
ALTER TABLE taller2.tbl_usuario
ADD CONSTRAINT fk_tbl_usuario_tbl_rh FOREIGN KEY (id_rh)
        REFERENCES taller2.tbl_rh (id_rh);
ALTER TABLE taller2.tbl_usuario
ADD CONSTRAINT fk_tbl_usuario_tbl_tipodocumento FOREIGN KEY (id_tipo_documento)
        REFERENCES taller2.tbl_tipodocumento (id_tipo_documento);


INSERT INTO taller2.tbl_tipodocumento (descripcion, abreviatura) VALUES ('Cédula de Ciudadanía', 'CC');
INSERT INTO taller2.tbl_tipodocumento (descripcion, abreviatura) VALUES ('Tarjeta de Identidad', 'TI');
INSERT INTO taller2.tbl_tipodocumento (descripcion, abreviatura) VALUES ('Cédula de Extranjería', 'CE');
INSERT INTO taller2.tbl_tipodocumento (descripcion, abreviatura) VALUES ('Pasaporte', 'PA');

INSERT INTO taller2.tbl_rh (descripcion) VALUES ('+');
INSERT INTO taller2.tbl_rh (descripcion) VALUES ('-');

INSERT INTO taller2.tbl_grupo_sanguineo (descripcion) VALUES ('A');
INSERT INTO taller2.tbl_grupo_sanguineo (descripcion) VALUES ('B');
INSERT INTO taller2.tbl_grupo_sanguineo (descripcion) VALUES ('AB');
INSERT INTO taller2.tbl_grupo_sanguineo (descripcion) VALUES ('O');

INSERT INTO taller2.tbl_genero (descripcion, abreviatura) VALUES ('Masculino', 'M');
INSERT INTO taller2.tbl_genero (descripcion, abreviatura) VALUES ('Femenino', 'F');

INSERT INTO taller2.tbl_estado_civil (descripcion) VALUES ('Soltero');
INSERT INTO taller2.tbl_estado_civil (descripcion) VALUES ('Casado');
INSERT INTO taller2.tbl_estado_civil (descripcion) VALUES ('Divorciado');
INSERT INTO taller2.tbl_estado_civil (descripcion) VALUES ('Viudo');

select * from taller2.tbl_usuario
select * from taller2.tbl_grupo_sanguineo
select * from taller2.tbl_rh
select * from taller2.tbl_estado_civil









