CREATE TABLE IF NOT EXISTS orders(
id SERIAL PRIMARY KEY,
name VARCHAR,
number_order INTEGER,
created_date TIMESTAMP,
customer_id int references customer(id),
status_order_id int references status_order(id)
);