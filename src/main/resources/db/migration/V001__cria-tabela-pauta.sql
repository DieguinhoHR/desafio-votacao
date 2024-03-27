create table pauta (
  id bigint not null auto_increment,
  nome varchar(150) not null,
  descricao text,
  data_inicio datetime not null,
  primary key (id)
);