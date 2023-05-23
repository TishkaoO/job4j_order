CREATE TABLE IF NOT EXISTS customer(
id SERIAL PRIMARY KEY,
username VARCHAR not null unique,
password VARCHAR not null,
phoneNumber VARCHAR not null
);