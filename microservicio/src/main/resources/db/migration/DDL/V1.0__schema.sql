create table afiliado (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 tipo_documento varchar(10) not null,
 numero_documento varchar(20) not null,
 fecha_nacimiento datetime null,
 email varchar(200) not null,
 direccion varchar(100) not null,
 telefono varchar(20) not null,
 fecha_registro datetime null,
 primary key (id)
);

create table entrada (
    id int(11) not null auto_increment,
    numero_funcion int(11) not null ,
    precio double not null,
    nombre_pelicula varchar(100) not null,
    fecha_funcion datetime null,
    primary key (id)
);