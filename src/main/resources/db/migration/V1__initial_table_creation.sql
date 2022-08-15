CREATE TABLE produto (
id uuid not null,
nome varchar(255) not null,
descricao varchar(255) not null,
categoria varchar(255) not null,
data_cadastro date not null,
data_fabricacao date not null,
preco decimal(10,2) not null,
primary key(id)
);
