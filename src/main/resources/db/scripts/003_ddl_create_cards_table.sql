CREATE TABLE IF NOT EXISTS cards(
id SERIAL PRIMARY KEY,
name_owner VARCHAR not null unique,
card_number VARCHAR not null unique,
expiry_date TIMESTAMP,
balance INTEGER,
cvv VARCHAR not null unique,
card_id int not null references customers(id)
);
