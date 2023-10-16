CREATE TABLE IF NOT EXISTS customers (
  id INTEGER PRIMARY KEY,
  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL
);

INSERT INTO customers (id, first_name, last_name)
VALUES
(1, 'Arisha', 'Barron'),
(2, 'Branden', 'Gibson'),
(3, 'Rhonda', 'Church'),
(4, 'Georgina', 'Hazel');