CREATE TABLE IF NOT EXISTS card(
id SERIAL PRIMARY KEY,
name_owner VARCHAR not null unique,
card_number VARCHAR not null unique,
expiry_date TIMESTAMP,
cvv VARCHAR not null unique,
balance INTEGER,
card_id int not null references customer(id)
);
