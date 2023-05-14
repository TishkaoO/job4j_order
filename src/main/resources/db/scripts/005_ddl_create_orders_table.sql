CREATE TABLE IF NOT EXISTS orders(
id SERIAL PRIMARY KEY,
name VARCHAR not null,
number_order INTEGER,
created_date TIMESTAMP,
status_order_id int not null references status_orders(id),
customer_id int not null references customers(id),
payment_id int not null references payments(id),
foreign_key_dish_id int not null references dishs(dish_id)
);