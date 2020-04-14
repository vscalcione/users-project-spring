drop table dipendente if exists;
create table dipendente (
	id_matricola integer auto_increment,
	nome varchar(100) not null,
	cognome varchar(100),
	primary key(id_matricola)
);

drop table attivita if exists;
create table attivita (
	id_attivita varchar(36) not null,
	nome_attivita varchar(100) not null,
	data_inizio date not null,
	data_fine date,
	primary key(id_attivita)
);

drop table attivita_dipendente if exists;
create table attivita_dipendente (
	id_attivita varchar(36) not null,
	id_matricola integer auto_increment,
	primary key(id_attivita, id_matricola),
	foreign key (id_attivita)
	  references attivita(id_attivita),
	foreign key (id_matricola)
	  references dipendente(id_matricola)
);
