CREATE TABLE IF NOT EXISTS transferHistory (
    id INTEGER PRIMARY KEY,
    sender_id INTEGER NOT NULL,
    receiver_id INTEGER NOT NULL,
    amount DECIMAL(13,4) NOT NULL,
    FOREIGN KEY (sender_id) REFERENCES accounts(id),
    FOREIGN KEY (receiver_id) REFERENCES accounts(id)
);

INSERT INTO transferHistory (id, sender_id, receiver_id, amount)
VALUES
(1, 1, 2, 666666.6),
(2, 3, 5, 0.80);