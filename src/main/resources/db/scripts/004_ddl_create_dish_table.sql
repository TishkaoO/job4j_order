CREATE TABLE IF NOT EXISTS dish(
id SERIAL PRIMARY KEY,
name VARCHAR not null unique,
description VARCHAR not null,
price VARCHAR not null,
order_id int references orders(id)
);