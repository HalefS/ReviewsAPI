create table comments (id bigint not null auto_increment, review_id bigint, primary key (id)) engine=MyISAM;
create table products (id bigint not null auto_increment, description varchar(255) not null, name varchar(255) not null, primary key (id)) engine=MyISAM;
create table reviews (id bigint not null auto_increment, stars integer not null, text varchar(255) not null, title varchar(255) not null, product_id bigint, primary key (id)) engine=MyISAM;
alter table products add constraint UK_o61fmio5yukmmiqgnxf8pnavn unique (name);
alter table comments add constraint FKdpo60i7auk5cudv7kkny8jrqb foreign key (review_id) references reviews (id);
alter table reviews add constraint FKpl51cejpw4gy5swfar8br9ngi foreign key (product_id) references products (id);
