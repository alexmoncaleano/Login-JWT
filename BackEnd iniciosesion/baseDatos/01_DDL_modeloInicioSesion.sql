/*==============================================================*/
/* Table: accesos                                               */
/*==============================================================*/
create table accesos
(
   cod_usuario          int not null,
   estado_acceso        smallint not null default 1,
   correo_acceso        varchar(150) unique not null,
   clave_acceso         varchar(150) not null,
   avatar_acceso        longtext not null,
   primary key (cod_usuario)
);

/*==============================================================*/
/* Table: perfiles                                              */
/*==============================================================*/
create table perfiles
(
   cod_perfil           int not null auto_increment,
   nombre_perfil        varchar(150) not null,
   primary key (cod_perfil)
);

/*==============================================================*/
/* Table: usuarios                                              */
/*==============================================================*/
create table usuarios
(
   cod_usuario          int not null auto_increment,
   cod_perfil           int not null,
   tipo_documento_usuario varchar(10) not null default 'CC',
   documento_usuario    varchar(100) not null,
   genero_usuario       smallint(1) UNSIGNED not null default 1,
   nombres_usuario      varchar(150) not null,
   apellidos_usuario    varchar(150) not null,
   telefono_usuario     varchar(150) not null,
   CONSTRAINT CHK_GEN CHECK ((genero_usuario >= 1 AND genero_usuario<=3)),
   primary key (cod_usuario)
);

/*==============================================================*/
/* Index: ind_documento                                         */
/*==============================================================*/
create unique index ind_documento on usuarios(documento_usuario);

/*==============================================================*/
/* CONSTRAINTS: relaciones
/*==============================================================*/
alter table accesos add constraint fk_accesos_ref_usuarios foreign key (cod_usuario)
      references usuarios (cod_usuario) on delete restrict on update cascade;

alter table usuarios add constraint fk_usuarios_ref_perfiles foreign key (cod_perfil)
      references perfiles (cod_perfil) on delete restrict on update cascade;

