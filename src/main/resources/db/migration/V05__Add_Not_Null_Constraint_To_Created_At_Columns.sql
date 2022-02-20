alter table reviews modify column created_at timestamp not null default current_timestamp;
alter table comments modify column created_at timestamp not null default current_timestamp;