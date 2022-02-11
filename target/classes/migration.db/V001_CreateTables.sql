create table products (
    id int auto_increment,
    name varchar(255) not null unique,
    description varchar(255) not null,
    constraint products_pk primary key (id)
);

create table reviews (
    id int auto_increment,
    title varchar(255) not null,
    stars int not null
)