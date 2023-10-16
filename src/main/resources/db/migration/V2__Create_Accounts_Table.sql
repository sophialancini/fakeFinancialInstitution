CREATE TABLE IF NOT EXISTS accounts (
  id INTEGER PRIMARY KEY,
  customer_id INTEGER NOT NULL,
  balance DECIMAL(13,4) NOT NULL,
  FOREIGN KEY (customer_id) REFERENCES customers(id)
);

INSERT INTO accounts (id, customer_id, balance)
VALUES
(1, 1, 0.0),
(2, 1, 10000.0),
(3, 2, 9999.9),
(4, 3, -134.0),
(5, 4, 37473.70);