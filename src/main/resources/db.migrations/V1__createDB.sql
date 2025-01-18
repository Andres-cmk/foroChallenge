CREATE TABLE curso
(
    cur_id        INT          NOT NULL,
    cur_nombre    VARCHAR(255) NOT NULL,
    cur_categoria VARCHAR(100) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (cur_id)
);

CREATE TABLE perfil
(
    per_id     INT          NOT NULL,
    per_nombre VARCHAR(100) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (per_id)
);

CREATE TABLE respuesta
(
    res_id            INT       NOT NULL,
    res_mensaje       LONGTEXT  NOT NULL,
    res_topicoId      INT       NOT NULL,
    res_fechaCreacion timestamp NOT NULL,
    res_autor         INT       NOT NULL,
    res_solucion      TINYINT(1) DEFAULT 0 NULL,
    topicoId          INT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (res_id)
);

CREATE TABLE topico
(
    top_id            INT          NOT NULL,
    top_titulo        VARCHAR(255) NOT NULL,
    top_mensaje       LONGTEXT     NOT NULL,
    top_fechaCreacion timestamp    NOT NULL,
    status            VARCHAR(50)  NOT NULL,
    top_autor         INT NULL,
    top_cursoId       INT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (top_id)
);

CREATE TABLE usuario
(
    usu_id                INT          NOT NULL,
    usu_nombre            VARCHAR(100) NOT NULL,
    usu_correoElectronico VARCHAR(255) NOT NULL,
    usu_contrasenia       VARCHAR(255) NOT NULL,
    perfilId              INT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (usu_id)
);

ALTER TABLE usuario
    ADD CONSTRAINT usu_correoElectronico UNIQUE (usu_correoElectronico);

ALTER TABLE respuesta
    ADD CONSTRAINT respuesta_ibfk_1 FOREIGN KEY (topicoId) REFERENCES topico (top_id) ON DELETE NO ACTION;

CREATE INDEX idx_respuesta_topico ON respuesta (topicoId);

ALTER TABLE respuesta
    ADD CONSTRAINT respuesta_ibfk_2 FOREIGN KEY (res_autor) REFERENCES usuario (usu_id) ON DELETE NO ACTION;

CREATE INDEX res_autor ON respuesta (res_autor);

ALTER TABLE topico
    ADD CONSTRAINT topico_ibfk_1 FOREIGN KEY (top_autor) REFERENCES usuario (usu_id) ON DELETE NO ACTION;

CREATE INDEX top_autor ON topico (top_autor);

ALTER TABLE topico
    ADD CONSTRAINT topico_ibfk_2 FOREIGN KEY (top_cursoId) REFERENCES curso (cur_id) ON DELETE NO ACTION;

CREATE INDEX idx_topico_curso ON topico (top_cursoId);

ALTER TABLE usuario
    ADD CONSTRAINT usuario_ibfk_1 FOREIGN KEY (perfilId) REFERENCES perfil (per_id) ON DELETE NO ACTION;

CREATE INDEX idx_usuario_perfil ON usuario (perfilId);