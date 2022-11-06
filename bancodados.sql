use BonVoyage;

create table usuarios (
id int primary key NOT NULL auto_increment,
nome varchar(30) not null,
sobrenome varchar(30),
data_nascimento date,
telefone int,
email varchar(30) not null,
senha varchar (15) not null
);

create table pedidos (
id_pedidos int primary key not null auto_increment,
hospedagem varchar(30),
qntd_passagem int,
qntd_dias int,
destino varchar(30),
data_partida date
);

create table compra (
id_compra int primary key not null auto_increment,
valor_compra decimal,
data_compra date,
pedido_id int,
foreign key (pedido_id) references pedidos (id_pedidos),
usuario_id int,
foreign key (usuario_id) references usuarios (id)
);

create table endereco (
id_endereco int primary key not null auto_increment,
rua varchar(30),
numero int,
cep int,
bairro varchar(30),
cidade varchar(30),
estado varchar(30),
usuario_id int,
foreign key (usuario_id) references usuarios (id)
);