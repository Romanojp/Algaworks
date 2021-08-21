
create table categoria(
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL
)ENGINE=Innodb DEFAULT CHARSET=utf8;


Insert into categoria(nome) values('Lazer');
Insert into categoria(nome) values('Alimentação');
Insert into categoria(nome) values('Supermercado');
Insert into categoria(nome) values('Farmacia');
Insert into categoria(nome) values('Outros');