create table if not exists author(
    id SERIAL primary key,
    name varchar (255)
    ,last_name varchar (255)
);
create table if not exists book(
    id serial primary key,
    name varchar (255)
    ,genre varchar (255)
    ,price integer
    ,author_id integer  not null
    ,FOREIGN  KEY(author_id) references author(id)
);
