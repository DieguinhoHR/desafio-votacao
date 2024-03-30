create table sessao_votacao (
  id bigint not null auto_increment,
  pauta_id bigint not null,
  data_inicio datetime not null,
  data_fim datetime not null,

  primary key (id)
);

alter table sessao_votacao add constraint fk_sessao_votacao_pauta
foreign key (pauta_id) references pauta (id);