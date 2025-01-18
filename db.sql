DROP DATABASE IF EXISTS foro;
DROP TABLE IF EXISTS perfil;
DROP TABLE IF EXISTS usuario;
DROP TABLE IF EXISTS curso;
DROP TABLE IF EXISTS topico;
DROP TABLE IF EXISTS respuesta;

SELECT * FROM perfil;
CREATE DATABASE foro;
USE foro;

-- SCRIPT
create table curso
(
    cur_id        int          not null
        primary key,
    cur_nombre    varchar(255) not null,
    cur_categoria varchar(100) not null
);

create table perfil
(
    per_id     int          not null
        primary key,
    per_nombre varchar(100) not null
);


create table respuesta
(
    res_id            int                  not null
        primary key,
    res_mensaje       text                 not null,
    res_topicoId      int                  not null,
    res_fechaCreacion timestamp            not null,
    res_autor         int                  not null,
    res_solucion      tinyint(1) default 0 null,
    topicoId          int                  null,
    constraint respuesta_ibfk_1
        foreign key (topicoId) references topico (top_id),
    constraint respuesta_ibfk_2
        foreign key (res_autor) references usuario (usu_id)
);

create index idx_respuesta_topico
    on respuesta (topicoId);

create index res_autor
    on respuesta (res_autor);

create table topico
(
    top_id            int          not null
        primary key,
    top_titulo        varchar(255) not null,
    top_mensaje       text         not null,
    top_fechaCreacion timestamp    not null,
    status            varchar(50)  not null,
    top_autor         int          null,
    top_cursoId       int          null,
    constraint topico_ibfk_1
        foreign key (top_autor) references usuario (usu_id),
    constraint topico_ibfk_2
        foreign key (top_cursoId) references curso (cur_id)
);

create index idx_topico_curso
    on topico (top_cursoId);

create index top_autor
    on topico (top_autor);


create table topico
(
    top_id            int          not null
        primary key,
    top_titulo        varchar(255) not null,
    top_mensaje       text         not null,
    top_fechaCreacion timestamp    not null,
    status            varchar(50)  not null,
    top_autor         int          null,
    top_cursoId       int          null,
    constraint topico_ibfk_1
        foreign key (top_autor) references usuario (usu_id),
    constraint topico_ibfk_2
        foreign key (top_cursoId) references curso (cur_id)
);

create index idx_topico_curso
    on topico (top_cursoId);

create index top_autor
    on topico (top_autor);

