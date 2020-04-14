create table user(
	userName varchar(50) primary key,
	password varchar(50) not null
);

create table todo_list (
	id_attivita varchar(50) primary key,
	userName varchar(50) not null,
	ordine_attivita int not null,
	descrizione varchar(255),
	unique(userName,ordine_attivita),
	foreign key (userName) references user(userName)
);