CREATE TABLE IF NOT EXISTS dish(
id SERIAL PRIMARY KEY,
name VARCHAR not null unique,
description VARCHAR not null,
price VARCHAR not null,
dish_id int not null references orders(id)
);