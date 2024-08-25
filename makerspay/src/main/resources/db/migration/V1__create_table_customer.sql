CREATE TABLE customers(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    financial_limit INTEGER NOT NULL,
    balance INTEGER NOT NULL DEFAULT 0
);