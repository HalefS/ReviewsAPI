create table products (
    id int auto_increment,
    name varchar(255) not null unique,
    stock_count int not null,
    description varchar(255) not null,
    constraint products_pk primary key (id)
);

create table reviews (
    id int auto_increment,
    title varchar(255) not null,
    stars int not null check(stars >= 1 and stars <= 5),
    product_id int not null,
    constraint reviews_pk primary key (id),
    constraint reviews_products_fk foreign key (product_id) references products(id)
);

create table comments (
    id int auto_incrment,
    content varchar(500) not null,
    review_id int,
    constraint comments_pk primary key (id),
    constraint comments_reviews_fk foreign key (review_id) references reviews(id)
);

