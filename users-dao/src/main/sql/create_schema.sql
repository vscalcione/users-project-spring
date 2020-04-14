drop table authorities if exists cascade;
create table authorities (
  authority varchar(50) primary key,
  description varchar(200) not null
);

drop table users if exists cascade;
create table users (
  user_id int auto_increment primary key,
  user_name varchar(50) not null unique,
  password varchar(50) not null,
  enabled boolean not NULL
);

drop table user_authorities if exists cascade;
create table user_authorities (
  user_id int not null,
  authority varchar(50) not null,
  primary key(user_id, authority),
  foreign key(user_id) references users(user_id),
  foreign key(authority) references authorities(authority)
);

drop table groups if exists cascade;
create table groups (
  group_name varchar(50) primary key,
  description varchar(200) not null
);

drop table group_authorities if exists cascade;
create table group_authorities (
  group_name varchar(50) not null,
  authority varchar(50) not null,
  primary key(group_name, authority),
  foreign key(group_name) references groups(group_name),
  foreign key(authority) references authorities(authority)
);

drop table group_members if exists cascade;
create table group_members (
  group_name varchar(50) not null,
  user_id int not null,
  primary key(group_name, user_id),
  foreign key(group_name) references groups(group_name),
  foreign key(user_id) references users(user_id)
);

