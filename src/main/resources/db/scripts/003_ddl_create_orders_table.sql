CREATE TABLE IF NOT EXISTS orders(
id SERIAL PRIMARY KEY,
name VARCHAR not null,
number_order INTEGER,
created_date TIMESTAMP,
order_id int not null references customer(id),
order_id int not null references status_order(id)
);