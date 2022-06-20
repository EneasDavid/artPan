create database artPan;

use artPan;

show tables;

create table padaria(id int auto_increment primary key, 
nome varchar(30) not null unique, 
endereco varchar(20) not null);

desc padaria;

create table produto (id int auto_increment primary key, 
referencia varchar(40) not null,
preco float not null);

desc produto;

create table fornecedor (id int auto_increment primary key, 
nomeFantasia varchar(30) not null, 
cnpj varchar(20) not null);

desc cartao;

show tables;
