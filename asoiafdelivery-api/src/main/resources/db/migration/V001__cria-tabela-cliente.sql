create table cliente (
id bigint not null auto_increment,
nome varchar(60) not null,
email varchar(200) not null,
telefone varchar(40) not null,

primary key (id)
);