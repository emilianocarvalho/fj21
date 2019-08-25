create database if not exists fj21;

use fj21;

create table if not exists contatos (
	id BIGINT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(255),
	email VARCHAR(255),
	endereco VARCHAR(255),
	dataNascimento DATE,
	primary key (id)
);
