create table voto (
  id bigint not null auto_increment,
  sessao_votacao_id bigint not null,
  status_voto ENUM('SIM', 'NAO'),
  cpf_eleitor CHAR(11) not null,
  data_hora datetime not null,

  primary key (id)
);

alter table voto add constraint fk_sessao_votacao
foreign key (sessao_votacao_id) references sessao_votacao (id);