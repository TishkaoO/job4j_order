CREATE TABLE IF NOT EXISTS customers(
id SERIAL PRIMARY KEY,
name VARCHAR not null,
email VARCHAR not null unique,
phoneNumber VARCHAR not null
);