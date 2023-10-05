create database metodologias_2;
use metodologias_2;
CREATE USER 'UserRemoto'@'localhost' IDENTIFIED BY 'clinica16';
GRANT ALL PRIVILEGES ON * . * TO 'UserRemoto'@'localhost';
FLUSH PRIVILEGES;

drop table paciente;
create table paciente(
nombre varchar(30) primary key,
fecha_nacimiento varchar(40) not null,
estado_civil varchar(30),
nivel_estudios varchar(30),
ocupacion varchar(30) not null
);

drop table usuarios;
create table usuarios(
nombre_usuario varchar(30) primary key,
rol varchar(30) not null,
nombre_completo  varchar(30),
contrasena_usuario varchar(30) not null,
cedula integer(10) null
);

insert into usuarios values("soka","Psicologo","Juan Pablo Lazaro Ruiz","Perrotonto",12345);
insert into usuarios values("frantata","Asistente","Francisco Angel Reyes Jacome","1234",null);
insert into usuarios values("Manu","Psicologo","Jose Manuel Iñiguez Lopez","Gatolisto",6789);
insert into usuarios values("Dangj","Asistente","Daniel Garcia Jacome","Pokemon",null);

select * from usuarios;
select rol from usuarios;
select contrasena_usuario from usuarios;
select nombre_usuario from usuarios;
select cedula from usuarios;
select nombre_completo from usuarios;


insert into paciente values('Juan Pérez', '15/05/1990', 'Casado', 'Licenciatura', 'Ingeniero');
insert into paciente values ('María González', '20/03/1985', 'Soltero', 'Bachillerato', 'Estudiante');
insert into paciente values ('Ana Sánchez', '10/07/1995', 'Casado', 'Bachillerato', 'Abogado');
insert into paciente values ('Luis García', '25/11/1982', 'Soltero', 'Doctorado', 'Profesor');
insert into paciente values ('Laura Rodríguez', '30/09/1998', 'Casado', 'Licenciatura', 'Arquitecto');
insert into paciente values('Carlos López', '12/04/1987', 'Soltero', 'Maestría', 'Contador');
insert into paciente values ('Sofía Martínez', '08/02/1993', 'Casado', 'Bachillerato', 'Enfermero');
insert into paciente values('Diego Torres', '18/06/1997', 'Soltero', 'Licenciatura', 'Programador');
insert into paciente values('Valentina Fernández', '22/08/1991', 'Casado', 'Doctorado', 'Dentista');
insert into paciente values('Miguel Ramírez', '05/12/1989', 'Soltero', 'Maestría', 'Psicólogo');

select * from paciente;
select nombre from paciente;
select fecha_nacimiento from paciente;
select estado_civil from paciente;
select nivel_estudios from paciente;
select ocupacion from paciente;


