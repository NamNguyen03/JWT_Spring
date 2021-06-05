create database springSecurity

go 

use springSecurity

go

create table roles(
	id int primary key,
	name  VARCHAR(max) NOT NULL CHECK (name IN('ADMIN', 'ADMIN_TRAINEE', 'CONSUMER'))
)

insert roles(id, [name])
values (0, 'ADMIN')

insert roles(id, [name])
values (1, 'ADMIN_TRAINEE')

insert roles(id, [name])
values (2, 'CONSUMER')

create table users(
	id int primary key,
	username varchar(max),
	password varchar(max),
	fullname varchar(max),
	email varchar(max),
	phone varchar(max),
	address varchar(max),
	role int,
	constraint fk_roleId foreign key (role) references roles(id)
)


insert users(id, username,password ,role)
values (2, 'nam', '$2a$10$xZHbCSVPNVaV2g09XbqhpeMoMcA0fGquZKXeqCAVF3NEHq53lFCja', 0)


