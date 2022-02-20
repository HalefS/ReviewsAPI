alter table reviews add column created_at timestamp default current_timestamp;
alter table comments add column created_at timestamp default current_timestamp;