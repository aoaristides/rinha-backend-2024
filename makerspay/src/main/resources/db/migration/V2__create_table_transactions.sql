CREATE TABLE transactions(
    id SERIAL PRIMARY KEY,
    customer_id INTEGER NOT NULL,
    amount INTEGER NOT NULL,
    type VARCHAR(1) NOT NULL,
    description VARCHAR(255) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT NOW(),
    CONSTRAINT fk_customers_transactions_id FOREIGN KEY (customer_id) REFERENCES customers(id)
);